package com.projarc.appsigncontrol.interfaceAdapter.controller;

import com.projarc.appsigncontrol.application.dto.AplicativoDto;
import com.projarc.appsigncontrol.domain.model.AplicativoModel;
import com.projarc.appsigncontrol.domain.service.AplicativoService;
import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;

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
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    @Autowired
    private AplicativoService aplicativoService;

    public AplicativoController(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<AplicativoModel> getAll() {
        return this.aplicativoService.getAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public AplicativoModel getById(@PathVariable Long id) {
        return this.aplicativoService.getById(id);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public AplicativoEntity create(@RequestBody AplicativoDto payload) {
        return this.aplicativoService.create(payload);
    }

    @PostMapping("/atualizacusto/{id}")
    @CrossOrigin(origins = "*")
    public AplicativoEntity updateCost(@PathVariable Long id, @RequestBody AplicativoDto payload) {
        return this.aplicativoService.update(id, payload);
    }
}