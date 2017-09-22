package com.integrador.repository;

import com.integrador.domain.Contribuinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface ContribuinteRepository extends JpaRepository<Contribuinte, Integer> {

    @Query("select count(c) from Contribuinte c where c.dataCadastro > :primeiroDia")
    int findSavesOfMounth(@Param("primeiroDia") Date primeiroDia);

    @Query("select c from Contribuinte c where upper(c.nome) like %:nome%")
    List<Contribuinte> findByNome(@Param("nome") String nome);

}
