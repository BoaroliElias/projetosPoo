package com.boarolielias.banco.modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {

    //aqui é o local onde estabelecemos um contrato, uma norma. Define quais comportamentos um documento pagavel deve ter
    // interfaces é um nível de abstração ainda maior que as classes abstratas. Elas foram criadas para não ter qualquer implementação nela
    // mas só pra definir um contrato.

    /*public abstract*/ BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();
    default void imprimirRecibo(){
        System.out.println("RECIBO:");
        System.out.println("Valor Total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }

}
