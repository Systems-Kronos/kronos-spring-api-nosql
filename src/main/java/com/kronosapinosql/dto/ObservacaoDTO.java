package com.kronosapinosql.dto;

import java.util.Date;

public class ObservacaoDTO {
    private String observacao;
    private Date dia;
    private Boolean presenca;

    private String atestado;

    private Boolean aceito;

    public ObservacaoDTO(String observacao, Date dia, Boolean presenca, String atestado, Boolean aceito) {
        this.observacao = observacao;
        this.dia = dia;
        this.presenca = presenca;
        this.atestado = atestado;
        this.aceito = aceito;
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

    public Boolean getAceito() {
        return aceito;
    }
}
