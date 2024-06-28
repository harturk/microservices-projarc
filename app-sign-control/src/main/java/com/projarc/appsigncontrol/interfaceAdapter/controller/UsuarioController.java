package com.projarc.appsigncontrol.interfaceAdapter.controller;

import com.projarc.appsigncontrol.application.dto.UsuarioDto;
import com.projarc.appsigncontrol.domain.service.UsuarioService;
import com.projarc.appsigncontrol.persistence.entity.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/servcad/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public UsuarioEntity create(@RequestBody UsuarioDto payload) {
        return this.usuarioService.saveUsuario(payload);
    }

    @GetMapping
    public UsuarioEntity validate(UsuarioDto payload) {
        return this.usuarioService.validateUsuario(payload);
    }

    @DeleteMapping
    public boolean delete(@RequestBody UsuarioDto payload) {
        return this.usuarioService.deleteUsuario(payload);
    }

}
