package com.projarc.appsigncontrol.domain.model;

import com.projarc.appsigncontrol.application.dto.ClienteDto;

public class ClienteModel {
    private long id;
    private String name;
    private String email;

    public ClienteModel(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public static ClienteDto fromModel(ClienteModel clienteModel) {
        return new ClienteDto(clienteModel.getId(), clienteModel.getName(), clienteModel.getEmail());
    }
}
