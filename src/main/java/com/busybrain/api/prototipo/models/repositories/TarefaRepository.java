package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.views.TarefaView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    Iterable<Tarefa> findByType(int type);
    Iterable<Tarefa> findByTitleContaining(String title);
    Iterable<Tarefa> findTaskByUsertaskid(int usertaskid);
    Iterable<Tarefa> findByPriority(int priority);

    String queryByTaskCardview = "select tarefas.task_title AS taskTitle, tarefas.task_desc AS taskDesc, priority.taskpriority_type AS prioridade " +
    "from tarefa AS tarefas " + 
    "inner join prioridadetarefa priority on priority.taskpriority_id = tarefas.task_priority_id " + 
    "inner join tipotarefa tipo on tarefas.task_type_id = tipo.tasktype_id";

    @Query(value = "SELECT * FROM tarefa WHERE task_priority = '3'", nativeQuery = true)
    Iterable<Tarefa> findTaskByPriority();

    @Query(value = "SELECT * FROM tarefa", nativeQuery = true)
    Iterable<Tarefa> findAllTasks();

    @Query(value = queryByTaskCardview, nativeQuery = true)
    Iterable<TarefaView> findAllTarefa(); 

}
