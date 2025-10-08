package com.kronosapinosql.dto;

import com.kronosapinosql.model.Notificacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacaoDTO {
    @NotNull(message = "O usuário é obrigatório")
    @Positive(message = "Código do usuário deve ser positivo")
    private Integer usuario;

    @NotNull(message = "A mensagem é obrigatória")
    @Positive(message = "Código da mensagem deve ser positivo")
    private Integer mensagem;

    public Notificacao toModel() {
        Notificacao notificacao = new Notificacao();
        notificacao.setUsuario(this.usuario);
        notificacao.setMensagem(this.mensagem);
        return notificacao;
    }
}
