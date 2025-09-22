package com.kronosapinosql.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("notificacao")
public class Notificacao {
    @Id
    private String id;

    @NotNull(message = "O id do usuário não pode estar vazio")
    private Integer usuario;

    @NotNull(message = "O id da mensagem não pode estar vazia")
    private Integer mensagem;
}
