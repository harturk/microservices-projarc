package com.projarc.appsigncontrol.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import com.projarc.appsigncontrol.domain.model.AplicativoModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aplicativos")
public class AplicativoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "custo_mensal", nullable = false)
    private double custoMensal;

    public AplicativoEntity(String nome, double custoMensal) {
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public AplicativoEntity() {
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

    public static AplicativoEntity fromAplicativoModel(AplicativoModel aplicativoModel) {
        return new AplicativoEntity(aplicativoModel.getNome(),
                aplicativoModel.getCustoMensal());
    }

    public static AplicativoModel toAplicativoModel(AplicativoEntity aplicativoEntity) {
        return new AplicativoModel(aplicativoEntity.getId(), aplicativoEntity.getNome(),
                aplicativoEntity.getCustoMensal());
    }

    public String toString() {
        return "id: " + this.id + "\n nome: " + this.nome + "\n custoMensal: " + this.custoMensal;
    }
}
