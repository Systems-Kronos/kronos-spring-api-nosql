package com.kronosapinosql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;

import java.lang.ref.PhantomReference;

@Document(collection = "report")
public class Report {
    @Id
    @Field(name = "nCdReport")
    private String id;
    @DBRef
    private Tarefa Tarefa;
    @Field(name = "cDescricao")
    private String descricao;

    @Field(name = "cProblema")
    private String problema;

    public Report(String id, Tarefa tarefa, String descricao, String problema) {
        this.id = id;
        Tarefa = tarefa;
        this.descricao = descricao;
        this.problema = problema;
    }

    public Report(Tarefa tarefa, String descricao, String problema) {
        Tarefa = tarefa;
        this.descricao = descricao;
        this.problema = problema;
    }

    public Report(){}

    public Tarefa getTarefa() {
        return Tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        Tarefa = tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
