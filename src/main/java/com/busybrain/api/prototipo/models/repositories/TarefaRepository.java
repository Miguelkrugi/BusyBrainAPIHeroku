package com.busybrain.api.prototipo.models.repositories;

import java.util.List;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.TarefaData;
import com.busybrain.api.prototipo.responses.Response;
import com.busybrain.api.prototipo.views.TarefaView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
    
    Iterable<Tarefa> findByType(int type);
    Iterable<Tarefa> findByTitleContaining(String title);
    Iterable<Tarefa> findTaskByUsertaskid(int usertaskid);
    

    String queryByTaskCardview = "select tarefas.task_title AS taskTitle, tarefas.task_desc AS taskDesc, priority.taskpriority_type AS prioridade, tarefas.task_id AS taskId " +
    "from tarefa AS tarefas " + 
    "inner join prioridadetarefa priority on priority.taskpriority_id = tarefas.task_priority_id " + 
    "inner join tipotarefa tipo on tarefas.task_type_id = tipo.tasktype_id";

    String queryTestTaskRecyclerView = "select tarefas.task_title AS taskTitle, tarefas.task_desc AS taskDesc, priority.taskpriority_type AS prioridade " +
    "from tarefa AS tarefas " +
    "inner join prioridadetarefa priority on priority.taskpriority_id = tarefas.task_priority_id " + 
    "inner join tipotarefa tipo on tarefas.task_type_id = tipo.tasktype_id " +
    "inner join utilizador users on tarefas.user_task_id = users.user_id ";


    String queryFindByPriority = "select tarefas.task_title AS taskTitle, tarefas.task_desc AS taskDesc, priority.taskpriority_type AS prioridade, tarefas.task_id AS taskId " +
    "from tarefa AS tarefas " + 
    "inner join prioridadetarefa priority on priority.taskpriority_id = tarefas.task_priority_id " + 
    "inner join tipotarefa tipo on tarefas.task_type_id = tipo.tasktype_id ";

    String queryToDeleteTask = "delete from tarefa AS tarefas ";

    //inner join utilizador users on users.user_id = tarefas.user_task_id

    @Query(value = "SELECT * FROM tarefa WHERE task_priority = '3'", nativeQuery = true)
    Iterable<Tarefa> findTaskByPriority();

    @Query(value = "SELECT * FROM tarefa", nativeQuery = true)
    Iterable<Tarefa> findAllTasks();

    @Query(value = queryByTaskCardview, nativeQuery = true)
    Iterable<TarefaView> findAllTarefa(); 

    @Query(value = queryTestTaskRecyclerView + "where tarefas.user_task_id=:usertaskid", nativeQuery = true)
    Iterable<TarefaView> findAllTarefaByUserid(@Param("usertaskid") int usertaskid);

    @Query(value = queryFindByPriority + "where priority.taskpriority_id=:priority" , nativeQuery = true)
    Iterable<TarefaView> findByPriority(@Param("priority") int priority); 

    //@Query(value = queryToDeleteTask + "where task_id=:taskid", nativeQuery = true)
    //Respons

    @Query(value = queryToDeleteTask + "where task_id:= taskid", nativeQuery = true)
    Iterable<TarefaView> deleteByTaskid(@Param("taskid") int taskid);

}
