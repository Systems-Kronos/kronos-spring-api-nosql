package com.kronosapinosql.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.Cursor;

import java.util.*;

@Service
public class NotificacaoService {

    private final RedisTemplate<String, Object> redisTemplate;

    public NotificacaoService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Map<String, Map<Object, Object>> listarTodasNotificacoes() {
        Map<String, Map<Object, Object>> resultado = new HashMap<>();

        ScanOptions options = ScanOptions.scanOptions().match("notificacao:*").count(100).build();
        Cursor<byte[]> cursor = redisTemplate.getConnectionFactory()
                .getConnection()
                .scan(options);

        while (cursor.hasNext()) {
            String key = new String(cursor.next());
            Map<Object, Object> hash = redisTemplate.opsForHash().entries(key);
            if (!hash.isEmpty()) {
                resultado.put(key, hash); // mapeia pelo nome da chave
            }
        }

        return resultado;
    }
    public List<Map<Object, Object>> listarNotificacoesDoUsuario(Integer usuarioId) {
        List<Map<Object, Object>> resultado = new ArrayList<>();

        // 1️⃣ Pega os IDs das notificações do set do usuário
        String chaveSet = "usuario:" + usuarioId + ":notificacoes";
        Set<Object> idsNotificacoes = redisTemplate.opsForSet().members(chaveSet);

        if (idsNotificacoes != null) {
            for (Object id : idsNotificacoes) {
                // 2️⃣ Pega cada hash de notificação
                String chaveNotificacao = "notificacao:" + id;
                Map<Object, Object> notificacao = redisTemplate.opsForHash().entries(chaveNotificacao);
                if (!notificacao.isEmpty()) {
                    resultado.add(notificacao);
                }
            }
        }

        return resultado;
    }
}
