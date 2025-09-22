package com.kronosapinosql.repository;

import com.kronosapinosql.model.Notificacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends CrudRepository<Notificacao, String> {
}
