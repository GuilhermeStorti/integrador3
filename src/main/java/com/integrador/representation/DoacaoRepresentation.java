package com.integrador.representation;

import com.integrador.domain.Doacao;

import java.util.Date;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class DoacaoRepresentation {

    private int numeroRecibo;
    private Double valor;
    private String status;
    private Date dataOperacao;
    private Date dataVencimento;
    private Date dataBaixa;
    private String parcela;
    private ContribuinteRepresentation contribuinte;
    private CampanhaRepresentation campanha;
    private FormaPagamentoRepresentation formaPagamento;
    private FuncionarioRepresentation funcionarioMotoboy;
    private FuncionarioRepresentation funcionarioAtendente;

    public DoacaoRepresentation() {
    }

    public DoacaoRepresentation(int numeroRecibo, Double valor, String status, Date dataOperacao, Date dataVencimento, Date dataBaixa, String parcela, ContribuinteRepresentation contribuinte, CampanhaRepresentation campanha, FormaPagamentoRepresentation formaPagamento, FuncionarioRepresentation funcionarioMotoboy, FuncionarioRepresentation funcionarioAtendente) {
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
        this.contribuinte = new ContribuinteRepresentation(d.getContribuinte());
        this.campanha = new CampanhaRepresentation(d.getCampanha());
        this.formaPagamento = new FormaPagamentoRepresentation(d.getFormaPagamento());
        this.funcionarioMotoboy = new FuncionarioRepresentation(d.getFuncionarioMotoboy());
        this.funcionarioAtendente = new FuncionarioRepresentation(d.getFuncionarioAtendente());
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
        doacao.setContribuinte(new ContribuinteRepresentation().build(r.contribuinte));
        doacao.setCampanha(new CampanhaRepresentation().build(r.campanha));
        doacao.setFormaPagamento(new FormaPagamentoRepresentation().build(r.formaPagamento));
        doacao.setFuncionarioMotoboy(new FuncionarioRepresentation().build(r.funcionarioMotoboy));
        doacao.setFuncionarioAtendente(new FuncionarioRepresentation().build(r.funcionarioAtendente));

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

    public ContribuinteRepresentation getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(ContribuinteRepresentation contribuinte) {
        this.contribuinte = contribuinte;
    }

    public CampanhaRepresentation getCampanha() {
        return campanha;
    }

    public void setCampanha(CampanhaRepresentation campanha) {
        this.campanha = campanha;
    }

    public FormaPagamentoRepresentation getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoRepresentation formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public FuncionarioRepresentation getFuncionarioMotoboy() {
        return funcionarioMotoboy;
    }

    public void setFuncionarioMotoboy(FuncionarioRepresentation funcionarioMotoboy) {
        this.funcionarioMotoboy = funcionarioMotoboy;
    }

    public FuncionarioRepresentation getFuncionarioAtendente() {
        return funcionarioAtendente;
    }

    public void setFuncionarioAtendente(FuncionarioRepresentation funcionarioAtendente) {
        this.funcionarioAtendente = funcionarioAtendente;
    }
}
