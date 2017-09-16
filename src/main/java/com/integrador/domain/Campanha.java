package com.integrador.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table (name = "campanha")
public class Campanha {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="campanha_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column (name = "id")
    private int id;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "data_inicio")
    private Date dataInicio;

    @Column (name = "data_fim")
    private Date dataFim;


    public int getId() {
        return id;
    }

    public Campanha setId( int id ) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Campanha setDescricao( String descricao ) {
        this.descricao = descricao;
        return this;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Campanha setDataInicio( Date dataInicio ) {
        this.dataInicio = dataInicio;
        return this;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Campanha setDataFim( Date dataFim ) {
        this.dataFim = dataFim;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Campanha that = (Campanha) o;

        if ( id != that.id ) return false;
        if ( descricao != null ? !descricao.equals ( that.descricao ) : that.descricao != null ) return false;
        if ( dataInicio != null ? !dataInicio.equals ( that.dataInicio ) : that.dataInicio != null ) return false;
        if ( dataFim != null ? !dataFim.equals ( that.dataFim ) : that.dataFim != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descricao != null ? descricao.hashCode () : 0);
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode () : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode () : 0);
        return result;
    }
}
