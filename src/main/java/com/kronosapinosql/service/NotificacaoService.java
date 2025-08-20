package com.kronosapinosql.service;

import com.kronosapinosql.model.Notificacao;
import com.kronosapinosql.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<Notificacao> listarTodasNotificacoes() {
        return (List<Notificacao>) notificacaoRepository.findAll();
    }

    public Optional<Notificacao> buscarPorId(String id) {
        return notificacaoRepository.findById(id);
    }

    public Notificacao salvar(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao atualizar(String id, Notificacao novaNotificacao) {
        return notificacaoRepository.findById(id)
                .map(notificacao -> {
                    notificacao.setUsuario(novaNotificacao.getUsuario());
                    notificacao.setMensagem(novaNotificacao.getUsuario());
                    return notificacaoRepository.save(notificacao);
                })
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada!"));
    }

    public void deletar(String id) {
        notificacaoRepository.deleteById(id);
    }
}
