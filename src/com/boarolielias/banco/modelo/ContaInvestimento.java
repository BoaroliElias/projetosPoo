package com.boarolielias.banco.modelo;

public class ContaInvestimento extends Conta{
    // tem como caractérisitcas, realizar rendimentos
    //  podemos herdar as características de conta através da herança, usando EXTENDS
    // dizemos que contaInvestimento é um tipo de conta, ou uma subclasse de conta.
    // Classe conta é uma superclasse (ou classe pai)
    // Não deve ser usado a herança para reaproveitar código de uma classe que não tem nada haver

    public ContaInvestimento(Pessoa titular, int agencia, int numero){
        super(titular, agencia, numero); //chama o contrutor da superclasse, porém para chamar o construtor
                 // com parâmetros deve passar os parâmetros no super também
    }

    @Override
    public void debitarTarifaMensal() {
        if(getSaldo() < 10_000){
            sacar(30);
        }
    }

    public void creditarRendimentos(double percentualJuros){
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
    }

}
