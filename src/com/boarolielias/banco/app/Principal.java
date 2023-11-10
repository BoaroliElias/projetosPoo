package com.boarolielias.banco.app;

import com.boarolielias.banco.modelo.*;
import com.boarolielias.banco.modelo.atm.CaixaEletronico;
import com.boarolielias.banco.modelo.excecao.SaldoInsuficienteException;
import com.boarolielias.banco.modelo.pagamento.Boleto;
import com.boarolielias.banco.modelo.pagamento.DocumentoPagavel;
import com.boarolielias.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("joao da silva");
        titular1.setDocumento("123456789");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        titular1.setDtUltimaAtualizacao(LocalDateTime.parse("2023-11-09T13:20:00"));//precisamos passar uma instância LocalDateTime usando o Parse  vai converter uma string em um localdatetime
        System.out.println(titular1.getDtUltimaAtualizacao());

        BigDecimal rendimento = titular1.getRendimentoAnual();

        Pessoa titular2 = new Pessoa();
        titular2.setNome("maria abadia");
        titular2.setDocumento("6664448777");

        CaixaEletronico caixaEletronico = new CaixaEletronico();



        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987); // atua no construtor com parâmetro
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, new BigDecimal(1000));

        //Conta conta = new Conta(titular1, 123, 987); // instanciar uma conta do tipo conta apenas, nao deve ser possível no nosso negócio.
        // Para isso, a classe conta deve ser uma classe abstrata

        //após implementar um método de depositar tarifa de forma abstrata

//        Conta conta = minhaConta;
//        conta.debitarTarifaMensal();

        try{
            minhaConta.depositar(new BigDecimal(30000));
            minhaConta.sacar(new BigDecimal(1000));

            suaConta.depositar(new BigDecimal(15000));
            suaConta.sacar(new BigDecimal(15500));
            suaConta.debitarTarifaMensal();

            //caixaEletronico.pagar(, minhaConta); // para ter uma instancia da interface, precisamos ter uma classe concreta que implemente esse contrato.
            Boleto boletoEscola = new Boleto(titular2,new BigDecimal(35000));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal(100), 160);

            caixaEletronico.pagar(boletoEscola,minhaConta);
            caixaEletronico.pagar(salarioFuncionario,minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();

        } catch (SaldoInsuficienteException e){
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

//        System.out.println("Boleto pago: " + boletoEscola.estaPago());
//        System.out.println("Salario pago: " + salarioFuncionario.estaPago());
//

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println("--");
        caixaEletronico.imprimirSaldo(suaConta);

    }
}
