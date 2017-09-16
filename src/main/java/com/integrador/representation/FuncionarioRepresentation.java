package com.integrador.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrador.domain.Cargo;
import com.integrador.domain.Contribuinte;
import com.integrador.domain.Endereco;
import com.integrador.domain.Funcionario;
import com.integrador.domain.Usuario;

import java.util.Date;
import java.util.List;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class FuncionarioRepresentation {

    @JsonInclude
    private int id;
    @JsonInclude
    private String nome;
    @JsonInclude
    private String sobrenome;
    @JsonInclude
    private String sexo;
    @JsonInclude
    private String cpf;
    @JsonInclude
    private String email;
    @JsonInclude
    private String telefone1;
    @JsonInclude
    private String telefone2;
    @JsonInclude
    private Integer numeroResidencia;
    @JsonInclude
    private String complementoResidencia;
    @JsonInclude
    private String situacao;
    @JsonInclude
    private Cargo cargo;
    @JsonInclude
    private Endereco endereco;
    @JsonIgnore
    private List<Contribuinte> contribuintes;
    @JsonInclude
    private Usuario usuario;

    public FuncionarioRepresentation() {
    }

    public FuncionarioRepresentation(int id, String nome, String sobrenome, String sexo, String cpf, String email, String telefone1, String telefone2, Integer numeroResidencia, String complementoResidencia, String situacao, Cargo cargo, Endereco endereco, List<Contribuinte> contribuintes, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.numeroResidencia = numeroResidencia;
        this.complementoResidencia = complementoResidencia;
        this.situacao = situacao;
        this.cargo = cargo;
        this.endereco = endereco;
        this.contribuintes = contribuintes;
        this.usuario = usuario;
    }

    public FuncionarioRepresentation(Funcionario f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.sobrenome = f.getSobrenome();
        this.sexo = f.getSexo();
        this.cpf = f.getCpf();
        this.email = f.getEmail();
        this.telefone1 = f.getTelefone1();
        this.telefone2 = f.getTelefone2();
        this.numeroResidencia = f.getNumeroResidencia();
        this.complementoResidencia = f.getComplementoResidencia();
        this.situacao = f.getSituacao();
        this.cargo = f.getCargo();
        this.endereco = f.getEndereco();
        this.contribuintes = f.getContribuintes();
        this.usuario = f.getUsuario();
    }

    public Funcionario build(FuncionarioRepresentation r){
        Funcionario f = new Funcionario();

        f.setId(r.getId());
        f.setNome(r.getNome());
        f.setSobrenome(r.getSobrenome());
        f.setSexo(r.getSexo());
        f.setCpf(r.getCpf());
        f.setEmail(r.getEmail());
        f.setTelefone1(r.getTelefone1());
        f.setTelefone2(r.getTelefone2());
        f.setNumeroResidencia(r.getNumeroResidencia());
        f.setComplementoResidencia(r.getComplementoResidencia());
        f.setSituacao(r.getSituacao());
        f.setCargo(r.getCargo());
        f.setEndereco(r.getEndereco());
        f.setContribuintes(r.getContribuintes());
        f.setUsuario(r.getUsuario());

        return f;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Integer numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getComplementoResidencia() {
        return complementoResidencia;
    }

    public void setComplementoResidencia(String complementoResidencia) {
        this.complementoResidencia = complementoResidencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Contribuinte> getContribuintes() {
        return contribuintes;
    }

    public void setContribuintes(List<Contribuinte> contribuintes) {
        this.contribuintes = contribuintes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
