package com.kronosapinosql.model;

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
@RedisHash("Notificacao")
public class Notificacao {
    @Id
    private String id;

    @Field(name = "nCdUsuario")
    private Integer usuario;

    @Field(name = "nCdMensagem")
    private Integer mensagem;
}
