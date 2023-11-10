package com.boarolielias.banco.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        if(getSaldo().compareTo(new BigDecimal("10000")) < 0){
            sacar(new BigDecimal(30));
        }
    }

    public void creditarRendimentos(BigDecimal percentualJuros){
        BigDecimal valorRendimentos = getSaldo().multiply(percentualJuros)
                .divide(new BigDecimal("100"),2, RoundingMode.HALF_EVEN);
        depositar(valorRendimentos);

        // half even: 2.524 arredonda pra 2.52
        //            2.526 arredonda pra 2.53
        // abaixo de 5 arredonda pra baixo, acima de 5 arredonda pra cima.
        //            2.525 arredonda pra cima por conta do dígito antecessor "2"
        // se o dígito antecessor for ímpar, ele arredonda pra cima, ficando: 2.525 = 2.53 pois o 5 é ímpar.
        // Se for par, como 2.425 = 2.4
        // Essa é uma forma de arredondar números cumulativos, dessa forma não irá sempre arredondar nem pra cima nem baixo,
        // vai depender sempre.
    }

}
