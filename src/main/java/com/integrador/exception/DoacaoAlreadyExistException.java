package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class DoacaoAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DoacaoAlreadyExistException( String mensagem) {
        super(mensagem);
    }

    public DoacaoAlreadyExistException( String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
