package com.integrador.repository;

import com.integrador.domain.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {
}
