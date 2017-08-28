package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class DoacaoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DoacaoNotFoundException( String mensagem) {
        super(mensagem);
    }

    public DoacaoNotFoundException( String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
