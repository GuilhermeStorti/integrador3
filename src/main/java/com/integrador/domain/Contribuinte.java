package com.integrador.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "contribuinte")
public class Contribuinte {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="contribuinte_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column (name = "id")
    private int id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "sobrenome")
    private String sobrenome;

    @Column (name = "tipo")
    private String tipo;

    @Column (name = "sexo")
    private String sexo;

    @Column (name = "data_nascimento")
    private Date dataNascimento;
    
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

    @Column (name = "data_cadastro")
    private Date dataCadastro;

    @Column (name = "situacao")
    private String situacao;

    @ManyToOne
    @JoinColumn(name = "cep", referencedColumnName = "cep", nullable = false)
    private Endereco cep;

    @ManyToOne
    @JoinColumn(name = "id_funcionario",nullable=false, foreignKey = @ForeignKey(name="id_funcionario"))
    private Funcionario funcionario;

    
    public int getId() {
        return id;
    }

    public Contribuinte setId( int id ) {
        this.id = id;
        return this;
    }
    
    public String getNome() {
        return nome;
    }

    public Contribuinte setNome( String nome ) {
        this.nome = nome;
        return this;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }

    public Contribuinte setSobrenome( String sobrenome ) {
        this.sobrenome = sobrenome;
        return this;
    }
    
    public String getTipo() {
        return tipo;
    }

    public Contribuinte setTipo( String tipo ) {
        this.tipo = tipo;
        return this;
    }
    
    public String getSexo() {
        return sexo;
    }

    public Contribuinte setSexo( String sexo ) {
        this.sexo = sexo;
        return this;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Contribuinte setDataNascimento( Date dataNascimento ) {
        this.dataNascimento = dataNascimento;
        return this;
    }
    
    public String getEmail() {
        return email;
    }

    public Contribuinte setEmail( String email ) {
        this.email = email;
        return this;
    }
    
    public String getTelefone1() {
        return telefone1;
    }

    public Contribuinte setTelefone1( String telefone1 ) {
        this.telefone1 = telefone1;
        return this;
    }
    
    public String getTelefone2() {
        return telefone2;
    }

    public Contribuinte setTelefone2( String telefone2 ) {
        this.telefone2 = telefone2;
        return this;
    }
    
    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public Contribuinte setNumeroResidencia( Integer numeroResidencia ) {
        this.numeroResidencia = numeroResidencia;
        return this;
    }
    
    public String getComplementoResidencia() {
        return complementoResidencia;
    }

    public Contribuinte setComplementoResidencia( String complementoResidencia ) {
        this.complementoResidencia = complementoResidencia;
        return this;
    }
    
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Contribuinte setDataCadastro( Date dataCadastro ) {
        this.dataCadastro = dataCadastro;
        return this;
    }
    
    public String getSituacao() {
        return situacao;
    }

    public Contribuinte setSituacao( String situacao ) {
        this.situacao = situacao;
        return this;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Contribuinte setFuncionario( Funcionario funcionario ) {
        this.funcionario = funcionario;
        return this;
    }

    public Endereco getCep() {
        return cep;
    }

    public Contribuinte setCep( Endereco cep ) {
        this.cep = cep;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Contribuinte that = (Contribuinte) o;

        if ( id != that.id ) return false;
        if ( nome != null ? !nome.equals ( that.nome ) : that.nome != null ) return false;
        if ( sobrenome != null ? !sobrenome.equals ( that.sobrenome ) : that.sobrenome != null ) return false;
        if ( tipo != null ? !tipo.equals ( that.tipo ) : that.tipo != null ) return false;
        if ( sexo != null ? !sexo.equals ( that.sexo ) : that.sexo != null ) return false;
        if ( dataNascimento != null ? !dataNascimento.equals ( that.dataNascimento ) : that.dataNascimento != null )
            return false;
        if ( email != null ? !email.equals ( that.email ) : that.email != null ) return false;
        if ( telefone1 != null ? !telefone1.equals ( that.telefone1 ) : that.telefone1 != null ) return false;
        if ( telefone2 != null ? !telefone2.equals ( that.telefone2 ) : that.telefone2 != null ) return false;
        if ( numeroResidencia != null ? !numeroResidencia.equals ( that.numeroResidencia ) : that.numeroResidencia != null )
            return false;
        if ( complementoResidencia != null ? !complementoResidencia.equals ( that.complementoResidencia ) : that.complementoResidencia != null )
            return false;
        if ( dataCadastro != null ? !dataCadastro.equals ( that.dataCadastro ) : that.dataCadastro != null )
            return false;
        if ( situacao != null ? !situacao.equals ( that.situacao ) : that.situacao != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode () : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode () : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode () : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode () : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode () : 0);
        result = 31 * result + (email != null ? email.hashCode () : 0);
        result = 31 * result + (telefone1 != null ? telefone1.hashCode () : 0);
        result = 31 * result + (telefone2 != null ? telefone2.hashCode () : 0);
        result = 31 * result + (numeroResidencia != null ? numeroResidencia.hashCode () : 0);
        result = 31 * result + (complementoResidencia != null ? complementoResidencia.hashCode () : 0);
        result = 31 * result + (dataCadastro != null ? dataCadastro.hashCode () : 0);
        result = 31 * result + (situacao != null ? situacao.hashCode () : 0);
        return result;
    }
}
