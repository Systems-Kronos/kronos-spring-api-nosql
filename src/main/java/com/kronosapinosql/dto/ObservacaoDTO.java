package com.kronosapinosql.dto;

import java.util.Date;

public class ObservacaoDTO {
    private String observacao;
    private Date dia;
    private Boolean presenca;
    public ObservacaoDTO(String observacao, Date dia, Boolean presenca) {
        this.observacao = observacao;
        this.dia = dia;
        this.presenca = presenca;
    }

    public String getObservacao() {
        return observacao;
    }

    public Date getDia() {
        return dia;
    }

    public Boolean getPresenca() {return presenca; }
}
