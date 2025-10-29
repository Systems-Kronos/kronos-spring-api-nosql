package com.kronosapinosql.dto;

import com.kronosapinosql.model.Notificacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class NotificacaoDTO {
    @NotNull(message = "O usuário é obrigatório")
    @Positive(message = "O id do usuário deve ser positivo")
    private Integer usuario;

    @NotNull(message = "A mensagem é obrigatória")
    @Positive(message = "O id da mensagem deve ser positivo")
    private Integer mensagem;

    public Notificacao toModel(String id) {
        Notificacao notificacao = new Notificacao();
        notificacao.setId(id);
        notificacao.setUsuario(this.usuario);
        notificacao.setMensagem(this.mensagem);
        return notificacao;
    }
}
