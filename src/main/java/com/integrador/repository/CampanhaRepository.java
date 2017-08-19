package com.integrador.repository;

import com.integrador.domain.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface CampanhaRepository extends JpaRepository<Campanha, Integer> {
}
