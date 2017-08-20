package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class FormaPagamentoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FormaPagamentoNotFoundException(String mensagem) {
        super(mensagem);
    }

    public FormaPagamentoNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
