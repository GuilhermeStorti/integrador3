package com.integrador.repository;

import com.integrador.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {
}
