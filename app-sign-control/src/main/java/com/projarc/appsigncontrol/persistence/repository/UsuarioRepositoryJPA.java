package com.projarc.appsigncontrol.persistence.repository;

import java.util.List;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.domain.persistence.IUsuarioRepository;
import com.projarc.appsigncontrol.persistence.entity.UsuarioEntity;
import com.projarc.appsigncontrol.persistence.repository.interfaces.IUsuarioRepositoryJPA;

@Repository
public class UsuarioRepositoryJPA implements IUsuarioRepository {
    @Autowired
    private IUsuarioRepositoryJPA usuario;

    public UsuarioRepositoryJPA(IUsuarioRepositoryJPA usuario) {
        this.usuario = usuario;
    }

    @Override
    public UsuarioEntity save(UsuarioEntity usuarioEntity) {
        return this.usuario.saveAndFlush(usuarioEntity);
    }

    @Override
    public List<UsuarioEntity> getAll() {
        return this.usuario.findAll();
    }

    @Override
    public UsuarioEntity getOne(long id) {
        return this.usuario.getReferenceById(id);
    }

    @Override
    public boolean delete(UsuarioEntity usuarioEntity) {
        // Gambi - Adiciona o ID em uma linkedlist porque o método espera um iterable
        LinkedList<Long> usuarios = new LinkedList<>();
        usuarios.add(usuarioEntity.getId());
        this.usuario.deleteAllByIdInBatch(usuarios);
        return true;
    }
}
