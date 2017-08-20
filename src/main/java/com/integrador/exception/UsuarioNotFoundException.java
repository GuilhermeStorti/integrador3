package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class UsuarioNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UsuarioNotFoundException(String mensagem) {
        super(mensagem);
    }

    public UsuarioNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
