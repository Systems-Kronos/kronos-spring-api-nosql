package com.kronosapinosql.repository;

import com.kronosapinosql.model.Calendario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CalendarioRepository extends MongoRepository<Calendario, String> {
    List<Calendario> findByUsuario(Integer usuario);

    List<Calendario> findByPresenca(Boolean presenca);
}
