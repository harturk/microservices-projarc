package com.projarc.appsigncontrol.interfaceAdapter.controller;

import com.projarc.appsigncontrol.application.dto.ClienteDto;
import com.projarc.appsigncontrol.domain.model.ClienteModel;
import com.projarc.appsigncontrol.domain.service.ClienteService;
import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servcad/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<ClienteModel> getAll() {
        return this.clienteService.getAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ClienteModel getById(@PathVariable Long id) {
        return this.clienteService.getById(id);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ClienteEntity create(@RequestBody ClienteDto payload) {
        return this.clienteService.create(payload);
    }
}