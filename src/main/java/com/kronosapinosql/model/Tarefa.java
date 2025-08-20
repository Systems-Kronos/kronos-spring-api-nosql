package com.kronosapinosql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tarefas")
public class Tarefa {

    @Id
    @Field(name = "nCdTarefa")
    private String id;
    @Field(name = "cNmTarefa")
    private String nome;

    @Field(name = "cDescricao")
    private String descricao;

    @Field(name = "nCdUsuarioResponsavel")
    @DBRef
    private String nCdUsuarioResponsavel;

    @DBRef
    @Field(name = "nCdHabilidade")
    private String nCdHabilidade;

    @Field(name = "iGravidade")
    private Integer gravidade ;

    @Field(name = "iUrgencia")
    private Integer urgencia;

    @Field(name = "iTendencia")
    private Integer tendencia;

    @Field(name = "nTempoEstimado")
    private Double tempoEstimado;

    public Tarefa(String id, String nome, String descricao, String nCdUsuarioResponsavel, String nCdHabilidade, Integer gravidade, Integer urgencia, Integer tendencia, Double tempoEstimado) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nCdUsuarioResponsavel = nCdUsuarioResponsavel;
        this.nCdHabilidade = nCdHabilidade;
        this.gravidade = gravidade;
        this.urgencia = urgencia;
        this.tendencia = tendencia;
        this.tempoEstimado = tempoEstimado;
    }

    public Tarefa(String nome, String descricao, String nCdUsuarioResponsavel, String nCdHabilidade, Integer gravidade, Integer urgencia, Integer tendencia, Double tempoEstimado) {
        this.nome = nome;
        this.descricao = descricao;
        this.nCdUsuarioResponsavel = nCdUsuarioResponsavel;
        this.nCdHabilidade = nCdHabilidade;
        this.gravidade = gravidade;
        this.urgencia = urgencia;
        this.tendencia = tendencia;
        this.tempoEstimado = tempoEstimado;
    }

    public Tarefa () {}

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
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

    public String getnCdUsuarioResponsavel() {
        return nCdUsuarioResponsavel;
    }

    public String setnCdUsuarioResponsavel(String nCdUsuarioResponsavel) {
        return nCdUsuarioResponsavel;
    }

    public String getnCdHabilidade() {
        return nCdHabilidade;
    }

    public void setnCdHabilidade(String nCdHabilidade) {
        this.nCdHabilidade = nCdHabilidade;
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

