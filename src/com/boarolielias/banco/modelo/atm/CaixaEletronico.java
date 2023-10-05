package com.boarolielias.banco.modelo.atm;

import com.boarolielias.banco.modelo.Conta;
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


}
