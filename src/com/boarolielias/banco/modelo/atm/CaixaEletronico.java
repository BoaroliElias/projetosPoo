package com.boarolielias.banco.modelo.atm;

import com.boarolielias.banco.modelo.Conta;
import com.boarolielias.banco.modelo.pagamento.DocumentoEstornavel;
import com.boarolielias.banco.modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta){
        System.out.println("SALDO CONTA");
        System.out.println("Conta: " + conta.getAgencia() + " / " + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento, Conta conta){
        if (documento.estaPago()){
            throw new IllegalArgumentException("Documento já está pago");
        }
        conta.sacar(documento.getValorTotal());
        documento.quitarPagamento();

    }

    public void estornarPagamento(DocumentoEstornavel documento, Conta conta){
        if (!documento.estaPago()){
            throw new IllegalArgumentException("Documento ainda não foi pago. Não é possível estornar.");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();

    }


}
