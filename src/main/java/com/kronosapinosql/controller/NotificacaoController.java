package com.kronosapinosql.controller;

import com.kronosapinosql.model.Notificacao;
import com.kronosapinosql.service.NotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
@Tag(name = "Notificacao", description = "Operações relacionadas as notificações")
public class NotificacaoController {
    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @Operation(summary = "Lista todos as notificações")
    @GetMapping("/selecionar")
    public ResponseEntity<List<Notificacao>> listarTodasNotificacoes() {
        List<Notificacao> notificacoes = notificacaoService.listarTodasNotificacoes();
        if (notificacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notificacoes);
    }

    @Operation(summary = "Busca notificação pelo ID")
    @GetMapping("/selecionar/{id}")
    public ResponseEntity<Notificacao> buscarPorId(@PathVariable String id) {
        return notificacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Inserir uma nova notificação")
    @PostMapping("/adicionar")
    public ResponseEntity<Notificacao> inserirNotificacao(@RequestBody Notificacao notificacao) {
        Notificacao salvo = notificacaoService.salvar(notificacao);
        return ResponseEntity.status(201).body(salvo);
    }

    @Operation(summary = "Atualiza uma notificação existente")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Notificacao> atualizarNotificacao(@PathVariable String id, @RequestBody Notificacao notificacao) {
        try {
            Notificacao atualizado = notificacaoService.atualizar(id, notificacao);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deleta uma notificação pelo ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarNotificacao(@PathVariable String id) {
        notificacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
