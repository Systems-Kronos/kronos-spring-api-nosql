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
@Document(collection = "report")
public class Report {
    @Id
    private String id;

    @DBRef
    private Tarefa Tarefa;

    @Field(name = "cDescricao")
    private String descricao;

    @Field(name = "cProblema")
    private String problema;
}
