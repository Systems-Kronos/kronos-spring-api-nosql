package com.kronosapinosql.controller;

import com.kronosapinosql.model.Tarefa;
import com.kronosapinosql.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tarefa")
@RestController
@Tag(name = "Tarefas", description = "Operações relacionadas as tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Operation(summary = "Lista todas as tarefas")
    @GetMapping("/listar")
    public ResponseEntity<List<Tarefa>> listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTodasTarefas();
        if (tarefas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tarefas);
    }

    @Operation(summary = "Busca tarefa pelo ID")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable String id) {
        return tarefaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Inserir uma nova tarefa")
    @PostMapping("/inserir")
    public ResponseEntity<Tarefa> inserirTarefa(@RequestBody Tarefa tarefa) {
        Tarefa salvo = tarefaService.salvar(tarefa);
        return ResponseEntity.status(201).body(salvo);
    }

    @Operation(summary = "Atualiza uma tarefa existente")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable String id, @RequestBody Tarefa tarefa) {
        try {
            Tarefa atualizado = tarefaService.atualizar(id, tarefa);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deleta uma tarefa pelo ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable String id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
