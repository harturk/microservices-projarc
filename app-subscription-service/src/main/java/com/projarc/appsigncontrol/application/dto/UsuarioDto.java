package com.projarc.appsigncontrol.application.dto;

public class UsuarioDto {
    private String usuario;
    private String senha;

    public UsuarioDto(long id, String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
