package com.kronosapinosql.service;

import com.kronosapinosql.dto.ObservacaoDTO;
import com.kronosapinosql.model.Calendario;
import com.kronosapinosql.repository.CalendarioRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class CalendarioService {
    private final CalendarioRepository calendarioRepository;
    private final RestTemplate restTemplate;

    public CalendarioService(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
        this.restTemplate = new RestTemplate();
    }

    public List<Calendario> listarTodosCalendarios() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> buscarPorId(String id) {
        return calendarioRepository.findById(id);
    }

    public List<Calendario> buscarPorUsuario(Integer usuario) {
        return calendarioRepository.findByUsuario(usuario);
    }

    public List<Calendario> buscarPorGestor(Integer idGestor) {
        return calendarioRepository.findByIdGestor(idGestor);
    }

    public List<Calendario> buscarPorPresenca(Boolean presenca) {
        return calendarioRepository.findByPresenca(presenca);
    }

    public List<ObservacaoDTO> buscarObservacoesEDiasPorGestor(Integer idGestor) {
        List<Calendario> calendarios = calendarioRepository.findByIdGestor(idGestor);
        return calendarios.stream()
                .map(c -> new ObservacaoDTO(c.getObservacao(), c.getEvento()))
                .toList();
    }

    public Calendario salvar(Calendario calendario) {
        Calendario salvo = calendarioRepository.save(calendario);

        if (!Boolean.TRUE.equals(salvo.getPresenca()) && eventoEHoje(salvo.getEvento())) {
            try {
                chamarEndpointRealocacao(salvo.getUsuario());
            } catch (Exception e) {
                System.err.println("⚠️ Erro ao chamar endpoint de realocação: " + e.getMessage());
            }
        }

        return salvo;
    }

    public Calendario atualizar(String id, Calendario novoCalendario) {
        return calendarioRepository.findById(id)
                .map(calendario -> {
                    calendario.setUsuario(novoCalendario.getUsuario());
                    calendario.setEvento(novoCalendario.getEvento());
                    calendario.setPresenca(novoCalendario.getPresenca());
                    calendario.setObservacao(novoCalendario.getObservacao());
                    calendario.setCrm(novoCalendario.getCrm());
                    calendario.setCid(novoCalendario.getCid());
                    calendario.setAceito(novoCalendario.getAceito());
                    calendario.setAtestado(novoCalendario.getAtestado());
                    return calendarioRepository.save(calendario);
                })
                .orElseThrow(() -> new RuntimeException("Registro não encontrado!"));
    }

    public void deletar(String id) {
        calendarioRepository.deleteById(id);
    }

    private boolean eventoEHoje(Date dataEvento) {
        LocalDate dataEventoLocal = dataEvento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate hoje = LocalDate.now(ZoneId.systemDefault());
        return dataEventoLocal.isEqual(hoje);
    }

    private void chamarEndpointRealocacao(Integer idUsuario) {
        String url = "https://kronos-python-api-realocacao.onrender.com/realocar-tarefa";

        Map<String, Object> body = new HashMap<>();
        body.put("idUsuario", idUsuario);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        restTemplate.postForEntity(url, request, String.class);
    }
}
