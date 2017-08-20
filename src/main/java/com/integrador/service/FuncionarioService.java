package com.integrador.service;

import com.integrador.domain.Funcionario;
import com.integrador.exception.FuncionarioAlreadyExistException;
import com.integrador.exception.FuncionarioNotFoundException;
import com.integrador.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Transactional(readOnly = true)
    public List<Funcionario> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Funcionario findById(Integer id){
        if(!exist(id)){
            throw new FuncionarioNotFoundException("Funcionario com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }

    @Transactional(readOnly = false)
    public Funcionario save(Funcionario funcionario){
        if(exist( funcionario.getId() )){
            throw new FuncionarioAlreadyExistException("Funcionario com este id já existe " + funcionario.getId());
        }
        return this.repository.save(funcionario);
    }

    @Transactional(readOnly = false)
    public Funcionario update(Funcionario funcionario){
        if(!exist( funcionario.getId() )){
            throw new FuncionarioNotFoundException("Funcionario com este id não existe " + funcionario.getId());
        }
        return this.repository.save(funcionario);
    }

    @Transactional(readOnly = false)
    public void delete(Funcionario funcionario){
        if(!exist( funcionario.getId() )){
            throw new FuncionarioNotFoundException("Funcionario com este id não existe " + funcionario.getId());
        }
        this.repository.delete(funcionario);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new FuncionarioNotFoundException("Funcionario com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}