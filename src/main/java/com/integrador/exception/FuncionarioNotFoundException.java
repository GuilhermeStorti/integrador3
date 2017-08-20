package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class FuncionarioNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FuncionarioNotFoundException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
