package com.integrador.repository;

import com.integrador.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

    @Query("select count(d) from Doacao d where d.dataOperacao > :primeiroDia")
    int findDonationsOfMounth(@Param("primeiroDia") Date primeiroDia);

}
