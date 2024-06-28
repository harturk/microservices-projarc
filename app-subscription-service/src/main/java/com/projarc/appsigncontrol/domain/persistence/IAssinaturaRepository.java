package com.projarc.appsigncontrol.domain.persistence;

import java.util.List;

import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;

public interface IAssinaturaRepository {
    List<AssinaturaEntity> getAll();

    AssinaturaEntity getOne(long id);

    AssinaturaEntity save(AssinaturaEntity assinaturaEntity);
}
