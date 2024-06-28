package com.projarc.appsigncontrol.domain.persistence;

import java.util.List;

import com.projarc.appsigncontrol.persistence.entity.UsuarioEntity;

public interface IUsuarioRepository {
    List<UsuarioEntity> getAll();

    UsuarioEntity getOne(long id);

    UsuarioEntity save(UsuarioEntity assinaturaEntity);

    boolean delete(UsuarioEntity assinaturaEntity);
}
