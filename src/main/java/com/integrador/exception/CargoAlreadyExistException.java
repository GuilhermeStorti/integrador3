package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class CargoAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CargoAlreadyExistException(String mensagem) {
        super(mensagem);
    }

    public CargoAlreadyExistException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
