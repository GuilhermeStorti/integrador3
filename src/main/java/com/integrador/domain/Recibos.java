package com.integrador.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by guilhermeplasma on 15/08/17.
 */
@Entity
public class Recibos {
    private int numeroRecibo;
    private BigInteger valor;
    private String status;
    private Date dataOperacao;
    private Date dataVencimento;
    private Date dataBaixa;
    private String parcela;
    private Contribuinte contribuinteByIdContribuinte;
    private Campanha campanhaByIdCampanha;
    private FormaPagamento formaPagamentoByIdFormaPagamento;
    private Funcionario funcionarioByIdFuncionario;

    @Id
    @Column(name = "numero_recibo")
    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(int numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    @Basic
    @Column(name = "valor")
    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "data_operacao")
    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    @Basic
    @Column(name = "data_vencimento")
    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Basic
    @Column(name = "data_baixa")
    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    @Basic
    @Column(name = "parcela")
    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recibos recibos = (Recibos) o;

        if (numeroRecibo != recibos.numeroRecibo) return false;
        if (valor != null ? !valor.equals(recibos.valor) : recibos.valor != null) return false;
        if (status != null ? !status.equals(recibos.status) : recibos.status != null) return false;
        if (dataOperacao != null ? !dataOperacao.equals(recibos.dataOperacao) : recibos.dataOperacao != null)
            return false;
        if (dataVencimento != null ? !dataVencimento.equals(recibos.dataVencimento) : recibos.dataVencimento != null)
            return false;
        if (dataBaixa != null ? !dataBaixa.equals(recibos.dataBaixa) : recibos.dataBaixa != null) return false;
        if (parcela != null ? !parcela.equals(recibos.parcela) : recibos.parcela != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numeroRecibo;
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dataOperacao != null ? dataOperacao.hashCode() : 0);
        result = 31 * result + (dataVencimento != null ? dataVencimento.hashCode() : 0);
        result = 31 * result + (dataBaixa != null ? dataBaixa.hashCode() : 0);
        result = 31 * result + (parcela != null ? parcela.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_contribuinte", referencedColumnName = "id", nullable = false)
    public Contribuinte getContribuinteByIdContribuinte() {
        return contribuinteByIdContribuinte;
    }

    public void setContribuinteByIdContribuinte(Contribuinte contribuinteByIdContribuinte) {
        this.contribuinteByIdContribuinte = contribuinteByIdContribuinte;
    }

    @ManyToOne
    @JoinColumn(name = "id_campanha", referencedColumnName = "id", nullable = false)
    public Campanha getCampanhaByIdCampanha() {
        return campanhaByIdCampanha;
    }

    public void setCampanhaByIdCampanha(Campanha campanhaByIdCampanha) {
        this.campanhaByIdCampanha = campanhaByIdCampanha;
    }

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id", nullable = false)
    public FormaPagamento getFormaPagamentoByIdFormaPagamento() {
        return formaPagamentoByIdFormaPagamento;
    }

    public void setFormaPagamentoByIdFormaPagamento(FormaPagamento formaPagamentoByIdFormaPagamento) {
        this.formaPagamentoByIdFormaPagamento = formaPagamentoByIdFormaPagamento;
    }

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id", nullable = false)
    public Funcionario getFuncionarioByIdFuncionario() {
        return funcionarioByIdFuncionario;
    }

    public void setFuncionarioByIdFuncionario(Funcionario funcionarioByIdFuncionario) {
        this.funcionarioByIdFuncionario = funcionarioByIdFuncionario;
    }
}
