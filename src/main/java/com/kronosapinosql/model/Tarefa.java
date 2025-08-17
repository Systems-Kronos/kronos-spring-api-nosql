package com.kronosapinosql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tarefas")
public class Tarefa {

    @Id
    private String nCdTarefa;
    @Field(name = "cNmTarefa")
    private String nome;

    @Field(name = "cDescricao")
    private String descricao;

    @Field(name = "nCdUsuarioResponsavel")
    @DBRef
    private string nCdUsuarioResponsavel;

    @DBRef
    @Field(name = "nCdHabilidade")
    private string nCdHabilidade;

    @Field(name = "iGravidade")
    private Integer gravidade ;

    @Field(name = "iUrgencia")
    private Integer urgencia;

    @Field(name = "iTendencia")
    private Integer tendencia;

    @Field(name = "nTempoEstimado")
    private Double tempoEstimado;

    public Tarefa(String nCdTarefa, String nome, String descricao, Usuario usuario, Habilidade habilidade, Integer gravidade, Integer urgencia, Integer tendencia, Double tempoEstimado) {
        this.nCdTarefa = nCdTarefa;
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
        this.habilidade = habilidade;
        this.gravidade = gravidade;
        this.urgencia = urgencia;
        this.tendencia = tendencia;
        this.tempoEstimado = tempoEstimado;
    }

    public Tarefa(String nome, String descricao, Usuario usuario, Habilidade habilidade, Integer gravidade, Integer urgencia, Integer tendencia, Double tempoEstimado) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
        this.habilidade = habilidade;
        this.gravidade = gravidade;
        this.urgencia = urgencia;
        this.tendencia = tendencia;
        this.tempoEstimado = tempoEstimado;
    }

    public Tarefa () {}

    public String getnCdTarefa() {
        return nCdTarefa;
    }

    public void setnCdTarefa(String nCdTarefa) {
        this.nCdTarefa = nCdTarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    public Integer getGravidade() {
        return gravidade;
    }

    public void setGravidade(Integer gravidade) {
        this.gravidade = gravidade;
    }

    public Integer getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(Integer urgencia) {
        this.urgencia = urgencia;
    }

    public Integer getTendencia() {
        return tendencia;
    }

    public void setTendencia(Integer tendencia) {
        this.tendencia = tendencia;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
}

