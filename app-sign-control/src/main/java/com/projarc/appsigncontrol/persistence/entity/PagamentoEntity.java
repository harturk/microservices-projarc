package com.projarc.appsigncontrol.persistence.entity;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.domain.model.PagamentoModel;

import com.projarc.appsigncontrol.enums.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pagamentos")
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id")
    private long id;

    @ManyToOne()
    @JoinColumn(name = "id_assinatura")
    private AssinaturaEntity assinatura;

    @Column(name = "valorPago", nullable = false)
    private double valorPago;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "promocao", nullable = false, length = 255)
    private String promocao;

    public PagamentoEntity() {

    }

    public PagamentoEntity(long id, AssinaturaEntity assinatura, double valorPago, LocalDate dataPagamento,
            String promocao) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public PagamentoEntity(AssinaturaEntity assinatura, double valorPago, LocalDate dataPagamento,
            String promocao) {
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssinaturaEntity getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(AssinaturaEntity assinatura) {
        this.assinatura = assinatura;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return this.promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public static PagamentoModel toPagamentoModel(PagamentoEntity pagamentoEntity, PagamentoStatus status,
            double valorEstornado) {
        return new PagamentoModel(pagamentoEntity.getId(), pagamentoEntity.getAssinatura().getId(),
                pagamentoEntity.getValorPago(), pagamentoEntity.getDataPagamento(), pagamentoEntity.getPromocao(),
                status, valorEstornado);
    }

    public static PagamentoDto toPagamentoDto(PagamentoEntity pagamentoEntity) {
        return new PagamentoDto(pagamentoEntity.getAssinatura().getId(),
                pagamentoEntity.getValorPago(), pagamentoEntity.getPromocao());
    }
}
