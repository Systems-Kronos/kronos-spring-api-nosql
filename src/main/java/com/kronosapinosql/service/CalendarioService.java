package com.kronosapinosql.service;

import com.kronosapinosql.model.Calendario;
import com.kronosapinosql.repository.CalendarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {
    private final CalendarioRepository calendarioRepository;

    public CalendarioService(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    public List<Calendario> listarTodosCalendarios() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> buscarPorId(String id) {
        return calendarioRepository.findById(id);
    }

    public List<Calendario> buscarPorUsuario(Integer usuario) {
        return calendarioRepository.buscarPorUsuario(usuario);
    }

    public List<Calendario> buscarPorPresenca(Boolean presenca) {
        return calendarioRepository.buscarPorPresenca(presenca);
    }

    public Calendario salvar(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public Calendario atualizar(String id, Calendario novoCalendario) {
        return calendarioRepository.findById(id)
                .map(calendario -> {
                    calendario.setUsuario(novoCalendario.getUsuario());
                    calendario.setDia(novoCalendario.getDia());
                    calendario.setPresenca(novoCalendario.getPresenca());
                    calendario.setObservacao(novoCalendario.getObservacao());
                    calendario.setCrm(novoCalendario.getCrm());
                    calendario.setCid(novoCalendario.getCid());
                    calendario.setAceito(novoCalendario.getAceito());
                    calendario.setAtestado(novoCalendario.getAtestado());
                    return calendarioRepository.save(calendario);
                })
                .orElseThrow(() -> new RuntimeException("Registro não encontrada!"));
    }

    public void deletar(String id) {
        calendarioRepository.deleteById(id);
    }
}
