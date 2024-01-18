package com.boarolielias.banco.app;

import com.boarolielias.banco.modelo.Banco;
import com.boarolielias.banco.modelo.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Principal3 {

    public static void main(String[] args) {
        Banco banco = new Banco();

        // as 3 linhas abaixo, tem a mesma funcionalidade da classe NumeroContaFunction criada, com o método applyAsInt.
//        ToIntFunction<Conta> function = (Conta conta) -> {
//            return conta.getNumero();
//        };

        // esse metodo sort, vai executar um algoritimo de ordenação
//        banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));

        // enxugando mais ainda, fazendo as linhas 15,16,17 se transformarem nesse única linha 23.
        // nao precisa do tipo da parametro (nome da classe), pq o método faz a Inferência de tipo;
        // nao precisa dos parênteses se tiver só um argumento.
//        banco.getContas().sort(Comparator.comparingInt(conta -> conta.getNumero()));

        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

        for (Conta conta : banco.getContas()){
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
