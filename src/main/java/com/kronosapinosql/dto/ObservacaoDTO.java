package com.kronosapinosql.dto;

import java.util.Date;

public class ObservacaoDTO {
    private String observacao;
    private Date dia; 
    public ObservacaoDTO(String observacao, Date dia) {
        this.observacao = observacao;
        this.dia = dia;
    }

    public String getObservacao() {
        return observacao;
    }

    public Date getDia() {
        return dia;
    }
}
