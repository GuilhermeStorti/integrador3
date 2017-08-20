package com.integrador.service;

import com.integrador.domain.Usuario;
import com.integrador.exception.UsuarioAlreadyExistException;
import com.integrador.exception.UsuarioNotFoundException;
import com.integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public List<Usuario> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario findById(Integer id){
        if(!exist(id)){
            throw new UsuarioNotFoundException("Usuario com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }

    @Transactional(readOnly = false)
    public Usuario save(Usuario usuario){
        if(exist( usuario.getId() )){
            throw new UsuarioAlreadyExistException("Usuario com este id já existe " + usuario.getId());
        }
        return this.repository.save(usuario);
    }

    @Transactional(readOnly = false)
    public Usuario update(Usuario usuario){
        if(!exist( usuario.getId() )){
            throw new UsuarioNotFoundException("Usuario com este id não existe " + usuario.getId());
        }
        return this.repository.save(usuario);
    }

    @Transactional(readOnly = false)
    public void delete(Usuario usuario){
        if(!exist( usuario.getId() )){
            throw new UsuarioNotFoundException("Usuario com este id não existe " + usuario.getId());
        }
        this.repository.delete(usuario);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new UsuarioNotFoundException("Usuario com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}