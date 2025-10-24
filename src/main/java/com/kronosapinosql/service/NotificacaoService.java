package com.kronosapinosql.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.Cursor;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotificacaoService {

    private final RedisTemplate<String, Object> redisTemplate;

    public NotificacaoService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Lista todas as notificações (apenas cMensagem e dCriacao)
    public List<Map<String, String>> listarTodasNotificacoesJson() {
        List<Map<String, String>> resultado = new ArrayList<>();
        ScanOptions options = ScanOptions.scanOptions()
                .match("usuario:*:notificacao:*")
                .count(100)
                .build();

        try (Cursor<byte[]> cursor = redisTemplate.getConnectionFactory().getConnection().scan(options)) {
            while (cursor.hasNext()) {
                String key = new String(cursor.next());
                Map<Object, Object> hash = redisTemplate.opsForHash().entries(key);
                if (!hash.isEmpty()) {
                    Map<String, String> notificacaoJson = hash.entrySet().stream()
                            .filter(e -> e.getKey().equals("cMensagem") || e.getKey().equals("dCriacao"))
                            .collect(Collectors.toMap(
                                    e -> e.getKey().toString(),
                                    e -> e.getValue() != null ? e.getValue().toString() : ""
                            ));
                    resultado.add(notificacaoJson);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log do erro, evita crash
        }

        resultado.sort((n1, n2) -> n2.get("dCriacao").compareTo(n1.get("dCriacao")));
        return resultado;
    }

    // Lista notificações de um usuário específico
    public List<Map<String, String>> listarNotificacoesDoUsuarioJson(Integer usuarioId) {
        List<Map<String, String>> resultado = new ArrayList<>();
        ScanOptions options = ScanOptions.scanOptions()
                .match("usuario:" + usuarioId + ":notificacao:*")
                .count(100)
                .build();

        try (Cursor<byte[]> cursor = redisTemplate.getConnectionFactory().getConnection().scan(options)) {
            while (cursor.hasNext()) {
                String key = new String(cursor.next());
                Map<Object, Object> hash = redisTemplate.opsForHash().entries(key);
                if (!hash.isEmpty()) {
                    Map<String, String> json = hash.entrySet().stream()
                            .filter(e -> e.getKey().equals("cMensagem") || e.getKey().equals("dCriacao"))
                            .collect(Collectors.toMap(
                                    e -> e.getKey().toString(),
                                    e -> e.getValue() != null ? e.getValue().toString() : ""
                            ));
                    resultado.add(json);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        resultado.sort((n1, n2) -> n2.get("dCriacao").compareTo(n1.get("dCriacao")));
        return resultado;
    }
}
