package com.projarc.appsigncontrol.persistence.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;

public interface IAplicativoRepositoryJPA extends JpaRepository<AplicativoEntity, Long> {
    List<AplicativoEntity> findAll();

    AplicativoEntity getReferenceById(long id);

    AplicativoEntity saveAndFlush(AplicativoEntity aplicativo);
}
