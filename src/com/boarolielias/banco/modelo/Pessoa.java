package com.boarolielias.banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pessoa {

    private String nome;
    private String documento;
    private BigDecimal rendimentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;
    private LocalDateTime dtUltimaAtualizacao = LocalDateTime.now(); //essa atribuição pode ser aqui na declaração ou no construtor


    public String getNome() {
        return nome;
    }

    public LocalDateTime getDtUltimaAtualizacao() {
        return dtUltimaAtualizacao;
    }

    public void setDtUltimaAtualizacao(LocalDateTime dtUltimaAtualizacao) {
        this.dtUltimaAtualizacao = dtUltimaAtualizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public BigDecimal getRendimentoAnual() {
        return rendimentoAnual;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public void setRendimentoAnual(BigDecimal rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }
}
