package com.integrador.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrador.domain.FormaPagamento;
import com.integrador.domain.FormaPagamento;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class FormaPagamentoRepresentation {

    @JsonInclude
    private int id;
    @JsonInclude
    private String descricao;

    public FormaPagamentoRepresentation() {
    }

    public FormaPagamentoRepresentation(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public FormaPagamentoRepresentation(FormaPagamento formaPagamento) {
        this.id = formaPagamento.getId();
        this.descricao = formaPagamento.getDescricao();
    }

    public FormaPagamento build(FormaPagamentoRepresentation r){
        FormaPagamento formaPagamento = new FormaPagamento();

        formaPagamento.setId(r.getId());
        formaPagamento.setDescricao(r.getDescricao());

        return formaPagamento;
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
}
