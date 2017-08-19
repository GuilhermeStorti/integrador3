package com.integrador.repository;

import com.integrador.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
