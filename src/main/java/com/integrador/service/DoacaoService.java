package com.integrador.service;

import com.integrador.utils.DateUtils;
import com.integrador.domain.Doacao;
import com.integrador.domain.Funcionario;
import com.integrador.exception.DoacaoAlreadyExistException;
import com.integrador.exception.DoacaoNotFoundException;
import com.integrador.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by guilhermeplasma on 20/08/17.
 */
@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository repository;

    @Transactional(readOnly = true)
    public List<Doacao> findAll(){
        return  this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Doacao findById(Integer id){
        if(!exist(id)){
            throw new DoacaoNotFoundException ("Doacao com este id não existe " + id);
        }
        return this.repository.findOne( id );
    }

    @Transactional(readOnly = false)
    public Doacao save(Doacao doacao){
        if(exist( doacao.getNumeroRecibo() )){
            throw new DoacaoAlreadyExistException ("Doacao com este id já existe " + doacao.getNumeroRecibo());
        }
        doacao.setDataOperacao(new Date());
        doacao.setStatus("G");
        return this.repository.save(doacao);
    }

    @Transactional(readOnly = false)
    public Doacao update(Doacao doacao){
        if(!exist( doacao.getNumeroRecibo() )){
            throw new DoacaoNotFoundException ("Doacao com este id não existe " + doacao.getNumeroRecibo());
        }
        return this.repository.save(doacao);
    }

    @Transactional(readOnly = false)
    public void delete(Doacao doacao){
        if(!exist( doacao.getNumeroRecibo() )){
            throw new DoacaoNotFoundException ("Doacao com este id não existe " + doacao.getNumeroRecibo());
        }
        this.repository.delete(doacao);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id){
        if(!exist( id )){
            throw new DoacaoNotFoundException ("Doacao com este id não existe " + id);
        }
        this.repository.delete(id);
    }

    public int findDonationsOfMounth(){
        return repository.findDonationsOfMounth(DateUtils.asDate(LocalDate.now().withDayOfMonth(1)));
    }

    public Double findValueOfDonationsOfMounth(Funcionario funcionario){
        return repository.findValueOfDonationsOfMounth(funcionario);
    }

    private boolean exist( Integer id ) {
        return this.repository.exists( id );
    }
}