package com.projarc.appsigncontrol.application.dto;

public class ClienteDto {
    private long id;
    private String nome;
    private String email;

    public ClienteDto(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
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
}
