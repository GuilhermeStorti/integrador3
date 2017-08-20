package com.integrador.service;

import com.integrador.domain.Cargo;
import com.integrador.exception.CargoAlreadyExistException;
import com.integrador.exception.CargoNotFoundException;
import com.integrador.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    @Transactional(readOnly = true)
    public List<Cargo> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Cargo findById(Integer id){
        if(!exist(id)){
            throw new CargoNotFoundException("Cargo com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }


    @Transactional(readOnly = false)
    public Cargo save(Cargo cargo){
        if(exist( cargo.getId() )){
            throw new CargoAlreadyExistException("Cargo com este id já existe " + cargo.getId());
        }
        return this.repository.save(cargo);
    }

    @Transactional(readOnly = false)
    public Cargo update(Cargo cargo){
        if(!exist( cargo.getId() )){
            throw new CargoNotFoundException("Cargo com este id não existe " + cargo.getId());
        }
        return this.repository.save(cargo);
    }

    @Transactional(readOnly = false)
    public void delete(Cargo cargo){
        if(!exist( cargo.getId() )){
            throw new CargoNotFoundException("Cargo com este id não existe " + cargo.getId());
        }
        this.repository.delete(cargo);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new CargoNotFoundException("Cargo com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}