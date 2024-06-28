package com.projarc.appsigncontrol.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.domain.persistence.IClienteRepository;
import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;
import com.projarc.appsigncontrol.persistence.repository.interfaces.IClienteRepositoryJPA;

@Repository
public class ClienteRepositoryJPA implements IClienteRepository {
    @Autowired
    private IClienteRepositoryJPA cliente;

    public ClienteRepositoryJPA(IClienteRepositoryJPA cliente) {
        this.cliente = cliente;
    }

    @Override
    public ClienteEntity save(ClienteEntity clienteEntity) {
        return this.cliente.saveAndFlush(clienteEntity);
    }

    @Override
    public List<ClienteEntity> getAll() {
        return this.cliente.findAll();
    }

    @Override
    public ClienteEntity getOne(long id) {
        return this.cliente.getReferenceById(id);
    }
}
