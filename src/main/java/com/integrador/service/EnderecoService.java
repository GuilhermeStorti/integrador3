package com.integrador.service;

import com.integrador.domain.Endereco;
import com.integrador.exception.EnderecoAlreadyExistException;
import com.integrador.exception.EnderecoNotFoundException;
import com.integrador.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Transactional(readOnly = true)
    public List<Endereco> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Endereco findById(Integer cep){
        if(!exist(cep)){
            throw new EnderecoNotFoundException("Endereco com este cep não existe " + cep);
        }
        return this.repository.findOne( cep );
    }


    @Transactional(readOnly = false)
    public Endereco save(Endereco endereco){
        if(exist( endereco.getCep() )){
            throw new EnderecoAlreadyExistException("Endereco com este cep já existe " + endereco.getCep());
        }
        return this.repository.save(endereco);
    }

    @Transactional(readOnly = false)
    public Endereco update(Endereco endereco){
        if(!exist( endereco.getCep() )){
            throw new EnderecoNotFoundException("Endereco com este cep não existe " + endereco.getCep());
        }
        return this.repository.save(endereco);
    }

    @Transactional(readOnly = false)
    public void delete(Endereco endereco){
        if(!exist( endereco.getCep() )){
            throw new EnderecoNotFoundException("Endereco com este cep não existe " + endereco.getCep());
        }
        this.repository.delete(endereco);
    }

    @Transactional(readOnly = false)
    public void delete(Integer cep){
        if(!exist( cep )){
            throw new EnderecoNotFoundException("Endereco com este cep não existe " + cep);
        }
        this.repository.delete(cep);
    }

    private boolean exist( Integer cep ) {
        return this.repository.exists( cep );
    }
}