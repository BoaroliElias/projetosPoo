package com.boarolielias.banco.app;

import com.boarolielias.banco.modelo.*;
import com.boarolielias.banco.modelo.atm.CaixaEletronico;
import com.boarolielias.banco.modelo.pagamento.DocumentoPagavel;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("joao da silva");
        titular1.setDocumento("123456789");


        Pessoa titular2 = new Pessoa();
        titular2.setNome("maria abadia");
        titular2.setDocumento("6664448777");

        CaixaEletronico caixaEletronico = new CaixaEletronico();



        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987); // atua no construtor com parâmetro
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, 1000);

        //Conta conta = new Conta(titular1, 123, 987); // instanciar uma conta do tipo conta apenas, nao deve ser possível no nosso negócio.
        // Para isso, a classe conta deve ser uma classe abstrata

        //após implementar um método de depositar tarifa de forma abstrata

//        Conta conta = minhaConta;
//        conta.debitarTarifaMensal();

        minhaConta.depositar(15_000);
        minhaConta.sacar(1_000);
        minhaConta.creditarRendimentos(0.8);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        suaConta.debitarTarifaMensal();

        //caixaEletronico.pagar(, minhaConta); // para ter uma instancia da interface, precisamos ter uma classe concreta que implemente esse contrato.

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println("--");
        caixaEletronico.imprimirSaldo(suaConta);

    }
}
