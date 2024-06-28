package com.projarc.appsigncontrol.domain.persistence;

import java.util.List;

import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;

public interface IClienteRepository {
    List<ClienteEntity> getAll();

    ClienteEntity getOne(long id);

    ClienteEntity save(ClienteEntity assinaturaEntity);
}
