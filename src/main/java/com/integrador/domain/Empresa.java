package com.integrador.domain;

import javax.persistence.*;

@Entity
@Table (name = "empresa")
public class Empresa {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="empresa_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column (name = "id")
    private int id;

    @Column (name = "nome_fantasia")
    private String nomeFantasia;

    @Column (name = "razao_social")
    private String razaoSocial;

    @Column (name = "cnpj")
    private String cnpj;

    @Column (name = "email")
    private String email;

    @Column (name = "telefone_1")
    private String telefone1;

    @Column (name = "telefone_2")
    private String telefone2;

    @Column (name = "numero_residencia")
    private Integer numeroResidencia;

    @Column (name = "complemento_residencia")
    private String complementoResidencia;

    @Column (name = "situacao")
    private String situacao;

    @ManyToOne
    @JoinColumn(name = "cep", referencedColumnName = "cep", nullable = false)
    private Endereco cep;

    public int getId() {
        return id;
    }

    public Empresa setId( int id ) {
        this.id = id;
        return this;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Empresa setNomeFantasia( String nomeFantasia ) {
        this.nomeFantasia = nomeFantasia;
        return this;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Empresa setRazaoSocial( String razaoSocial ) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Empresa setCnpj( String cnpj ) {
        this.cnpj = cnpj;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Empresa setEmail( String email ) {
        this.email = email;
        return this;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public Empresa setTelefone1( String telefone1 ) {
        this.telefone1 = telefone1;
        return this;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public Empresa setTelefone2( String telefone2 ) {
        this.telefone2 = telefone2;
        return this;
    }

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public Empresa setNumeroResidencia( Integer numeroResidencia ) {
        this.numeroResidencia = numeroResidencia;
        return this;
    }

    public String getComplementoResidencia() {
        return complementoResidencia;
    }

    public Empresa setComplementoResidencia( String complementoResidencia ) {
        this.complementoResidencia = complementoResidencia;
        return this;
    }

    public String getSituacao() {
        return situacao;
    }

    public Empresa setSituacao( String situacao ) {
        this.situacao = situacao;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Empresa that = (Empresa) o;

        if ( id != that.id ) return false;
        if ( nomeFantasia != null ? !nomeFantasia.equals ( that.nomeFantasia ) : that.nomeFantasia != null )
            return false;
        if ( razaoSocial != null ? !razaoSocial.equals ( that.razaoSocial ) : that.razaoSocial != null ) return false;
        if ( cnpj != null ? !cnpj.equals ( that.cnpj ) : that.cnpj != null ) return false;
        if ( email != null ? !email.equals ( that.email ) : that.email != null ) return false;
        if ( telefone1 != null ? !telefone1.equals ( that.telefone1 ) : that.telefone1 != null ) return false;
        if ( telefone2 != null ? !telefone2.equals ( that.telefone2 ) : that.telefone2 != null ) return false;
        if ( numeroResidencia != null ? !numeroResidencia.equals ( that.numeroResidencia ) : that.numeroResidencia != null )
            return false;
        if ( complementoResidencia != null ? !complementoResidencia.equals ( that.complementoResidencia ) : that.complementoResidencia != null )
            return false;
        if ( situacao != null ? !situacao.equals ( that.situacao ) : that.situacao != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nomeFantasia != null ? nomeFantasia.hashCode () : 0);
        result = 31 * result + (razaoSocial != null ? razaoSocial.hashCode () : 0);
        result = 31 * result + (cnpj != null ? cnpj.hashCode () : 0);
        result = 31 * result + (email != null ? email.hashCode () : 0);
        result = 31 * result + (telefone1 != null ? telefone1.hashCode () : 0);
        result = 31 * result + (telefone2 != null ? telefone2.hashCode () : 0);
        result = 31 * result + (numeroResidencia != null ? numeroResidencia.hashCode () : 0);
        result = 31 * result + (complementoResidencia != null ? complementoResidencia.hashCode () : 0);
        result = 31 * result + (situacao != null ? situacao.hashCode () : 0);
        return result;
    }
}
