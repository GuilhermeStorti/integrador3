package com.integrador.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrador.domain.Contribuinte;
import com.integrador.domain.Endereco;

import java.util.List;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class EnderecoRepresentation {

    @JsonInclude
    private int cep;
    @JsonInclude
    private String logradouro;
    @JsonInclude
    private String bairro;
    @JsonInclude
    private String cidade;
    @JsonInclude
    private String uf;
    @JsonIgnore
    private List<Contribuinte> contribuintes;

    public EnderecoRepresentation() {
    }

    public EnderecoRepresentation(int cep, String logradouro, String bairro, String cidade, String uf, List<Contribuinte> contribuintes) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.contribuintes = contribuintes;
    }

    public EnderecoRepresentation(Endereco e) {
        this.cep = e.getCep();
        this.logradouro = e.getLogradouro();
        this.bairro = e.getBairro();
        this.cidade = e.getCidade();
        this.uf = e.getUf();
        this.contribuintes = e.getContribuintes();
    }

    public Endereco build(EnderecoRepresentation r){
        Endereco endereco = new Endereco();

        endereco.setCep(r.getCep());
        endereco.setLogradouro(r.getLogradouro());
        endereco.setBairro(r.getBairro());
        endereco.setCidade(r.getCidade());
        endereco.setUf(r.getUf());
        endereco.setContribuintes(r.getContribuintes());

        return endereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Contribuinte> getContribuintes() {
        return contribuintes;
    }

    public void setContribuintes(List<Contribuinte> contribuintes) {
        this.contribuintes = contribuintes;
    }
}
