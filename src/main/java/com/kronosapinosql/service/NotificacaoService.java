package com.kronosapinosql.service;

import com.kronosapinosql.dto.NotificacaoDTO;
import com.kronosapinosql.model.Notificacao;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class NotificacaoService {

    private final RedisTemplate<String, Object> redisTemplate;

    public NotificacaoService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Salvar notificação
    public void salvarNotificacao(NotificacaoDTO dto, long ttlSegundos) {
        String idNotificacao = UUID.randomUUID().toString();
        Notificacao notificacao = dto.toModel(idNotificacao);

        String chave = "usuario:" + notificacao.getUsuario() + ":notificacao:" + notificacao.getId();

        Map<String, Object> dados = new HashMap<>();
        dados.put("id", notificacao.getId());
        dados.put("usuario", notificacao.getUsuario());
        dados.put("mensagem", notificacao.getMensagem()); // apenas ID da mensagem

        redisTemplate.opsForHash().putAll(chave, dados);

        if (ttlSegundos > 0) {
            redisTemplate.expire(chave, ttlSegundos, TimeUnit.SECONDS);
        }
    }

    // Listar notificações de todos os usuários
    public Map<String, Map<Object, Object>> listarTodasNotificacoes() {
        Map<String, Map<Object, Object>> resultado = new HashMap<>();
        ScanOptions options = ScanOptions.scanOptions().match("usuario:*:notificacao:*").count(100).build();
        Cursor<byte[]> cursor = redisTemplate.getConnectionFactory().getConnection().scan(options);

        while (cursor.hasNext()) {
            String key = new String(cursor.next());
            Map<Object, Object> hash = redisTemplate.opsForHash().entries(key);
            if (!hash.isEmpty()) {
                resultado.put(key, hash);
            }
        }
        return resultado;
    }

    // Listar notificações de um usuário específico
    public List<Map<Object, Object>> listarNotificacoesDoUsuario(Integer usuarioId) {
        List<Map<Object, Object>> resultado = new ArrayList<>();
        String padraoChave = "usuario:" + usuarioId + ":notificacao:*";
        ScanOptions options = ScanOptions.scanOptions().match(padraoChave).count(100).build();
        Cursor<byte[]> cursor = redisTemplate.getConnectionFactory().getConnection().scan(options);

        while (cursor.hasNext()) {
            String key = new String(cursor.next());
            Map<Object, Object> hash = redisTemplate.opsForHash().entries(key);
            if (!hash.isEmpty()) {
                resultado.add(hash);
            }
        }
        return resultado;
    }
}
