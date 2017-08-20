package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class TabulacaoAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TabulacaoAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public TabulacaoAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
