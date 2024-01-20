package com.boarolielias.banco.app;

import com.boarolielias.banco.modelo.Banco;
import com.boarolielias.banco.modelo.Conta;
import com.boarolielias.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal4 {
    public static void main(String[] args) {
        Banco banco = new Banco();

        List<Pessoa> titulares = banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                .toList();
//                .collect(Collectors.toList());

        System.out.println(titulares);

        BigDecimal saldoTotal = banco.getContas().stream()
                .map(Conta::getSaldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(saldoTotal);


        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
                .filter(conta -> conta.getNumero() > 200)
                .map(Conta::getTitular)
                .distinct() //ele vai funcionar através do método equals
                .forEach(System.out::println);


//        //filtrar apenas contas com saldo maior que 130
//        banco.getContas().stream()
//                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
//                .filter(conta -> conta.getNumero() > 200)
//                .sorted(Comparator.comparingInt(Conta::getNumero))
//                .forEach(conta -> {
////            conta.depositar(new BigDecimal("10"));
//            System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
//        });

        // acima, um encadeamento de chamadas. Para tornar o código mais legível.
        // após o forEach, nao da mais pra encadear, pois é uma função void.

    }
}
