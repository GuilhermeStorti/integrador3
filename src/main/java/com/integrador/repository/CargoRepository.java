package com.integrador.repository;

import com.integrador.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
