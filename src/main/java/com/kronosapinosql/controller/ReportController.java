package com.kronosapinosql.controller;

import com.kronosapinosql.model.Report;
import com.kronosapinosql.model.Tarefa;
import com.kronosapinosql.service.ReportService;
import com.kronosapinosql.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/report")
@RestController
@Tag(name = "Reports", description = "Operações relacionadas aos reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @Operation(summary = "Lista todos os reports")
    @GetMapping("/listar")
    public ResponseEntity<List<Report>> listarTodasTarefas() {
        List<Report> reports = reportService.listarTodosReports();
        if (reports.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @Operation(summary = "Busca report pelo ID")
    @GetMapping("/listar/{id}")
    public ResponseEntity<Report> buscarPorId(@PathVariable String id) {
        return reportService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Inserir um novo report")
    @PostMapping("/adicionar")
    public ResponseEntity<Report> inserirReport(@RequestBody Report report) {
        Report salvo = reportService.salvar(report);
        return ResponseEntity.status(201).body(salvo);
    }

    @Operation(summary = "Atualiza um report existente")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Report> atualizarReport(@PathVariable String id, @RequestBody Report report) {
        try {
            Report atualizado = reportService.atualizar(id, report);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deleta um Report pelo ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarReport(@PathVariable String id) {
        reportService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}




