package com.boarolielias.banco.modelo.pagamento;

public interface DocumentoEstornavel extends DocumentoPagavel{ //herança de interface também

    void estornarPagamento();

}
