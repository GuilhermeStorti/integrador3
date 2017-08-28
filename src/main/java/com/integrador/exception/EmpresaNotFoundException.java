package com.integrador.exception;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public class EmpresaNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmpresaNotFoundException( String mensagem) {
        super(mensagem);
    }

    public EmpresaNotFoundException( String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
