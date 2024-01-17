package com.boarolielias.banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private String documento;
    private BigDecimal rendimentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;
    private LocalDateTime dtUltimaAtualizacao = LocalDateTime.now(); //essa atribuição pode ser aqui na declaração ou no construtor

    public Pessoa(){

    }

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

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


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipo=" + tipo +
                '}';
    }

//    //gerando na mao equals e hashcode
//    @Override
//    public boolean equals(Object obj){
//        if (this == obj) return true;
//        if (obj == null) return false;
//        if (getClass() != obj.getClass()) return false;
//
//        //como se fosse dessa forma: Pessoa pessoa = (Pessoa) obj;
//        return documento.equals(((Pessoa) obj).documento);
//        //prórpria IDE fez um cast
//    }
    //se vc quer comparar conteúdo, usa o .equals
    // se vc quer comparar instância (endereço de memória) usa o operador ==


//    @Override
//    public int hashCode() {
//        return ;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return documento.equals(pessoa.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
