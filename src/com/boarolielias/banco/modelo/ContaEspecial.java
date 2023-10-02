package com.boarolielias.banco.modelo;

public class ContaEspecial extends Conta{

    private double valorLimite;

    //criado com botao direito> generate> constructor
    public ContaEspecial(Pessoa titular, int agencia, int numero, double valorLimite) {
        super(titular, agencia, numero);
        this.valorLimite = valorLimite;
    }

    @Override
    public void debitarTarifaMensal() {
        sacar(20);
    }

    @Override
    public double getSaldoDisponivel() {
        return getSaldo() + getValorLimite();
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }


}
