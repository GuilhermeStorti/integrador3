package com.integrador.service;

import com.integrador.domain.Tabulacao;
import com.integrador.exception.TabulacaoAlreadyExistException;
import com.integrador.exception.TabulacaoNotFoundException;
import com.integrador.repository.TabulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class TabulacaoService {

    @Autowired
    private TabulacaoRepository repository;

    @Transactional(readOnly = true)
    public List<Tabulacao> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Tabulacao findById(Integer id){
        if(!exist(id)){
            throw new TabulacaoNotFoundException("Tabulacao com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }

    @Transactional(readOnly = false)
    public Tabulacao save(Tabulacao tabulacao){
        if(exist( tabulacao.getId() )){
            throw new TabulacaoAlreadyExistException("Tabulacao com este id já existe " + tabulacao.getId());
        }
        return this.repository.save(tabulacao);
    }

    @Transactional(readOnly = false)
    public Tabulacao update(Tabulacao tabulacao){
        if(!exist( tabulacao.getId() )){
            throw new TabulacaoNotFoundException("Tabulacao com este id não existe " + tabulacao.getId());
        }
        return this.repository.save(tabulacao);
    }

    @Transactional(readOnly = false)
    public void delete(Tabulacao tabulacao){
        if(!exist( tabulacao.getId() )){
            throw new TabulacaoNotFoundException("Tabulacao com este id não existe " + tabulacao.getId());
        }
        this.repository.delete(tabulacao);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new TabulacaoNotFoundException("Tabulacao com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}