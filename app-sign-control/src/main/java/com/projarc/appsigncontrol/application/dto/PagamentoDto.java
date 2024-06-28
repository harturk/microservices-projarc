package com.projarc.appsigncontrol.application.dto;

import java.time.LocalDate;

public class PagamentoDto {
    private long id;

    private long assinaturaId;

    private double valorPago;

    private LocalDate dataPagamento;

    private String promocao;

    public PagamentoDto(long assinaturaId, double valorPago, String promocao) {
        this.assinaturaId = assinaturaId;
        this.valorPago = valorPago;
        this.promocao = promocao;
    }

    public long getId() {
        return this.id;
    }

    public long getAssinaturaId() {
        return this.assinaturaId;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public String getPromocao() {
        return this.promocao;
    }

}
