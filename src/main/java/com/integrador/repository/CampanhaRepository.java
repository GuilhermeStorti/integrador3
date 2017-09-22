package com.integrador.repository;

import com.integrador.domain.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface CampanhaRepository extends JpaRepository<Campanha, Integer> {

    @Query("select c from Campanha c where c.descricao like %:descricao%")
    List<Campanha> findByDescricao(@Param("descricao") String descricao);

}
