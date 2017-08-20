package com.integrador.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Created by guilhermeplasma on 15/08/17.
 */
@Entity
public class Tabulacao {
    private int id;
    private String descricao;

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="tabulacao_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tabulacao tabulacao = (Tabulacao) o;

        if (id != tabulacao.id) return false;
        if (descricao != null ? !descricao.equals(tabulacao.descricao) : tabulacao.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
