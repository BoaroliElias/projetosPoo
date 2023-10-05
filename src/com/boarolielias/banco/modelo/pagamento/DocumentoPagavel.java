package com.boarolielias.banco.modelo.pagamento;

public interface DocumentoPagavel {

    //aqui é o local onde estabelecemos um contrato, uma norma. Define quais comportamentos um documento pagavel deve ter

    /*public abstract*/ double getValorTotal();
    boolean estaPago();
    void quitarPagamento();

}
