package com.integrador.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by guilhermeplasma on 15/08/17.
 */
@Entity
public class Endereco {
    private int cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    @Id
    @Column(name = "cep")
    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Basic
    @Column(name = "logradouro")
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Basic
    @Column(name = "bairro")
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Basic
    @Column(name = "cidade")
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Basic
    @Column(name = "uf")
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        if (cep != endereco.cep) return false;
        if (logradouro != null ? !logradouro.equals(endereco.logradouro) : endereco.logradouro != null) return false;
        if (bairro != null ? !bairro.equals(endereco.bairro) : endereco.bairro != null) return false;
        if (cidade != null ? !cidade.equals(endereco.cidade) : endereco.cidade != null) return false;
        if (uf != null ? !uf.equals(endereco.uf) : endereco.uf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cep;
        result = 31 * result + (logradouro != null ? logradouro.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        return result;
    }
}
