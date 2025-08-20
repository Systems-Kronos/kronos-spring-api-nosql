package com.kronosapinosql.controller;

import com.kronosapinosql.model.Calendario;
import com.kronosapinosql.service.CalendarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/calendario/")
@RestController
@Tag(name = "Calendario", description = "Operações relacionadas ao calendario")
public class CalendarioController {
    private final CalendarioService calendarioService;

    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @Operation(summary = "Lista todos os registros do calendário")
    @GetMapping("/listar")
    public ResponseEntity<List<Calendario>> listarTodosCalendarios() {
        List<Calendario> calendarios = calendarioService.listarTodosCalendarios();
        if (calendarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(calendarios);
    }

    @Operation(summary = "Busca calendario pelo ID")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Calendario> buscarPorId(@PathVariable String id) {
        return calendarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Busca calendario pelo ID do usuário")
    @GetMapping("/listar/usuario/{idUsuario}")
    public ResponseEntity<List<Calendario>> buscarPorUsuario(@PathVariable Integer idUsuario) {
        List<Calendario> calendarios = calendarioService.buscarPorUsuario(idUsuario);
        return ResponseEntity.ok(calendarios);
    }

    @Operation(summary = "Busca calendario por presenca")
    @GetMapping("/listar/presenca/{presenca}")
    public ResponseEntity<List<Calendario>> buscarPorPresenca(@PathVariable Boolean presenca) {
        List<Calendario> calendarios = calendarioService.buscarPorPresenca(presenca);
        return ResponseEntity.ok(calendarios);
    }

    @Operation(summary = "Inserir um novo calendario")
    @PostMapping("/adicionar")
    public ResponseEntity<Calendario> inserirReport(@RequestBody Calendario calendario) {
        Calendario salvo = calendarioService.salvar(calendario);
        return ResponseEntity.status(201).body(salvo);
    }

    @Operation(summary = "Atualiza um calendario existente")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Calendario> atualizarReport(@PathVariable String id, @RequestBody Calendario calendario) {
        try {
            Calendario atualizado = calendarioService.atualizar(id, calendario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deleta um calendario pelo ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarReport(@PathVariable String id) {
        calendarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
