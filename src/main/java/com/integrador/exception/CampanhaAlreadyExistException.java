package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class CampanhaAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CampanhaAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public CampanhaAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
