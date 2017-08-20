package com.integrador.service;

import com.integrador.domain.FormaPagamento;
import com.integrador.exception.FormaPagamentoAlreadyExistException;
import com.integrador.exception.FormaPagamentoNotFoundException;
import com.integrador.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository repository;

    @Transactional(readOnly = true)
    public List<FormaPagamento> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public FormaPagamento findById(Integer id){
        if(!exist(id)){
            throw new FormaPagamentoNotFoundException("FormaPagamento com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }


    @Transactional(readOnly = false)
    public FormaPagamento save(FormaPagamento formaPagamento){
        if(exist( formaPagamento.getId() )){
            throw new FormaPagamentoAlreadyExistException("FormaPagamento com este id já existe " + formaPagamento.getId());
        }
        return this.repository.save(formaPagamento);
    }

    @Transactional(readOnly = false)
    public FormaPagamento update(FormaPagamento formaPagamento){
        if(!exist( formaPagamento.getId() )){
            throw new FormaPagamentoNotFoundException("FormaPagamento com este id não existe " + formaPagamento.getId());
        }
        return this.repository.save(formaPagamento);
    }

    @Transactional(readOnly = false)
    public void delete(FormaPagamento formaPagamento){
        if(!exist( formaPagamento.getId() )){
            throw new FormaPagamentoNotFoundException("FormaPagamento com este id não existe " + formaPagamento.getId());
        }
        this.repository.delete(formaPagamento);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new FormaPagamentoNotFoundException("FormaPagamento com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}