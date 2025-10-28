package com.kronosapinosql.controller;

import com.kronosapinosql.controller.docs.NotificacaoControllerDocs;
import com.kronosapinosql.service.NotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notificacoes")
@Tag(name = "Notificacao", description = "Operações relacionadas às notificações (Redis)")
public class NotificacaoController implements NotificacaoControllerDocs {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @Override
    public ResponseEntity<List<Map<String, String>>> listarTodasNotificacoes() {
        List<Map<String, String>> notificacoes = notificacaoService.listarTodasNotificacoesJson();
        if (notificacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notificacoes);
    }

    @Override
    public ResponseEntity<List<Map<String, String>>> listarNotificacoesDoUsuario(@PathVariable Integer id) {
        List<Map<String, String>> notificacoes = notificacaoService.listarNotificacoesDoUsuario(id);
        if (notificacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notificacoes);
    }
}
