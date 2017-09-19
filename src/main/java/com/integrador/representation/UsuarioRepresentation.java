package com.integrador.representation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.integrador.domain.Funcionario;
import com.integrador.domain.Usuario;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class UsuarioRepresentation {

    private int id;
    private String nome;
    private String usuario;
    private String senha;

    public UsuarioRepresentation() {
    }

    public UsuarioRepresentation(int id, String nome, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public UsuarioRepresentation(Usuario u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.usuario = u.getUsuario();
        this.senha = u.getSenha();
    }

    public Usuario build(UsuarioRepresentation representation){
        Usuario usuario = new Usuario();

        usuario.setId(representation.getId());
        usuario.setNome(representation.getNome());
        usuario.setUsuario(representation.getUsuario());
        usuario.setSenha(usuario.getSenha());

        return usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
