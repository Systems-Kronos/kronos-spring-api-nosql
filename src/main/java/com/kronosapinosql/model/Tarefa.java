package com.kronosapinosql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tarefa")
public class Tarefa {
    @Id
    private String id;

    @Field(name = "cNmTarefa")
    private String nome;

    @Field(name = "cDescricao")
    private String descricao;

    @DBRef
    @Field(name = "nCdUsuarioResponsavel")
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
}

