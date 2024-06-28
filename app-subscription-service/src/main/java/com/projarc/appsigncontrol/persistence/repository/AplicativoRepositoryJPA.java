package com.projarc.appsigncontrol.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.domain.persistence.IAplicativoRepository;
import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;
import com.projarc.appsigncontrol.persistence.repository.interfaces.IAplicativoRepositoryJPA;

@Repository
public class AplicativoRepositoryJPA implements IAplicativoRepository {
    @Autowired
    private IAplicativoRepositoryJPA aplicativo;

    public AplicativoRepositoryJPA(IAplicativoRepositoryJPA aplicativo) {
        this.aplicativo = aplicativo;
    }

    @Override
    public AplicativoEntity save(AplicativoEntity assinaturaEntity) {
        return this.aplicativo.saveAndFlush(assinaturaEntity);
    }

    @Override
    public List<AplicativoEntity> getAll() {
        return this.aplicativo.findAll();
    }

    @Override
    public AplicativoEntity getOne(long id) {
        return this.aplicativo.getReferenceById(id);
    }
}
