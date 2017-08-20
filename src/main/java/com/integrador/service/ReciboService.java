package com.integrador.service;

import com.integrador.domain.Recibos;
import com.integrador.exception.ReciboAlreadyExistException;
import com.integrador.exception.ReciboNotFoundException;
import com.integrador.repository.RecibosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class ReciboService {

    @Autowired
    private RecibosRepository repository;

    @Transactional(readOnly = true)
    public List<Recibos> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Recibos findById(Integer id){
        if(!exist(id)){
            throw new ReciboNotFoundException("Recibos com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }

    @Transactional(readOnly = false)
    public Recibos save(Recibos recibo){
        if(exist( recibo.getNumeroRecibo() )){
            throw new ReciboAlreadyExistException("Recibos com este id já existe " + recibo.getNumeroRecibo());
        }
        return this.repository.save(recibo);
    }

    @Transactional(readOnly = false)
    public Recibos update(Recibos recibo){
        if(!exist( recibo.getNumeroRecibo() )){
            throw new ReciboNotFoundException("Recibos com este id não existe " + recibo.getNumeroRecibo());
        }
        return this.repository.save(recibo);
    }

    @Transactional(readOnly = false)
    public void delete(Recibos recibo){
        if(!exist( recibo.getNumeroRecibo() )){
            throw new ReciboNotFoundException("Recibos com este id não existe " + recibo.getNumeroRecibo());
        }
        this.repository.delete(recibo);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new ReciboNotFoundException("Recibos com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}