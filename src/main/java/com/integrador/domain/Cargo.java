package com.integrador.domain;

import javax.persistence.*;


@Entity
@Table (name = "cargo")
public class Cargo {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="cargo_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column (name = "id")
    private int id;

    @Column (name = "descricao")
    private String descricao;

    public int getId() {
        return id;
    }

    public Cargo setId( int id ) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Cargo setDescricao( String descricao ) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Cargo that = (Cargo) o;

        if ( id != that.id ) return false;
        if ( descricao != null ? !descricao.equals ( that.descricao ) : that.descricao != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descricao != null ? descricao.hashCode () : 0);
        return result;
    }
}
