package com.kronosapinosql.service;

import com.kronosapinosql.model.Tarefa;
import com.kronosapinosql.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(String id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(String id, Tarefa novaTarefa) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setNome(novaTarefa.getNome());
                    tarefa.setDescricao(novaTarefa.getDescricao());
                    tarefa.setnCdUsuarioResponsavel(novaTarefa.getnCdUsuarioResponsavel());
                    tarefa.setnCdHabilidade(novaTarefa.getnCdHabilidade());
                    tarefa.setGravidade(novaTarefa.getGravidade());
                    tarefa.setUrgencia(novaTarefa.getUrgencia());
                    tarefa.setTendencia(novaTarefa.getTendencia());
                    tarefa.setTempoEstimado(novaTarefa.getTempoEstimado());
                    return tarefaRepository.save(tarefa);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    public void deletar(String id) {
        tarefaRepository.deleteById(id);
    }
}
