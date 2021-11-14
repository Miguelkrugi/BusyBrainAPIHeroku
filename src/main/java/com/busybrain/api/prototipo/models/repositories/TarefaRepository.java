package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Tarefa;

import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    Iterable<Tarefa> findByType(int typeid);

    Iterable<Tarefa> findByUserid(int id);

    Iterable<Tarefa> findByTitleContaining(String title);

}
