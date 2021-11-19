package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Tarefa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    Iterable<Tarefa> findByType(int type);
    Iterable<Tarefa> findByTitleContaining(String title);

    @Query(value = "SELECT * FROM tarefa WHERE task_priority = '3'", nativeQuery = true)
    Iterable<Tarefa> findTaskByPriority();

    @Query(value = "SELECT * FROM tarefa", nativeQuery = true)
    Iterable<Tarefa> findAllTasks();

}
