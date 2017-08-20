package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class EnderecoAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EnderecoAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public EnderecoAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
