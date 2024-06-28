package com.projarc.appsigncontrol.interfaceAdapter.controller;

import com.projarc.appsigncontrol.application.dto.AssinaturaDto;
import com.projarc.appsigncontrol.domain.model.AssinaturaModel;
import com.projarc.appsigncontrol.domain.service.AssinaturaService;

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
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    @Autowired
    private AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<AssinaturaModel> getAll() {
        return this.assinaturaService.getAll();
    }

    @GetMapping("/{type}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaModel> getByType(@PathVariable String type) {
        return this.assinaturaService.getByType(type);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public AssinaturaDto create(@RequestBody AssinaturaDto payload) {
        return this.assinaturaService.create(payload);
    }

    @GetMapping("/asscli/{codcli}")
    public List<AssinaturaModel> getAssinaturasCliente(@PathVariable int codcli) {
        return this.assinaturaService.getByClient(codcli);
    }

    @GetMapping("/assapp/{codapp}")
    public List<AssinaturaModel> getAssinaturasAplicativo(@PathVariable int codapp) {
        return this.assinaturaService.getByApp(codapp);
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean getAssinaturaStatus(@PathVariable int codass) {
        return this.assinaturaService.isAssinaturaActive(codass);
    }

}