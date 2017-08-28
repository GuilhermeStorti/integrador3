package com.integrador.handler;

import com.integrador.exception.CampanhaAlreadyExistException;
import com.integrador.exception.CampanhaNotFoundException;
import com.integrador.exception.CargoAlreadyExistException;
import com.integrador.exception.CargoNotFoundException;
import com.integrador.exception.ContribuinteAlreadyExistException;
import com.integrador.exception.ContribuinteNotFoundException;
import com.integrador.exception.EnderecoAlreadyExistException;
import com.integrador.exception.EnderecoNotFoundException;
import com.integrador.exception.ErrorDetails;
import com.integrador.exception.FormaPagamentoAlreadyExistException;
import com.integrador.exception.FormaPagamentoNotFoundException;
import com.integrador.exception.FuncionarioAlreadyExistException;
import com.integrador.exception.FuncionarioNotFoundException;
import com.integrador.exception.DoacaoAlreadyExistException;
import com.integrador.exception.DoacaoNotFoundException;
import com.integrador.exception.UsuarioAlreadyExistException;
import com.integrador.exception.UsuarioNotFoundException;
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

    @ExceptionHandler(CampanhaNotFoundException.class)
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
    }

    @ExceptionHandler(CargoNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerCargoNotFoundException(CargoNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("Cargo not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CargoAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerCargoAlreadyExistException(CargoAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("Cargo already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(ContribuinteNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerContribuinteNotFoundException(ContribuinteNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("Contribuinte not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ContribuinteAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerContribuinteAlreadyExistException(ContribuinteAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("Contribuinte already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerEnderecoNotFoundException(EnderecoNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("Endereco not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EnderecoAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerEnderecoAlreadyExistException(EnderecoAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("Endereco already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(FormaPagamentoNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerFormaPagamentoNotFoundException(FormaPagamentoNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("FormaPagamento not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(FormaPagamentoAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerFormaPagamentoAlreadyExistException(FormaPagamentoAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("FormaPagamento already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(FuncionarioNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerFuncionarioNotFoundException(FuncionarioNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("Funcionario not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(FuncionarioAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerFuncionarioAlreadyExistException(FuncionarioAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("Funcionario already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(DoacaoNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerReciboNotFoundException( DoacaoNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("Recibo not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DoacaoAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerReciboAlreadyExistException( DoacaoAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("Recibo already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerUsuarioNotFoundException(UsuarioNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404L);
        error.setTitle("Usuario not found.");
        error.setUrl(errorQuatro);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UsuarioAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerUsuarioAlreadyExistException(UsuarioAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(409L);
        error.setTitle("Usuario already exist.");
        error.setUrl(errorNove);
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}
