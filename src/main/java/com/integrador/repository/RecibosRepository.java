package com.integrador.repository;

import com.integrador.domain.Recibos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface RecibosRepository extends JpaRepository<Recibos, Integer> {
}
