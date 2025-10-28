package com.kronosapinosql.dto;

import java.util.Date;

public class ObservacaoDTO {
    private String observacao;
    private Date dia;
    private Boolean presenca;

    private String atestado;

    private Integer usuario;

    public ObservacaoDTO(String observacao, Date dia, Boolean presenca, String atestado, Integer usuario) {
        this.observacao = observacao;
        this.dia = dia;
        this.presenca = presenca;
        this.atestado = atestado;
        this.usuario = usuario;
    }

    public String getObservacao() {
        return observacao;
    }

    public Date getDia() {
        return dia;
    }

    public Boolean getPresenca() {return presenca; }

    public String getAtestado() {
        return atestado;
    }

    public Integer getUsuario() {
        return usuario;
    }
}
