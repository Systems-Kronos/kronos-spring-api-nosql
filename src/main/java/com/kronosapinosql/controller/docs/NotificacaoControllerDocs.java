package com.kronosapinosql.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Tag(name = "Notificação", description = "Operações relacionadas às notificações (Redis)")
@RequestMapping("/api/notificacoes")
public interface NotificacaoControllerDocs {

    @Operation(summary = "Lista todas as notificações (apenas cMensagem e dCriacao)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de notificações retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma notificação encontrada")
    })
    @GetMapping("/selecionar")
    ResponseEntity<List<Map<String, String>>> listarTodasNotificacoes();

    @Operation(summary = "Lista notificações de um usuário específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de notificações do usuário retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma notificação encontrada para o usuário")
    })
    @GetMapping("/selecionar/{id}")
    ResponseEntity<List<Map<String, String>>> listarNotificacoesDoUsuario(@PathVariable Integer id);
}
