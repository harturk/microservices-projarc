package com.projarc.appsigncontrol.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.domain.persistence.IAssinaturaRepository;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.persistence.repository.interfaces.IAssinaturaRepositoryJPA;

@Repository
public class AssinaturaRepositoryJPA implements IAssinaturaRepository {
    @Autowired
    private IAssinaturaRepositoryJPA assinatura;

    public AssinaturaRepositoryJPA(IAssinaturaRepositoryJPA assinatura) {
        this.assinatura = assinatura;
    }

    @Override
    public AssinaturaEntity save(AssinaturaEntity assinaturaEntity) {
        return this.assinatura.saveAndFlush(assinaturaEntity);
    }

    @Override
    public List<AssinaturaEntity> getAll() {
        return this.assinatura.findAll();
    }

    @Override
    public AssinaturaEntity getOne(long id) {
        return this.assinatura.getReferenceById(id);
    }
}
