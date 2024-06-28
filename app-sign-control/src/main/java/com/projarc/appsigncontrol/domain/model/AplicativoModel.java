package com.projarc.appsigncontrol.domain.model;

import com.projarc.appsigncontrol.application.dto.AplicativoDto;

public class AplicativoModel {

    private long id;
    private String nome;
    private double custoMensal;

    public AplicativoModel(long id, String nome, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoMensal() {
        return this.custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    public static AplicativoDto fromModel(AplicativoModel aplicativoModel) {
        return new AplicativoDto(aplicativoModel.getId(), aplicativoModel.getNome(),
                aplicativoModel.getCustoMensal());
    }
}
