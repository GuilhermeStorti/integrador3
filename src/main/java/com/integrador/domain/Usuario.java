package com.integrador.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table (name = "usuario")
public class Usuario {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="usuario_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column (name = "id")
    private int id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "usuario")
    private String usuario;

    @Column (name = "senha")
    @JsonIgnore
    private String senha;

    public int getId() {
        return id;
    }

    public Usuario setId( int id ) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome( String nome ) {
        this.nome = nome;
        return this;
    }

    public String getUsuario() {
        return usuario;
    }

    public Usuario setUsuario( String usuario ) {
        this.usuario = usuario;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha( String senha ) {
        this.senha = senha;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Usuario that = (Usuario) o;

        if ( id != that.id ) return false;
        if ( nome != null ? !nome.equals ( that.nome ) : that.nome != null ) return false;
        if ( usuario != null ? !usuario.equals ( that.usuario ) : that.usuario != null ) return false;
        if ( senha != null ? !senha.equals ( that.senha ) : that.senha != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode () : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode () : 0);
        result = 31 * result + (senha != null ? senha.hashCode () : 0);
        return result;
    }
}
