package com.integrador.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Created by guilhermeplasma on 15/08/17.
 */
@Entity
public class Funcionario {
    private int id;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String cpf;
    private String email;
    private String telefone1;
    private String telefone2;
    private Integer numeroResidencia;
    private String complementoResidencia;
    private String situacao;
    private Cargo cargoByIdCargo;
    private Endereco enderecoByCep;

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="funcionario_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
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
    @Column(name = "sexo")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

        Funcionario that = (Funcionario) o;

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(that.sobrenome) : that.sobrenome != null) return false;
        if (sexo != null ? !sexo.equals(that.sexo) : that.sexo != null) return false;
        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telefone1 != null ? !telefone1.equals(that.telefone1) : that.telefone1 != null) return false;
        if (telefone2 != null ? !telefone2.equals(that.telefone2) : that.telefone2 != null) return false;
        if (numeroResidencia != null ? !numeroResidencia.equals(that.numeroResidencia) : that.numeroResidencia != null)
            return false;
        if (complementoResidencia != null ? !complementoResidencia.equals(that.complementoResidencia) : that.complementoResidencia != null)
            return false;
        if (situacao != null ? !situacao.equals(that.situacao) : that.situacao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefone1 != null ? telefone1.hashCode() : 0);
        result = 31 * result + (telefone2 != null ? telefone2.hashCode() : 0);
        result = 31 * result + (numeroResidencia != null ? numeroResidencia.hashCode() : 0);
        result = 31 * result + (complementoResidencia != null ? complementoResidencia.hashCode() : 0);
        result = 31 * result + (situacao != null ? situacao.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_cargo", referencedColumnName = "id", nullable = false)
    public Cargo getCargoByIdCargo() {
        return cargoByIdCargo;
    }

    public void setCargoByIdCargo(Cargo cargoByIdCargo) {
        this.cargoByIdCargo = cargoByIdCargo;
    }

    @ManyToOne
    @JoinColumn(name = "cep", referencedColumnName = "cep", nullable = false)
    public Endereco getEnderecoByCep() {
        return enderecoByCep;
    }

    public void setEnderecoByCep(Endereco enderecoByCep) {
        this.enderecoByCep = enderecoByCep;
    }
}
