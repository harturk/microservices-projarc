package com.projarc.appsigncontrol.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import com.projarc.appsigncontrol.domain.model.ClienteModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    public ClienteEntity() {
    }

    public ClienteEntity(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public static ClienteEntity fromClienteModel(ClienteModel clienteModel) {
        return new ClienteEntity(clienteModel.getId(), clienteModel.getName(), clienteModel.getEmail());
    }

    public static ClienteModel toClienteModel(ClienteEntity clienteEntity) {
        return new ClienteModel(clienteEntity.getId(), clienteEntity.getNome(), clienteEntity.getEmail());
    }
}
