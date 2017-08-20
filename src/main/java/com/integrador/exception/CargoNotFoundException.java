package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class CargoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CargoNotFoundException(String mensagem) {
        super(mensagem);
    }

    public CargoNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
