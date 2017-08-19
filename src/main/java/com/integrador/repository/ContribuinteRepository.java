package com.integrador.repository;

import com.integrador.domain.Contribuinte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface ContribuinteRepository extends JpaRepository<Contribuinte, Integer> {
}
