package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class EnderecoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EnderecoNotFoundException(String mensagem) {
        super(mensagem);
    }

    public EnderecoNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
