package com.projarc.appsigncontrol.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projarc.appsigncontrol.application.dto.UsuarioDto;
import com.projarc.appsigncontrol.domain.persistence.IUsuarioRepository;
import com.projarc.appsigncontrol.persistence.entity.UsuarioEntity;

@Service
public class UsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    private UsuarioEntity getUsuarioByLogin(String login) {
        List<UsuarioEntity> usuarios = this.usuarioRepository.getAll();
        List<UsuarioEntity> filteredUsuarios = usuarios.stream()
                .filter(usuario -> usuario.getUsuario().equals(login))
                .collect(Collectors.toList());
        // Campo login é unique, logo só poderá haver no maximo 1 registro
        if (filteredUsuarios.size() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credenciais incorretas");
        }
        return filteredUsuarios.get(0);
    }

    public UsuarioEntity validateUsuario(UsuarioDto payload) {
        UsuarioEntity usuario = this.getUsuarioByLogin(payload.getUsuario());

        if (usuario.getSenha().equals(payload.getSenha())) {
            return usuario;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credenciais incorretas");
    }

    public UsuarioEntity saveUsuario(UsuarioDto payload) {
        System.out.println(payload.getSenha());
        System.out.println(payload.getUsuario());
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsuario(payload.getUsuario());
        usuarioEntity.setSenha(payload.getSenha());
        System.out.println(usuarioEntity.getId());
        return this.usuarioRepository.save(usuarioEntity);
    }

    public boolean deleteUsuario(UsuarioDto payload) {
        UsuarioEntity usuario = this.getUsuarioByLogin(payload.getUsuario());

        if (payload.getSenha().equals(usuario.getSenha())) {
            return this.usuarioRepository.delete(usuario);
        }

        return false;
    }
}
