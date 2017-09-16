package com.integrador.service;

import com.integrador.utils.DateUtils;
import com.integrador.domain.Contribuinte;
import com.integrador.exception.ContribuinteAlreadyExistException;
import com.integrador.exception.ContribuinteNotFoundException;
import com.integrador.repository.ContribuinteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class ContribuinteService {

    @Autowired
    private ContribuinteRepository repository;

    @Transactional(readOnly = true)
    public List<Contribuinte> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Contribuinte findById( Integer id){
        if(!exist(id)){
            throw new ContribuinteNotFoundException("Contribuinte com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }


    @Transactional(readOnly = false)
    public Contribuinte save(Contribuinte contribuinte){
        if(exist( contribuinte.getId() )){
            throw new ContribuinteAlreadyExistException("Contribuinte com este id já existe " + contribuinte.getId());
        }
        return this.repository.save(contribuinte);
    }

    @Transactional(readOnly = false)
    public Contribuinte update(Contribuinte contribuinte){
        if(!exist( contribuinte.getId() )){
            throw new ContribuinteNotFoundException("Contribuinte com este id não existe " + contribuinte.getId());
        }
        return this.repository.save(contribuinte);
    }

    @Transactional(readOnly = false)
    public void delete(Contribuinte contribuinte){
        if(!exist( contribuinte.getId() )){
            throw new ContribuinteNotFoundException("Contribuinte com este id não existe " + contribuinte.getId());
        }
        this.repository.delete(contribuinte);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new ContribuinteNotFoundException("Contribuinte com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    public int findSavesOfMounth(){
        return repository.findSavesOfMounth(DateUtils.asDate(LocalDate.now().withDayOfMonth(1)));
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}