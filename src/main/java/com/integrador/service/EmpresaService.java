package com.integrador.service;

import com.integrador.domain.Empresa;
import com.integrador.exception.EmpresaAlreadyExistException;
import com.integrador.exception.EmpresaNotFoundException;
import com.integrador.repository.EmpresaRepository;
import com.integrador.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @Transactional(readOnly = true)
    public List<Empresa> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Empresa findById( Integer id){
        if(!exist(id)){
            throw new EmpresaNotFoundException ("Empresa com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }


    @Transactional(readOnly = false)
    public Empresa save( Empresa empresa){
        if(exist( empresa.getId() )){
            throw new EmpresaAlreadyExistException ("Empresa com este id já existe " + empresa.getId());
        }
        if(!existEndereco(empresa.getCep().getCep())){
            empresa.setCep(enderecoRepository.save(empresa.getCep()));
        }
        return this.repository.save(empresa);
    }

    @Transactional(readOnly = false)
    public Empresa update(Empresa empresa){
        if(!exist( empresa.getId() )){
            throw new EmpresaNotFoundException("Empresa com este id não existe " + empresa.getId());
        }
        if(!existEndereco(empresa.getCep().getCep())){
            empresa.setCep(enderecoRepository.save(empresa.getCep()));
        }
        return this.repository.save(empresa);
    }

    @Transactional(readOnly = false)
    public void delete(Empresa empresa){
        if(!exist( empresa.getId() )){
            throw new EmpresaNotFoundException("Empresa com este id não existe " + empresa.getId());
        }
        this.repository.delete(empresa);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new EmpresaNotFoundException("Empresa com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }

    private boolean existEndereco( Integer cep ) {
        return this.enderecoRepository.exists( cep );
    }
}