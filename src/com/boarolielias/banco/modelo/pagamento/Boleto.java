package com.boarolielias.banco.modelo.pagamento;

public class Boleto implements DocumentoPagavel {


    @Override
    public double getValorTotal() {
        return 0;
    }

    @Override
    public boolean estaPago() {
        return false;
    }

    @Override
    public void quitarPagamento() {

    }

    //quando uma classe implementa uma interface, e essa interface implementa metodos abstratos, a classe também tem que implementar esses métodos.
}
