package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.TarefaData;
import com.busybrain.api.prototipo.models.TarefaGrupo;
import com.busybrain.api.prototipo.views.TarefaGrupoView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TarefaGrupoRepository extends CrudRepository<TarefaGrupo, Integer>{

    String queryToGetAllTasksOfGroup = "select tarefas.task_id AS taskId, tarefas.task_group_id AS groupId,tarefas.task_title AS taskTitle, tarefas.task_desc AS taskDesc, prioridade.taskpriority_type AS priorityType, userss.user_name AS userName, participante.user_id_tarefa AS participanteId, userss.user_id AS userId " + 
    "from tarefa_grupo AS tarefas " + 
    "inner join prioridadetarefa AS prioridade on tarefas.task_priority_id = prioridade.taskpriority_id " + 
    "inner join grupo AS grupos on tarefas.task_group_id = grupos.group_id " + 
    "inner join utilizador_tarefa AS participante on tarefas.user_task_id = participante.user_identifier " + 
    "inner join utilizador AS userss on participante.user_identifier = userss.user_id ";

    ///////////////// TERMINAR ESTE MÉTODO ADICIONANDO O ID DO GRUPO! /////////////////////////////////////////

    @Query(value = queryToGetAllTasksOfGroup + "where tarefas.task_group_id=:groupid", nativeQuery = true)
    Iterable<TarefaGrupoView> findAllTarefaGrupo(@Param("group_id") int groupid); 

    /*
    @Query(value = queryTestTaskRecyclerView + "where tarefas.user_task_id=:usertaskid", nativeQuery = true)
    Iterable<TarefaView> findAllTarefaByUserid(@Param("usertaskid") int usertaskid);
    */

}
