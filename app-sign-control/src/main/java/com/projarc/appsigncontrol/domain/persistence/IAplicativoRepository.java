package com.projarc.appsigncontrol.domain.persistence;

import java.util.List;

import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;

public interface IAplicativoRepository {
    List<AplicativoEntity> getAll();

    AplicativoEntity getOne(long id);

    AplicativoEntity save(AplicativoEntity assinaturaEntity);
}
