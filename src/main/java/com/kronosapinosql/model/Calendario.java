package com.kronosapinosql.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "Usuário não pode ser nulo")
    @Field(name = "nCdUsuario")
    private Integer usuario;

    @NotNull(message = "Dia não pode ser nulo")
    @Field(name = "dDia")
    private Date dia;

    @NotNull(message = "Presença não pode ser nula")
    @Field(name = "bPresenca")
    private Boolean presenca;

    @Size(max = 500, message = "Observação pode ter no máximo 500 caracteres")
    @Field(name = "cObservacao")
    private String observacao;

    @Size(max = 50, message = "CRM pode ter no máximo 50 caracteres")
    @Field(name = "cCRM")
    private String crm;

    @Size(max = 50, message = "CID pode ter no máximo 50 caracteres")
    @Field(name = "cCID")
    private String cid;

    @NotNull(message = "Aceito não pode ser nulo")
    @Field(name = "bAceito")
    private Boolean aceito;

    @Size(max = 500, message = "Atestado pode ter no máximo 500 caracteres")
    @Field(name = "cAtestado")
    private String atestado;

}
