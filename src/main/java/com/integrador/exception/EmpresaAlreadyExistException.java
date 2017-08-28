package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class EmpresaAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmpresaAlreadyExistException( String mensagem) {
        super(mensagem);
    }

    public EmpresaAlreadyExistException( String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
