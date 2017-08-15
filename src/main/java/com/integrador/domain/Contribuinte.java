package com.integrador.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

/**
 * Created by guilhermeplasma on 15/08/17.
 */
@Entity
public class Contribuinte {
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
    private Campanha campanhaByIdCampanha;

    @Id
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
    @Column(name = "sobrenome")
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "sexo")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "data_nascimento")
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telefone_1")
    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    @Basic
    @Column(name = "telefone_2")
    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    @Basic
    @Column(name = "numero_residencia")
    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Integer numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    @Basic
    @Column(name = "complemento_residencia")
    public String getComplementoResidencia() {
        return complementoResidencia;
    }

    public void setComplementoResidencia(String complementoResidencia) {
        this.complementoResidencia = complementoResidencia;
    }

    @Basic
    @Column(name = "data_cadastro")
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Basic
    @Column(name = "situacao")
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contribuinte that = (Contribuinte) o;

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(that.sobrenome) : that.sobrenome != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (sexo != null ? !sexo.equals(that.sexo) : that.sexo != null) return false;
        if (dataNascimento != null ? !dataNascimento.equals(that.dataNascimento) : that.dataNascimento != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telefone1 != null ? !telefone1.equals(that.telefone1) : that.telefone1 != null) return false;
        if (telefone2 != null ? !telefone2.equals(that.telefone2) : that.telefone2 != null) return false;
        if (numeroResidencia != null ? !numeroResidencia.equals(that.numeroResidencia) : that.numeroResidencia != null)
            return false;
        if (complementoResidencia != null ? !complementoResidencia.equals(that.complementoResidencia) : that.complementoResidencia != null)
            return false;
        if (dataCadastro != null ? !dataCadastro.equals(that.dataCadastro) : that.dataCadastro != null) return false;
        if (situacao != null ? !situacao.equals(that.situacao) : that.situacao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefone1 != null ? telefone1.hashCode() : 0);
        result = 31 * result + (telefone2 != null ? telefone2.hashCode() : 0);
        result = 31 * result + (numeroResidencia != null ? numeroResidencia.hashCode() : 0);
        result = 31 * result + (complementoResidencia != null ? complementoResidencia.hashCode() : 0);
        result = 31 * result + (dataCadastro != null ? dataCadastro.hashCode() : 0);
        result = 31 * result + (situacao != null ? situacao.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_campanha", referencedColumnName = "id", nullable = false)
    public Campanha getCampanhaByIdCampanha() {
        return campanhaByIdCampanha;
    }

    public void setCampanhaByIdCampanha(Campanha campanhaByIdCampanha) {
        this.campanhaByIdCampanha = campanhaByIdCampanha;
    }
}
