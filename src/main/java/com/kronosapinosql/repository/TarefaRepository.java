package com.kronosapinosql.repository;

import com.kronosapinosql.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaRepository extends MongoRepository<Tarefa, String>{

}
