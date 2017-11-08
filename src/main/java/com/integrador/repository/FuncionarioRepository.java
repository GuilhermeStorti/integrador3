package com.integrador.repository;

import com.integrador.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query(value = "select * from funcionario f where f.id_cargo = 2 limit 1", nativeQuery = true)
    Funcionario findAtualMotoboy();

}
