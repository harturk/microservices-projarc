package com.projarc.appsigncontrol.application.dto;

public class AplicativoDto {
    private long id;
    private String nome;
    private double custoMensal;

    public AplicativoDto(long id, String nome, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getCustoMensal() {
        return this.custoMensal;
    }

}
