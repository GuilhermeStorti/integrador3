package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class FuncionarioAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FuncionarioAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
