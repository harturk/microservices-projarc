package com.projarc.appsigncontrol.persistence.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;

public interface IAssinaturaRepositoryJPA extends JpaRepository<AssinaturaEntity, Long> {
    List<AssinaturaEntity> findAll();

    AssinaturaEntity getReferenceById(long id);

    AssinaturaEntity saveAndFlush(AssinaturaEntity assinatura);
}
