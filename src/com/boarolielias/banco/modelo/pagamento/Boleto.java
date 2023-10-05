package com.boarolielias.banco.modelo.pagamento;

import com.boarolielias.banco.modelo.Pessoa;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel {


    private Pessoa beneficiario;
    private double valor;
    private boolean pago;


    public Boleto(Pessoa beneficiario, double valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public double getValorTotal() {
        return valor;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void estornarPagamento() {
        pago = false;
    }

    @Override
    public void quitarPagamento() {
        pago = true;

    }

    //quando uma classe implementa uma interface, e essa interface implementa metodos abstratos, a classe também tem que implementar esses métodos.




}
