package com.projarc.appsigncontrol.interfaceAdapter.controller;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.domain.model.PagamentoModel;
import com.projarc.appsigncontrol.domain.service.PagamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servcad")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/registrarpagamento")
    @CrossOrigin(origins = "*")
    public PagamentoModel create(@RequestBody PagamentoDto payload) {
        return this.pagamentoService.create(payload);
    }
}
