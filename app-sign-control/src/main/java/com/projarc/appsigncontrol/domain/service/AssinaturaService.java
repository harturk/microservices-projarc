package com.projarc.appsigncontrol.domain.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projarc.appsigncontrol.application.dto.AssinaturaDto;
import com.projarc.appsigncontrol.domain.model.AssinaturaModel;
import com.projarc.appsigncontrol.domain.persistence.IAplicativoRepository;
import com.projarc.appsigncontrol.domain.persistence.IAssinaturaRepository;
import com.projarc.appsigncontrol.domain.persistence.IClienteRepository;
import com.projarc.appsigncontrol.enums.AssinaturaStatus;
import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;

import java.util.stream.Collectors;

@Service
public class AssinaturaService {
    @Autowired
    private IAssinaturaRepository assinaturaRepository;
    private IAplicativoRepository aplicativoRepository;
    private IClienteRepository clienteRepository;

    public AssinaturaService(IAssinaturaRepository assinaturaRepository,
            IAplicativoRepository aplicativoRepository,
            IClienteRepository clienteRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.aplicativoRepository = aplicativoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<AssinaturaModel> getAll() {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.getAll();
        if (assinaturas.size() == 0) {
            return new LinkedList<AssinaturaModel>();
        } else {
            return assinaturas.stream()
                    .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
                    .toList();
        }
    }

    public AssinaturaEntity getById(long id) {
        try {
            return assinaturaRepository.getOne(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not found");
        }
    }

    public List<AssinaturaModel> getByType(String type) {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.getAll();
        List<AssinaturaModel> assinaturasModel = assinaturas.stream()
                .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
                .toList();

        if (AssinaturaStatus.getType(type) == AssinaturaStatus.ATIVA) {
            assinaturasModel = assinaturasModel.stream()
                    .filter(assinatura -> assinatura.getStatus() == AssinaturaStatus.ATIVA)
                    .collect(Collectors.toList());
            return assinaturasModel;
        }

        if (AssinaturaStatus.getType(type) == AssinaturaStatus.CANCELADA) {
            assinaturasModel = assinaturasModel.stream()
                    .filter(assinatura -> assinatura.getStatus() == AssinaturaStatus.CANCELADA)
                    .collect(Collectors.toList());
            return assinaturasModel;
        }

        return assinaturasModel;

    }

    public List<AssinaturaModel> getByClient(int id) {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.getAll();

        List<AssinaturaModel> assinaturasModel = assinaturas.stream()
                .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
                .toList();

        List<AssinaturaModel> filteredAssinaturas = assinaturasModel.stream()
                .filter(assinatura -> assinatura.getCliente().getId() == id)
                .collect(Collectors.toList());

        return filteredAssinaturas;
    }

    public List<AssinaturaModel> getByApp(int id) {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.getAll();

        List<AssinaturaModel> assinaturasModel = assinaturas.stream()
                .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
                .toList();

        List<AssinaturaModel> filteredAssinaturas = assinaturasModel.stream()
                .filter(assinatura -> assinatura.getAplicativo().getId() == id)
                .collect(Collectors.toList());

        return filteredAssinaturas;
    }

    public AssinaturaEntity renew(AssinaturaEntity assinatura) {
        return this.assinaturaRepository.save(assinatura);
    }

    public AssinaturaDto create(AssinaturaDto payload) {
        AplicativoEntity aplicativo = aplicativoRepository.getOne(payload.getIdAplicativo());
        ClienteEntity cliente = clienteRepository.getOne(payload.getIdCliente());
        if (aplicativo == null || cliente == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not found");
        }

        AssinaturaEntity assinaturaEntity = new AssinaturaEntity();
        assinaturaEntity.setAplicativo(aplicativo);
        assinaturaEntity.setCliente(cliente);
        assinaturaEntity.setInicioVigencia(LocalDate.now());
        // Sempre que uma assinatura for cadastrada, o cliente ganha 7 dias grátis
        assinaturaEntity.setDataFim(assinaturaEntity.getInicioVigencia().plusDays(7));

        AssinaturaEntity createdAssinatura = this.assinaturaRepository.save(assinaturaEntity);
        return AssinaturaEntity.toAssinaturaDto(createdAssinatura);
    }

    public boolean isAssinaturaActive(long id) {
        try {
            AssinaturaEntity assinatura = this.assinaturaRepository.getOne(id);
            return AssinaturaEntity.toAssinaturaModel(assinatura).getStatus() == AssinaturaStatus.ATIVA;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not found");
        }
    }
}
