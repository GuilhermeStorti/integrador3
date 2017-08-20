package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class FormaPagamentoAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FormaPagamentoAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public FormaPagamentoAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
