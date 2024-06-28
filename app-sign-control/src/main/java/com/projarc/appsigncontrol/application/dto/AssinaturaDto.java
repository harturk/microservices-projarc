package com.projarc.appsigncontrol.application.dto;

import java.time.LocalDate;

public class AssinaturaDto {
    private long id;
    private long idAplicativo;
    private long idCliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    public AssinaturaDto(long id, long idAplicativo, long idCliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.id = id;
        this.idAplicativo = idAplicativo;
        this.idCliente = idCliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAplicativo() {
        return this.idAplicativo;
    }

    public long getIdCliente() {
        return this.idCliente;
    }

    public LocalDate getInicioVigencia() {
        return this.inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return this.fimVigencia;
    }

}
