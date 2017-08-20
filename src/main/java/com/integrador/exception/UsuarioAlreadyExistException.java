package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class UsuarioAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsuarioAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public UsuarioAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
