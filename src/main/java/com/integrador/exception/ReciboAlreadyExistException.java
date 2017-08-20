package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class ReciboAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ReciboAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public ReciboAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
