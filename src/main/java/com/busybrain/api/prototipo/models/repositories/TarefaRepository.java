package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Tarefa;

import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    Iterable<Tarefa> findByTypeid(int type);
    Iterable<Tarefa> findByTitleContaining(String title);

}
