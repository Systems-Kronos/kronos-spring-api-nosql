package com.kronosapinosql.service;

import com.kronosapinosql.dto.NotificacaoDTO;
import com.kronosapinosql.model.Notificacao;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;

@Service
public class NotificacaoService {

    private final RedisTemplate<String, Object> redisTemplate;

    public NotificacaoService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Salvar notificação com TTL
    public void salvarNotificacao(NotificacaoDTO dto, long ttlSegundos) {
        String idNotificacao = UUID.randomUUID().toString();
        Notificacao notificacao = dto.toModel(idNotificacao);

        String chave = "usuario:" + notificacao.getUsuario() + ":notificacao:" + notificacao.getId();

        Map<String, Object> dados = new HashMap<>();
        dados.put("id", notificacao.getId());
        dados.put("nCdUsuario", notificacao.getUsuario());
        dados.put("cMensagem", notificacao.getMensagem());

        redisTemplate.opsForHash().putAll(chave, dados);

        if (ttlSegundos > 0) {
            redisTemplate.expire(chave, ttlSegundos, TimeUnit.SECONDS);
        }
    }

    // Lista todas as notificações filtrando campos cMensagem e dCriacao
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

    // Lista notificações de um usuário específico
    public List<Map<String, String>> listarNotificacoesDoUsuario(Integer usuarioId) {
        List<Map<String, String>> resultado = new ArrayList<>();
        String padraoChave = "usuario:" + usuarioId + ":notificacao:*";
        ScanOptions options = ScanOptions.scanOptions().match(padraoChave).count(100).build();

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
