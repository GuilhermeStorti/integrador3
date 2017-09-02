package com.integrador.domain;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table (name = "doacao")
public class Doacao {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="doacao_numero_recibo_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column (name = "numero_recibo")
    private int numeroRecibo;

    @Column (name = "valor")
    private Double valor;

    @Column (name = "status")
    private String status;

    @Column (name = "data_operacao")
    private Date dataOperacao;

    @Column (name = "data_vencimento")
    private Date dataVencimento;

    @Column (name = "data_baixa")
    private Date dataBaixa;

    @Column (name = "parcela")
    private String parcela;

    @ManyToOne
    @JoinColumn(name = "id_contribuinte", referencedColumnName = "id", nullable = false)
    private Contribuinte contribuinte;

    @ManyToOne
    @JoinColumn(name = "id_campanha", referencedColumnName = "id", nullable = false)
    private Campanha campanha;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id", nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "id_funcionario_motoboy", referencedColumnName = "id", nullable = false)
    private Funcionario funcionarioMotoboy;

    @ManyToOne
    @JoinColumn(name = "id_funcionario_atendente", referencedColumnName = "id", nullable = false)
    private Funcionario funcionarioAtendente;


    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public Doacao setNumeroRecibo( int numeroRecibo ) {
        this.numeroRecibo = numeroRecibo;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Doacao setValor( Double valor ) {
        this.valor = valor;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Doacao setStatus( String status ) {
        this.status = status;
        return this;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public Doacao setDataOperacao( Date dataOperacao ) {
        this.dataOperacao = dataOperacao;
        return this;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Doacao setDataVencimento( Date dataVencimento ) {
        this.dataVencimento = dataVencimento;
        return this;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public Doacao setDataBaixa( Date dataBaixa ) {
        this.dataBaixa = dataBaixa;
        return this;
    }

    public String getParcela() {
        return parcela;
    }

    public Doacao setParcela( String parcela ) {
        this.parcela = parcela;
        return this;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    public Doacao setContribuinte( Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
        return this;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public Doacao setCampanha( Campanha campanha) {
        this.campanha = campanha;
        return this;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public Doacao setFormaPagamento( FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public Funcionario getFuncionarioMotoboy() {
        return funcionarioMotoboy;
    }

    public Doacao setFuncionarioMotoboy( Funcionario funcionarioMotoboy ) {
        this.funcionarioMotoboy = funcionarioMotoboy;
        return this;
    }

    public Funcionario getFuncionarioAtendente() {
        return funcionarioAtendente;
    }

    public Doacao setFuncionarioAtendente( Funcionario funcionarioAtendente ) {
        this.funcionarioAtendente = funcionarioAtendente;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Doacao that = (Doacao) o;

        if ( numeroRecibo != that.numeroRecibo ) return false;
        if ( valor != null ? !valor.equals ( that.valor ) : that.valor != null ) return false;
        if ( status != null ? !status.equals ( that.status ) : that.status != null ) return false;
        if ( dataOperacao != null ? !dataOperacao.equals ( that.dataOperacao ) : that.dataOperacao != null )
            return false;
        if ( dataVencimento != null ? !dataVencimento.equals ( that.dataVencimento ) : that.dataVencimento != null )
            return false;
        if ( dataBaixa != null ? !dataBaixa.equals ( that.dataBaixa ) : that.dataBaixa != null ) return false;
        if ( parcela != null ? !parcela.equals ( that.parcela ) : that.parcela != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numeroRecibo;
        result = 31 * result + (valor != null ? valor.hashCode () : 0);
        result = 31 * result + (status != null ? status.hashCode () : 0);
        result = 31 * result + (dataOperacao != null ? dataOperacao.hashCode () : 0);
        result = 31 * result + (dataVencimento != null ? dataVencimento.hashCode () : 0);
        result = 31 * result + (dataBaixa != null ? dataBaixa.hashCode () : 0);
        result = 31 * result + (parcela != null ? parcela.hashCode () : 0);
        return result;
    }
}
