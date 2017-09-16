package com.integrador.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrador.domain.Funcionario;
import com.integrador.domain.Usuario;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class UsuarioRepresentation {

    @JsonInclude
    private int id;
    @JsonInclude
    private String nome;
    @JsonInclude
    private String usuario;
    @JsonInclude
    private String senha;
    @JsonInclude
    private Funcionario funcionario;

    public UsuarioRepresentation() {
    }

    public UsuarioRepresentation(int id, String nome, String usuario, String senha, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.funcionario = funcionario;
    }

    public UsuarioRepresentation(Usuario u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.usuario = u.getUsuario();
        this.senha = u.getSenha();
        this.funcionario = u.getFuncionario();
    }

    public Usuario build(UsuarioRepresentation representation){
        Usuario usuario = new Usuario();

        usuario.setId(representation.getId());
        usuario.setNome(representation.getNome());
        usuario.setUsuario(representation.getUsuario());
        usuario.setSenha(usuario.getSenha());
        usuario.setFuncionario(representation.getFuncionario());
        
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
