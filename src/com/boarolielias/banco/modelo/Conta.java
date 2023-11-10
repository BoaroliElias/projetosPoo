package com.boarolielias.banco.modelo;

import com.boarolielias.banco.modelo.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;


    //construtores: todas as classes java possuem construtores que são invocados para instanciar objetos de uma classe.
    // são como se fossem métodos que se executam na inicialização de um objeto que está sendo instanciado
    // quando não declaramos, o compilador do java cria um construtor default
    // nomeDaClasse(atributos da classe como parâmetro){
    // }


    Conta(){

    }

    public Conta(Pessoa titular, int agencia, int numero){
        Objects.requireNonNull(titular); //if nulo, dispara exception
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }

        if (getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo = saldo.subtract(valor);
    }

    //sobrecarga de métodos - overloading: permite a criação de vários métodos com mesmo nome porém com parâmetros diferentes

    public void sacar(BigDecimal valor, BigDecimal taxaSaque){

        sacar(valor.add(taxaSaque));
    }

    public abstract void debitarTarifaMensal();

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaldoDisponivel(){
        return getSaldo();
    }

}
