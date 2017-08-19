package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class CampanhaNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CampanhaNotFoundException(String mensagem) {
        super(mensagem);
    }

    public CampanhaNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
