package com.kronosapinosql.controller;

import com.kronosapinosql.dto.NotificacaoDTO;
import com.kronosapinosql.service.NotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notificacoes")
@Tag(name = "Notificacao", description = "Operações relacionadas às notificações (Redis)")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @Operation(summary = "Lista todas as notificações")
    @GetMapping("/selecionar")
    public ResponseEntity<Map<String, Map<Object, Object>>> listarTodasNotificacoes() {
        Map<String, Map<Object, Object>> notificacoes = notificacaoService.listarTodasNotificacoes();
        if (notificacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notificacoes);
    }

    @Operation(summary = "Lista notificações de um usuário")
    @GetMapping("/selecionar/{id}")
    public ResponseEntity<List<Map<Object, Object>>> listarNotificacoesDoUsuario(@PathVariable Integer id) {
        List<Map<Object, Object>> notificacoes = notificacaoService.listarNotificacoesDoUsuario(id);
        if (notificacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notificacoes);
    }

    @Operation(summary = "Cria uma nova notificação")
    @PostMapping("/inserir")
    public ResponseEntity<Void> criarNotificacao(@RequestBody @Valid NotificacaoDTO dto,
                                                 @RequestParam(defaultValue = "0") long ttlSegundos) {
        notificacaoService.salvarNotificacao(dto, ttlSegundos);
        return ResponseEntity.ok().build();
    }
}
