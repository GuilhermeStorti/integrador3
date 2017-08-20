package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class ReciboNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ReciboNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ReciboNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
