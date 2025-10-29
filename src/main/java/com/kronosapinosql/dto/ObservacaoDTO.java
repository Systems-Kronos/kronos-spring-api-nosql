package com.kronosapinosql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObservacaoDTO {
    private String id;
    private Integer usuario;
    private Date dia;
    private Boolean presenca;
    private String observacao;
    private String atestado;
    private Boolean aceito;
}