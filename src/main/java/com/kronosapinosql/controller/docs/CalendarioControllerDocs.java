package com.kronosapinosql.controller.docs;

import com.kronosapinosql.dto.AtualizarStatusDTO;
import com.kronosapinosql.dto.ObservacaoDTO;
import com.kronosapinosql.model.Calendario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Calendário", description = "Operações relacionadas ao calendário")
@RequestMapping("/api/calendario")
public interface CalendarioControllerDocs {
    @Operation(summary = "Lista todos os registros do calendário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de calendários retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhum calendário encontrado")
    })
    @GetMapping("/selecionar")
    ResponseEntity<List<Calendario>> listarTodosCalendarios();

    @Operation(summary = "Busca calendário pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calendário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Calendário não encontrado")
    })
    @GetMapping("/selecionar/{id}")
    ResponseEntity<Calendario> buscarPorId(@PathVariable String id);

    @Operation(summary = "Busca calendário pelo ID do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de calendários do usuário retornada com sucesso")
    })
    @GetMapping("/selecionar/usuario/{idUsuario}")
    ResponseEntity<List<Calendario>> buscarPorUsuario(@PathVariable Integer idUsuario);

    @Operation(summary = "Busca calendário por presença")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de calendários filtrada por presença retornada com sucesso")
    })
    @GetMapping("/selecionarPresenca/{presenca}")
    ResponseEntity<List<Calendario>> buscarPorPresenca(@PathVariable Boolean presenca);

    @Operation(summary = "Busca observações pelo gestor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de observações e dias retornada com sucesso")
    })
    @GetMapping("/selecionarObservacoesGestor/{idGestor}")
    List<ObservacaoDTO> buscarObservacoesEDiasPorGestor(@PathVariable Integer idGestor);

    @Operation(summary = "Insere um novo calendário")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Calendário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping("/adicionar")
    ResponseEntity<Calendario> inserirReport(@Valid @RequestBody Calendario calendario);

    @Operation(summary = "Atualiza um calendário existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calendário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Calendário não encontrado")
    })
    @PutMapping("/atualizar/{id}")
    ResponseEntity<Calendario> atualizarReport(@PathVariable String id, @Valid @RequestBody Calendario calendario);

    @Operation(summary = "Atualiza o status de um calendário existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calendário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Calendário não encontrado")
    })
    @PutMapping("/atualizarStatus/{id}")
    ResponseEntity<Calendario> atualizarStatus(@PathVariable String id, @Valid AtualizarStatusDTO atualizarStatusDTO);

    @Operation(summary = "Deleta um calendário pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Calendário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Calendário não encontrado")
    })
    @DeleteMapping("/deletar/{id}")
    ResponseEntity<Void> deletarReport(@PathVariable String id);
}
