package com.integrador.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "funcionario")
public class Funcionario {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="funcionario_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column (name = "id")
    private int id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "sobrenome")
    private String sobrenome;

    @Column (name = "sexo")
    private String sexo;

    @Column (name = "cpf")
    private String cpf;

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
    @JoinColumn(name = "id_cargo", referencedColumnName = "id", nullable = false)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "cep", referencedColumnName = "cep", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "funcionario", targetEntity = Contribuinte.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contribuinte> contribuintes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name="id_usuario"))
    private Usuario usuario;


    public int getId() {
        return id;
    }

    public Funcionario setId( int id ) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario setNome( String nome ) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Funcionario setSobrenome( String sobrenome ) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getSexo() {
        return sexo;
    }

    public Funcionario setSexo( String sexo ) {
        this.sexo = sexo;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Funcionario setCpf( String cpf ) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Funcionario setEmail( String email ) {
        this.email = email;
        return this;
    }
    
    public String getTelefone1() {
        return telefone1;
    }

    public Funcionario setTelefone1( String telefone1 ) {
        this.telefone1 = telefone1;
        return this;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public Funcionario setTelefone2( String telefone2 ) {
        this.telefone2 = telefone2;
        return this;
    }

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public Funcionario setNumeroResidencia( Integer numeroResidencia ) {
        this.numeroResidencia = numeroResidencia;
        return this;
    }

    public String getComplementoResidencia() {
        return complementoResidencia;
    }

    public Funcionario setComplementoResidencia( String complementoResidencia ) {
        this.complementoResidencia = complementoResidencia;
        return this;
    }

    public String getSituacao() {
        return situacao;
    }

    public Funcionario setSituacao( String situacao ) {
        this.situacao = situacao;
        return this;
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    public Funcionario setCargo( Cargo cargoByIdCargo) {
        this.cargo = cargoByIdCargo;
        return this;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public Funcionario setEndereco( Endereco enderecoByCep) {
        this.endereco = enderecoByCep;
        return this;
    }

    public List <Contribuinte> getContribuintes() {
        return contribuintes;
    }

    public Funcionario setContribuintes( List <Contribuinte> contribuintes ) {
        this.contribuintes = contribuintes;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Funcionario setUsuario( Usuario usuario ) {
        this.usuario = usuario;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Funcionario that = (Funcionario) o;

        if ( id != that.id ) return false;
        if ( nome != null ? !nome.equals ( that.nome ) : that.nome != null ) return false;
        if ( sobrenome != null ? !sobrenome.equals ( that.sobrenome ) : that.sobrenome != null ) return false;
        if ( sexo != null ? !sexo.equals ( that.sexo ) : that.sexo != null ) return false;
        if ( cpf != null ? !cpf.equals ( that.cpf ) : that.cpf != null ) return false;
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
        result = 31 * result + (nome != null ? nome.hashCode () : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode () : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode () : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode () : 0);
        result = 31 * result + (email != null ? email.hashCode () : 0);
        result = 31 * result + (telefone1 != null ? telefone1.hashCode () : 0);
        result = 31 * result + (telefone2 != null ? telefone2.hashCode () : 0);
        result = 31 * result + (numeroResidencia != null ? numeroResidencia.hashCode () : 0);
        result = 31 * result + (complementoResidencia != null ? complementoResidencia.hashCode () : 0);
        result = 31 * result + (situacao != null ? situacao.hashCode () : 0);
        return result;
    }
}
