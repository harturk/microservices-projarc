package com.projarc.appsigncontrol.domain.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projarc.appsigncontrol.application.dto.ClienteDto;
import com.projarc.appsigncontrol.domain.model.ClienteModel;
import com.projarc.appsigncontrol.domain.persistence.IClienteRepository;
import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;

@Service
public class ClienteService {
    @Autowired
    private IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> getAll() {
        List<ClienteEntity> clientes = this.clienteRepository.getAll();
        if (clientes.size() == 0) {
            return new LinkedList<ClienteModel>();
        } else {
            return clientes.stream()
                    .map(cliente -> ClienteEntity.toClienteModel(cliente))
                    .toList();
        }
    }

    public ClienteModel getById(long id) {
        ClienteEntity cliente = clienteRepository.getOne(id);
        if (cliente == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not found");
        }
        return ClienteEntity.toClienteModel(cliente);
    }

    public ClienteEntity create(ClienteDto payload) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(payload.getNome());
        clienteEntity.setEmail(payload.getEmail());
        return this.clienteRepository.save(clienteEntity);
    }
}
