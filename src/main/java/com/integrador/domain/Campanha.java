package com.integrador.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.sql.Date;

/**
 * Created by guilhermeplasma on 15/08/17.
 */
@Entity
public class Campanha {
    private int id;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="campanha_id_seq", allocationSize=1)
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

    @Basic
    @Column(name = "data_inicio")
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Basic
    @Column(name = "data_fim")
    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campanha campanha = (Campanha) o;

        if (id != campanha.id) return false;
        if (descricao != null ? !descricao.equals(campanha.descricao) : campanha.descricao != null) return false;
        if (dataInicio != null ? !dataInicio.equals(campanha.dataInicio) : campanha.dataInicio != null) return false;
        if (dataFim != null ? !dataFim.equals(campanha.dataFim) : campanha.dataFim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        return result;
    }
}
