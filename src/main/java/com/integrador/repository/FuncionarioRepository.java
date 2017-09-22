package com.integrador.repository;

import com.integrador.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("select f from Funcionario f where f.cargo = 2")
    Funcionario findAtualMotoboy();

}
