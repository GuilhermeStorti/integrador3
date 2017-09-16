package com.integrador.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrador.domain.Campanha;

import java.util.Date;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class CampanhaRepresentation {

    @JsonInclude
    private int id;
    @JsonInclude
    private String descricao;
    @JsonInclude
    private Date dataInicio;
    @JsonInclude
    private Date dataFim;

    public CampanhaRepresentation() {
    }

    public CampanhaRepresentation(int id, String descricao, Date dataInicio, Date dataFim) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public CampanhaRepresentation(Campanha campanha) {
        this.id = campanha.getId();
        this.descricao = campanha.getDescricao();
        this.dataInicio = campanha.getDataInicio();
        this.dataFim = campanha.getDataFim();
    }

    public Campanha build(CampanhaRepresentation representation){
        Campanha campanha = new Campanha();

        campanha.setId(representation.getId());
        campanha.setDescricao(representation.getDescricao());
        campanha.setDataInicio(representation.getDataInicio());
        campanha.setDataFim(representation.getDataFim());
        return campanha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
