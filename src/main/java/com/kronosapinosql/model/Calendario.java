package com.kronosapinosql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "calendario")
public class Calendario {
    @Id
    private String id;

    @Field(name = "nCdUsuario")
    private Integer usuario;

    @Field(name = "dDia")
    private Date dia;

    @Field(name = "bPresenca")
    private Boolean presenca;

    @Field(name = "cObservacao")
    private String observacao;

    @Field(name = "cCRM")
    private String crm;

    @Field(name = "cCID")
    private String cid;

    @Field(name = "bAceito")
    private Boolean aceito;

    @Field(name = "cAtestado")
    private String atestado;
}
