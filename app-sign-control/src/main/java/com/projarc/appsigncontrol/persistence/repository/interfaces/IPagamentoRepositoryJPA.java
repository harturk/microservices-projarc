package com.projarc.appsigncontrol.persistence.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.appsigncontrol.persistence.entity.PagamentoEntity;

public interface IPagamentoRepositoryJPA extends JpaRepository<PagamentoEntity, Long> {
    List<PagamentoEntity> findAll();

    PagamentoEntity getReferenceById(long id);

    PagamentoEntity saveAndFlush(PagamentoEntity pagamento);
}
