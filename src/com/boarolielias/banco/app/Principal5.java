package com.boarolielias.banco.app;

import com.boarolielias.banco.modelo.Banco;
import com.boarolielias.banco.modelo.Conta;

import java.math.BigDecimal;
import java.util.Optional;

public class Principal5 {

    public static void main(String[] args) {
        Banco banco = new Banco();

//        banco.buscar(123,222)
//            .ifPresent(conta -> System.out.println(conta.getSaldo()));


//        if (contaOptional.isPresent()) {
//            Conta contaEncontrada = contaOptional.get();
//            System.out.println(contaEncontrada.getSaldo());
//        }
//
//        Conta contaEncontrada = banco.buscar(123,222)
//                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
//
//        System.out.println(contaEncontrada.getSaldo());

        BigDecimal saldo = banco.buscar(123,2222)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);
        System.out.println(saldo);
    }
}
