package com.integrador.representation;

import com.integrador.domain.Contribuinte;

import java.util.Date;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class ContribuinteRepresentation {

    private int id;
    private String nome;
    private String sobrenome;
    private String tipo;
    private String sexo;
    private Date dataNascimento;
    private String email;
    private String telefone1;
    private String telefone2;
    private Integer numeroResidencia;
    private String complementoResidencia;
    private Date dataCadastro;
    private String situacao;

    public ContribuinteRepresentation() {
    }

    public ContribuinteRepresentation(int id, String nome, String sobrenome, String tipo, String sexo, Date dataNascimento, String email, String telefone1, String telefone2, Integer numeroResidencia, String complementoResidencia, Date dataCadastro, String situacao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.numeroResidencia = numeroResidencia;
        this.complementoResidencia = complementoResidencia;
        this.dataCadastro = dataCadastro;
        this.situacao = situacao;
    }

    public ContribuinteRepresentation(Contribuinte c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.sobrenome = c.getSobrenome();
        this.tipo = c.getTipo();
        this.sexo = c.getSexo();
        this.dataNascimento = c.getDataNascimento();
        this.email = c.getEmail();
        this.telefone1 = c.getTelefone1();
        this.telefone2 = c.getTelefone2();
        this.numeroResidencia = c.getNumeroResidencia();
        this.complementoResidencia = c.getComplementoResidencia();
        this.dataCadastro = c.getDataCadastro();
        this.situacao = c.getSituacao();
    }

    public Contribuinte build(ContribuinteRepresentation r){
        Contribuinte c = new Contribuinte();

        c.setId(r.getId());
        c.setNome(r.getNome());
        c.setSobrenome(r.getSobrenome());
        c.setTipo(r.getTipo());
        c.setSexo(r.getSexo());
        c.setDataNascimento(r.getDataNascimento());
        c.setEmail(r.getEmail());
        c.setTelefone1(r.getTelefone1());
        c.setTelefone2(r.getTelefone2());
        c.setNumeroResidencia(r.getNumeroResidencia());
        c.setComplementoResidencia(r.getComplementoResidencia());
        c.setDataCadastro(r.getDataCadastro());
        c.setSituacao(r.getSituacao());

        return c;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
