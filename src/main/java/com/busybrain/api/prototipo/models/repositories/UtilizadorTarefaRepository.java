package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.UtilizadorTarefa;
import com.busybrain.api.prototipo.views.UtilizadorTarefaView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilizadorTarefaRepository extends CrudRepository<UtilizadorTarefa, Integer>{
    
    String queryToShowParticipantsInTasks = "select participantes.user_id_tarefa AS idparticipante, usersss.user_name AS nameparticipante, tarefasss.task_title AS nametarefa " +
    "from utilizador_tarefa AS participantes " + "inner join utilizador AS usersss on usersss.user_id = participantes.user_identifier " +
    "inner join tarefa AS tarefasss on tarefasss.task_id = participantes.task_identifier ";

    //STRING A ALTERAR

    String queryToShowParticipantsOfAGroup = "select groups.group_id AS groupId, usertask.user_id_tarefa AS participantId, groups.group_name AS groupName, groups.group_description AS groupDesc, users.user_name AS userName, users.user_id AS userId, usertask.grupo_id AS grupoId " + 
    "from grupo AS groups " + 
    "inner join tarefa tarefas on tarefa_id = task_id " + 
    "inner join utilizador_tarefa usertask on task_id = task_identifier " + 
    "inner join utilizador users on user_identifier = user_id ";

    @Query(value = queryToShowParticipantsInTasks, nativeQuery = true)
    Iterable<UtilizadorTarefaView> findAllUtilizadorTarefa();

    @Query(value = queryToShowParticipantsOfAGroup + "where groups.group_id=:groupid", nativeQuery = true)
    Iterable<UtilizadorTarefaView> findUtilizadorTarefaByGroupid(@Param("groupid") int groupid);

    @Query(value = queryToShowParticipantsOfAGroup + "where usertask.user_id_tarefa=:useridtarefa and groups.group_id=:groupid", nativeQuery = true)
    Iterable<UtilizadorTarefaView> findUtilizadorTarefaByUseridtarefaAndGroupid(@Param("useridtarefa") int useridtarefa, @Param("groupid") int groupid);



    
    @Query(value = queryToShowParticipantsOfAGroup + "where usertask.user_identifier=:userid and groups.group_id=:groupid", nativeQuery = true)
    Iterable<UtilizadorTarefaView> findUtilizadorTarefaByUseridAndGroupid(@Param("userid") int userid, @Param("groupid") int groupid);

    /*
    select participantes.user_id_tarefa AS idparticipante, usersss.user_name AS nameparticipante, tarefasss.task_title
from utilizador_tarefa AS participantes
inner join utilizador AS usersss on usersss.user_id = participantes.user_identifier
inner join tarefa AS tarefasss on tarefasss.task_id = participantes.task_identifier
    */

}
