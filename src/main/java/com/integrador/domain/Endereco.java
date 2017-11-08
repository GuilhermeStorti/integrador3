package com.integrador.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "endereco")
public class Endereco {

    @Id
    @Column (name = "cep")
    private int cep;

    @Column (name = "logradouro")
    private String logradouro;

    @Column (name = "bairro")
    private String bairro;

    @Column (name = "cidade")
    private String cidade;

    @Column (name = "uf")
    private String uf;

    @OneToMany(mappedBy = "cep", targetEntity = Contribuinte.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contribuinte> contribuintes;

    public int getCep() {
        return cep;
    }

    public Endereco setCep( int cep ) {
        this.cep = cep;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro( String logradouro ) {
        this.logradouro = logradouro;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro( String bairro ) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade( String cidade ) {
        this.cidade = cidade;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public Endereco setUf( String uf ) {
        this.uf = uf;
        return this;
    }

    public List <Contribuinte> getContribuintes() {
        return contribuintes;
    }

    public Endereco setContribuintes( List <Contribuinte> contribuintes ) {
        this.contribuintes = contribuintes;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Endereco that = (Endereco) o;

        if ( cep != that.cep ) return false;
        if ( logradouro != null ? !logradouro.equals ( that.logradouro ) : that.logradouro != null ) return false;
        if ( bairro != null ? !bairro.equals ( that.bairro ) : that.bairro != null ) return false;
        if ( cidade != null ? !cidade.equals ( that.cidade ) : that.cidade != null ) return false;
        if ( uf != null ? !uf.equals ( that.uf ) : that.uf != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cep;
        result = 31 * result + (logradouro != null ? logradouro.hashCode () : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode () : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode () : 0);
        result = 31 * result + (uf != null ? uf.hashCode () : 0);
        return result;
    }
}
