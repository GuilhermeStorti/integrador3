package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class TabulacaoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TabulacaoNotFoundException(String mensagem) {
        super(mensagem);
    }

    public TabulacaoNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
