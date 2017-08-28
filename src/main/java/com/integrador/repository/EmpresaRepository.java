package com.integrador.repository;

import com.integrador.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
