package com.projarc.appsigncontrol.persistence.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;

public interface IClienteRepositoryJPA extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAll();

    ClienteEntity getReferenceById(long id);

    ClienteEntity saveAndFlush(ClienteEntity cliente);
}
