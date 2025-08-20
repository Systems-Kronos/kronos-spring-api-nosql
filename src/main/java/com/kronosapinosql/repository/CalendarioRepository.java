package com.kronosapinosql.repository;

import com.kronosapinosql.model.Calendario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CalendarioRepository extends MongoRepository<Calendario, String> {
    List<Calendario> buscarPorUsuario(Integer usuario);

    List<Calendario> buscarPorPresenca(Boolean presenca);
}
