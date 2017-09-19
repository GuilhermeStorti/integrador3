package com.integrador.representation;

import com.integrador.domain.Empresa;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class EmpresaRepresentation {

    private int id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String telefone1;
    private String telefone2;
    private Integer numeroResidencia;
    private String complementoResidencia;
    private String situacao;

    public EmpresaRepresentation() {
    }

    public EmpresaRepresentation(int id, String nomeFantasia, String razaoSocial, String cnpj, String email, String telefone1, String telefone2, Integer numeroResidencia, String complementoResidencia, String situacao) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.numeroResidencia = numeroResidencia;
        this.complementoResidencia = complementoResidencia;
        this.situacao = situacao;
    }

    public EmpresaRepresentation(Empresa e) {
        this.id = e.getId();
        this.nomeFantasia = e.getNomeFantasia();
        this.razaoSocial = e.getRazaoSocial();
        this.cnpj = e.getCnpj();
        this.email = e.getEmail();
        this.telefone1 = e.getTelefone1();
        this.telefone2 = e.getTelefone2();
        this.numeroResidencia = e.getNumeroResidencia();
        this.complementoResidencia = e.getComplementoResidencia();
        this.situacao = e.getSituacao();
    }

    public Empresa build(EmpresaRepresentation r){
        Empresa empresa = new Empresa();

        empresa.setId(r.getId());
        empresa.setNomeFantasia(r.getNomeFantasia());
        empresa.setRazaoSocial(r.getRazaoSocial());
        empresa.setCnpj(r.getCnpj());
        empresa.setEmail(r.getEmail());
        empresa.setTelefone1(r.getTelefone1());
        empresa.setTelefone2(r.getTelefone2());
        empresa.setNumeroResidencia(r.getNumeroResidencia());
        empresa.setComplementoResidencia(r.getComplementoResidencia());
        empresa.setSituacao(r.getSituacao());

        return empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
}
