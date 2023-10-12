package com.boarolielias.banco.modelo.excecao;

public class SaldoInsuficienteException extends RuntimeException{
    //Exception: é uma "check exception", é quando somos obrigado a tratar essa exceção
    //RunTimeexception é uma exceção não checada, não sendo obrigada a tratar
    // É uma boa prática lançar exceções específicas e não genéricas

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
