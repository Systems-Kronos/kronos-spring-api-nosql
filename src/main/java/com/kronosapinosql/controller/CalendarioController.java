package com.kronosapinosql.controller;

import com.kronosapinosql.controller.docs.CalendarioControllerDocs;
import com.kronosapinosql.dto.ObservacaoDTO;
import com.kronosapinosql.model.Calendario;
import com.kronosapinosql.service.CalendarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalendarioController implements CalendarioControllerDocs {
    private final CalendarioService calendarioService;

    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @Override
    public ResponseEntity<List<Calendario>> listarTodosCalendarios() {
        List<Calendario> calendarios = calendarioService.listarTodosCalendarios();
        if (calendarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(calendarios);
    }

    @Override
    public ResponseEntity<Calendario> buscarPorId(@PathVariable String id) {
        return calendarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Calendario>> buscarPorUsuario(@PathVariable Integer idUsuario) {
        List<Calendario> calendarios = calendarioService.buscarPorUsuario(idUsuario);
        return ResponseEntity.ok(calendarios);
    }

    @Override
    public ResponseEntity<List<Calendario>> buscarPorPresenca(@PathVariable Boolean presenca) {
        List<Calendario> calendarios = calendarioService.buscarPorPresenca(presenca);
        return ResponseEntity.ok(calendarios);
    }
    @Override
    public List<ObservacaoDTO> buscarObservacoesEDiasPorGestor(@PathVariable Integer idGestor) {
        return calendarioService.buscarObservacoesEDiasPorGestor(idGestor);
    }

    @Override
    public ResponseEntity<Calendario> inserirReport(@Valid @RequestBody Calendario calendario) {
        Calendario salvo = calendarioService.salvar(calendario);
        return ResponseEntity.status(201).body(salvo);
    }

    @Override
    public ResponseEntity<Calendario> atualizarReport(@PathVariable String id, @Valid @RequestBody Calendario calendario) {
        try {
            Calendario atualizado = calendarioService.atualizar(id, calendario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Calendario> atualizarStatus(@PathVariable String id, @Valid @RequestBody Calendario calendario) {
        try {
            Calendario atualizado = calendarioService.atualizarStatus(id, calendario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deletarReport(@PathVariable String id) {
        calendarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
