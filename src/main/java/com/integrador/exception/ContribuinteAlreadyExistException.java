package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class ContribuinteAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ContribuinteAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public ContribuinteAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
