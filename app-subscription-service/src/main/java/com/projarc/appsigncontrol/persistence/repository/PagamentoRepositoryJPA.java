package com.projarc.appsigncontrol.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.domain.persistence.IPagamentoRepository;
import com.projarc.appsigncontrol.persistence.entity.PagamentoEntity;
import com.projarc.appsigncontrol.persistence.repository.interfaces.IPagamentoRepositoryJPA;

@Repository
public class PagamentoRepositoryJPA implements IPagamentoRepository {
    @Autowired
    private IPagamentoRepositoryJPA pagamento;

    public PagamentoRepositoryJPA(IPagamentoRepositoryJPA pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public PagamentoEntity save(PagamentoEntity pagamento) {
        return this.pagamento.saveAndFlush(pagamento);
    }
}
