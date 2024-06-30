package com.projarc.appsigncontrol.domain.service;

import java.security.InvalidParameterException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.domain.model.PagamentoModel;
import com.projarc.appsigncontrol.domain.persistence.IPagamentoRepository;
import com.projarc.appsigncontrol.enums.Promocoes;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.persistence.entity.PagamentoEntity;
import com.projarc.appsigncontrol.enums.PagamentoStatus;

import java.time.LocalDate;

@Service
public class PagamentoService {
    @Autowired
    private IPagamentoRepository pagamentoRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    private AssinaturaService assinaturaService;

    public PagamentoService(IPagamentoRepository pagamentoRepository, AssinaturaService assinaturaService) {
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaService = assinaturaService;
    }

    public PagamentoModel create(PagamentoDto payload) {
        AssinaturaEntity assinatura = this.assinaturaService.getById(payload.getAssinaturaId());
        if (assinatura == null)
            throw new InvalidParameterException();

        if (AssinaturaEntity.isAssinaturaAtiva(assinatura.getFimVigencia())) {
            // Adiciona-se 30 dias ao fim da vigencia
            assinatura.setDataFim(assinatura.getFimVigencia().plusMonths(1));
        } else {
            // Renovada a assinatura com a data atual
            assinatura.setInicioVigencia(LocalDate.now());
            assinatura.setDataFim(LocalDate.now().plusDays(30));
        }
        Promocoes promo = Promocoes.valueOf(payload.getPromocao());

        double valorEstornado = payload.getValorPago()
                - assinatura.getAplicativo().getCustoMensal() * (1 - promo.getDiscount());
        PagamentoStatus status = PagamentoStatus.PAGAMENTO_OK;

        double valorPago = payload.getValorPago() - valorEstornado;

        if (valorEstornado < 0) {
            status = PagamentoStatus.VALOR_INCORRETO;
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(
                    "Valor de pagamento menor que da assinatura (R$ %f)", assinatura.getAplicativo().getCustoMensal()));
        }

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setAssinatura(assinatura);
        pagamentoEntity.setDataPagamento(LocalDate.now());
        pagamentoEntity.setValorPago(valorPago);
        pagamentoEntity.setPromocao(payload.getPromocao());

        PagamentoEntity newPayment = this.pagamentoRepository.save(pagamentoEntity);
        this.assinaturaService.renew(assinatura);

        rabbitTemplate.convertAndSend("appsigncontrol.v1.subscription-update", "", PagamentoEntity.toPagamentoModel(newPayment, status, valorEstornado));

        return PagamentoEntity.toPagamentoModel(newPayment, status, valorEstornado);
    }
}
