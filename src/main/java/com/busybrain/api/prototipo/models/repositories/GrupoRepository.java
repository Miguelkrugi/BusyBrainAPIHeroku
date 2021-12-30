package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Grupo;
import com.busybrain.api.prototipo.views.GrupoView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface GrupoRepository extends CrudRepository<Grupo, Integer>{

    Iterable<Grupo> findGrupoById(int id);
    
    String queryByGroups = "select grupos.group_id AS groupId, grupos.group_name AS groupName, grupos.group_description AS groupDesc, tarefas.task_title AS taskTitle, tarefas.user_task_id AS usertaskId " +
    "from grupo AS grupos " +  
    "inner join tarefa tarefas on tarefas.task_id = grupos.tarefa_id ";

    String groupSelected = "select grupos.group_id AS groupId, grupos.group_name AS groupName, grupos.group_description AS groupDesc, tarefas.task_title AS taskTitle, tarefas.user_task_id AS usertaskId " +
    "from grupo AS grupos " +  
    "inner join tarefa tarefas on tarefas.task_id = grupos.tarefa_id ";

    @Query(value = queryByGroups + "where tarefas.user_task_id=:usertaskid", nativeQuery = true)
    Iterable<GrupoView> findAllGrupos(@Param("usertaskid") int usertaskid);

    @Query(value = groupSelected + "where tarefas.user_task_id=:usertaskid and grupos.group_id=:groupid", nativeQuery = true)
    GrupoView findGrupoByUsertaskidAndId(@Param("usertaskid") int usertaskid, @PathVariable("groupid") int id);

}
