package com.integrador.service;

import com.integrador.domain.Campanha;
import com.integrador.exception.CampanhaAlreadyExistException;
import com.integrador.exception.CampanhaNotFoundException;
import com.integrador.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository repository;

    @Transactional(readOnly = true)
    public List<Campanha> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Campanha findById(Integer id){
        if(!exist(id)){
            throw new CampanhaNotFoundException("Campanha com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }

    @Transactional(readOnly = true)
    public List<Campanha> findByDescricao(String descricao){
        return this.repository.findByDescricao(descricao);
    }

    @Transactional(readOnly = false)
    public Campanha save(Campanha campanha){
        if(exist( campanha.getId() )){
            throw new CampanhaAlreadyExistException("Campanha com este id já existe " + campanha.getId());
        }
        return this.repository.save(campanha);
    }

    @Transactional(readOnly = false)
    public Campanha update(Campanha campanha){
        if(!exist( campanha.getId() )){
            throw new CampanhaNotFoundException("Campanha com este id não existe " + campanha.getId());
        }
        return this.repository.save(campanha);
    }

    @Transactional(readOnly = false)
    public void delete(Campanha campanha){
        if(!exist( campanha.getId() )){
            throw new CampanhaNotFoundException("Campanha com este id não existe " + campanha.getId());
        }
        this.repository.delete(campanha);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new CampanhaNotFoundException("Campanha com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}
