package com.integrador.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Created by guilhermeplasma on 15/08/17.
 */
@Entity
public class Usuario {
    private int id;
    private String nome;
    private String usuario;
    private String senha;

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="usuario_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario1 = (Usuario) o;

        if (id != usuario1.id) return false;
        if (nome != null ? !nome.equals(usuario1.nome) : usuario1.nome != null) return false;
        if (usuario != null ? !usuario.equals(usuario1.usuario) : usuario1.usuario != null) return false;
        if (senha != null ? !senha.equals(usuario1.senha) : usuario1.senha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }
}
