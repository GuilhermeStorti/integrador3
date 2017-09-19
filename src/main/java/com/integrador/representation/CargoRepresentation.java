package com.integrador.representation;

import com.integrador.domain.Cargo;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class CargoRepresentation {

    private int id;
    private String descricao;

    public CargoRepresentation() {
    }

    public CargoRepresentation(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CargoRepresentation(Cargo cargo) {
        this.id = cargo.getId();
        this.descricao = cargo.getDescricao();
    }

    public Cargo build(CargoRepresentation representation){
        Cargo cargo = new Cargo();

        cargo.setId(representation.getId());
        cargo.setDescricao(representation.getDescricao());
        return cargo;
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
