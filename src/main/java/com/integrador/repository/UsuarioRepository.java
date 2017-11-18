package com.integrador.repository;

import com.integrador.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query("select u from Usuario u where u.usuario = :user and u.senha = :pass")
    Usuario validateUser(@Param("user") String user, @Param("pass") String pass);
}
