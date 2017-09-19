package com.integrador.representation;

import com.integrador.domain.Funcionario;

/**
 * Created by guilhermeplasma on 15/09/17.
 */
public class FuncionarioRepresentation {

    private int id;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String cpf;
    private String email;
    private String telefone1;
    private String telefone2;
    private Integer numeroResidencia;
    private String complementoResidencia;
    private String situacao;
    private CargoRepresentation cargo;
    private EnderecoRepresentation endereco;
    private UsuarioRepresentation usuario;

    public FuncionarioRepresentation() {
    }

    public FuncionarioRepresentation(int id, String nome, String sobrenome, String sexo, String cpf, String email, String telefone1, String telefone2, Integer numeroResidencia, String complementoResidencia, String situacao, CargoRepresentation cargo, EnderecoRepresentation endereco, UsuarioRepresentation usuario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.numeroResidencia = numeroResidencia;
        this.complementoResidencia = complementoResidencia;
        this.situacao = situacao;
        this.cargo = cargo;
        this.endereco = endereco;
        this.usuario = usuario;
    }

    public FuncionarioRepresentation(Funcionario f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.sobrenome = f.getSobrenome();
        this.sexo = f.getSexo();
        this.cpf = f.getCpf();
        this.email = f.getEmail();
        this.telefone1 = f.getTelefone1();
        this.telefone2 = f.getTelefone2();
        this.numeroResidencia = f.getNumeroResidencia();
        this.complementoResidencia = f.getComplementoResidencia();
        this.situacao = f.getSituacao();
        this.cargo = new CargoRepresentation(f.getCargo());
        this.endereco = new EnderecoRepresentation(f.getEndereco());
        this.usuario = new UsuarioRepresentation(f.getUsuario());
    }

    public Funcionario build(FuncionarioRepresentation r){
        Funcionario f = new Funcionario();

        f.setId(r.getId());
        f.setNome(r.getNome());
        f.setSobrenome(r.getSobrenome());
        f.setSexo(r.getSexo());
        f.setCpf(r.getCpf());
        f.setEmail(r.getEmail());
        f.setTelefone1(r.getTelefone1());
        f.setTelefone2(r.getTelefone2());
        f.setNumeroResidencia(r.getNumeroResidencia());
        f.setComplementoResidencia(r.getComplementoResidencia());
        f.setSituacao(r.getSituacao());
        f.setCargo(new CargoRepresentation().build(r.getCargo()));
        f.setEndereco(new EnderecoRepresentation().build(r.getEndereco()));
        f.setUsuario(new UsuarioRepresentation().build(r.getUsuario()));

        return f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Integer numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getComplementoResidencia() {
        return complementoResidencia;
    }

    public void setComplementoResidencia(String complementoResidencia) {
        this.complementoResidencia = complementoResidencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public CargoRepresentation getCargo() {
        return cargo;
    }

    public void setCargo(CargoRepresentation cargo) {
        this.cargo = cargo;
    }

    public EnderecoRepresentation getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRepresentation endereco) {
        this.endereco = endereco;
    }

    public UsuarioRepresentation getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioRepresentation usuario) {
        this.usuario = usuario;
    }
}
