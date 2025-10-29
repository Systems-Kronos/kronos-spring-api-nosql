package com.kronosapinosql.dto;

import java.util.Date;

public class ObservacaoDTO {
    private String id;
    private String observacao;
    private Date dia;
    private Boolean presenca;

    private String atestado;

    private Integer usuario;

    public ObservacaoDTO(String id, String observacao, Date dia, Boolean presenca, String atestado, Integer usuario) {
        this.id = id;
        this.observacao = observacao;
        this.dia = dia;
        this.presenca = presenca;
        this.atestado = atestado;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
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
