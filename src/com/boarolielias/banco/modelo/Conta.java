package com.boarolielias.banco.modelo;

import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;


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

    public void depositar(double valor) {
        if (valor <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        saldo = saldo + valor;
    }

    public void sacar(double valor) {
        if (valor <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }

        if (getSaldoDisponivel() - valor < 0){
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo = saldo - valor;
    }

    //sobrecarga de métodos - overloading: permite a criação de vários métodos com mesmo nome porém com parâmetros diferentes

    public void sacar(double valor, double taxaSaque){
        sacar(valor + taxaSaque);
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

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel(){
        return getSaldo();
    }

}
