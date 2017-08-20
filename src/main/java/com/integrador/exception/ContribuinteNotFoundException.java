package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class ContribuinteNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ContribuinteNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ContribuinteNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
