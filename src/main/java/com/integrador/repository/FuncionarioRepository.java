package com.integrador.repository;

import com.integrador.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
