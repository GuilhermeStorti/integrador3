package com.integrador.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrador.domain.Campanha;
import com.integrador.domain.Contribuinte;
import com.integrador.domain.Doacao;
import com.integrador.domain.FormaPagamento;
import com.integrador.domain.Funcionario;

import java.util.Date;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class DoacaoRepresentation {

    @JsonInclude
    private int numeroRecibo;
    @JsonInclude
    private Double valor;
    @JsonInclude
    private String status;
    @JsonInclude
    private Date dataOperacao;
    @JsonInclude
    private Date dataVencimento;
    @JsonInclude
    private Date dataBaixa;
    @JsonInclude
    private String parcela;
    @JsonInclude
    private Contribuinte contribuinte;
    @JsonInclude
    private Campanha campanha;
    @JsonInclude
    private FormaPagamento formaPagamento;
    @JsonInclude
    private Funcionario funcionarioMotoboy;
    @JsonInclude
    private Funcionario funcionarioAtendente;

    public DoacaoRepresentation() {
    }

    public DoacaoRepresentation(int numeroRecibo, Double valor, String status, Date dataOperacao, Date dataVencimento, Date dataBaixa, String parcela, Contribuinte contribuinte, Campanha campanha, FormaPagamento formaPagamento, Funcionario funcionarioMotoboy, Funcionario funcionarioAtendente) {
        this.numeroRecibo = numeroRecibo;
        this.valor = valor;
        this.status = status;
        this.dataOperacao = dataOperacao;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.parcela = parcela;
        this.contribuinte = contribuinte;
        this.campanha = campanha;
        this.formaPagamento = formaPagamento;
        this.funcionarioMotoboy = funcionarioMotoboy;
        this.funcionarioAtendente = funcionarioAtendente;
    }

    public DoacaoRepresentation(Doacao d) {
        this.numeroRecibo = d.getNumeroRecibo();
        this.valor = d.getValor();
        this.status = d.getStatus();
        this.dataOperacao = d.getDataOperacao();
        this.dataVencimento = d.getDataVencimento();
        this.dataBaixa = d.getDataBaixa();
        this.parcela = d.getParcela();
        this.contribuinte = d.getContribuinte();
        this.campanha = d.getCampanha();
        this.formaPagamento = d.getFormaPagamento();
        this.funcionarioMotoboy = d.getFuncionarioMotoboy();
        this.funcionarioAtendente = d.getFuncionarioAtendente();
    }

    public Doacao build(DoacaoRepresentation r){
        Doacao doacao= new Doacao();

        doacao.setNumeroRecibo(r.getNumeroRecibo());
        doacao.setValor(r.getValor());
        doacao.setStatus(r.getStatus());
        doacao.setDataOperacao(r.getDataOperacao());
        doacao.setDataVencimento(r.getDataVencimento());
        doacao.setDataBaixa(r.getDataBaixa());
        doacao.setParcela(r.getParcela());
        doacao.setContribuinte(r.getContribuinte());
        doacao.setCampanha(r.getCampanha());
        doacao.setFormaPagamento(r.getFormaPagamento());
        doacao.setFuncionarioMotoboy(r.getFuncionarioMotoboy());
        doacao.setFuncionarioAtendente(r.getFuncionarioAtendente());

        return doacao;
    }

    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(int numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Funcionario getFuncionarioMotoboy() {
        return funcionarioMotoboy;
    }

    public void setFuncionarioMotoboy(Funcionario funcionarioMotoboy) {
        this.funcionarioMotoboy = funcionarioMotoboy;
    }

    public Funcionario getFuncionarioAtendente() {
        return funcionarioAtendente;
    }

    public void setFuncionarioAtendente(Funcionario funcionarioAtendente) {
        this.funcionarioAtendente = funcionarioAtendente;
    }
}
