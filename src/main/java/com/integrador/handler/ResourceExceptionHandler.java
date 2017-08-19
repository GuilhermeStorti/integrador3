package com.integrador.handler;

import com.integrador.exception.CampanhaAlreadyExistException;
import com.integrador.exception.CampanhaNotFoundException;
import com.integrador.exception.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guilhermeplasma on 19/08/17.
 */

@ControllerAdvice

public class ResourceExceptionHandler {

    private static final String errorNove = "http://erros.teste.com/409";
    private static final String errorQuatro = "http://erros.teste.com/404";

    /*@ExceptionHandler(CampanhaNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerCampanhaNotFoundException(CampanhaNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("Campanha not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CampanhaAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerCampanhaAlreadyExistException(CampanhaAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("Campanha already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }*/

}
