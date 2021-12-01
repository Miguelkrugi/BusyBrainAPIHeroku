package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.UtilizadorTarefa;
import com.busybrain.api.prototipo.views.UtilizadorTarefaView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilizadorTarefaRepository extends CrudRepository<UtilizadorTarefa, Integer>{
    
    String queryToShowParticipantsInTasks = "select participantes.user_id_tarefa AS idparticipante, usersss.user_name AS nameparticipante, tarefasss.task_title AS nametarefa " +
    "from utilizador_tarefa AS participantes " + "inner join utilizador AS usersss on usersss.user_id = participantes.user_identifier " +
    "inner join tarefa AS tarefasss on tarefasss.task_id = participantes.task_identifier ";

    @Query(value = queryToShowParticipantsInTasks, nativeQuery = true)
    Iterable<UtilizadorTarefaView> findAllUtilizadorTarefa();

    /*
    select participantes.user_id_tarefa AS idparticipante, usersss.user_name AS nameparticipante, tarefasss.task_title
from utilizador_tarefa AS participantes
inner join utilizador AS usersss on usersss.user_id = participantes.user_identifier
inner join tarefa AS tarefasss on tarefasss.task_id = participantes.task_identifier
    */

}
