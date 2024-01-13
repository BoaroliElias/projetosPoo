package com.boarolielias.banco.app;

import com.boarolielias.banco.modelo.Pessoa;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

public class Principal2 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Joao Da Silva", "123456789");
        Pessoa pessoa2 = new Pessoa("Maria Da Silva", "1234577789");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

//        System.out.println(pessoas);

//        Pessoa pessoa3 = pessoas.get(1);
//        System.out.println(pessoa3);

        //percorrer a lista usando for

//        for (int i=0; i < pessoas.size(); i++){
//            System.out.println(pessoas.get(i).getNome());
//        }

        //percorrer a lista usando o enhanced-for

//        for (Pessoa pessoa : pessoas) {
//            System.out.println(pessoa.getNome());
//        }

        Pessoa pessoa4 = new Pessoa("Joao Da Silva", "123456789");

        boolean existe = pessoas.contains(pessoa4);
        System.out.println(existe);

    }




}
