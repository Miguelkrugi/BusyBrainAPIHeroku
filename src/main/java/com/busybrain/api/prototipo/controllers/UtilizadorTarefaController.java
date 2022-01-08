package com.busybrain.api.prototipo.controllers;

import javax.print.attribute.standard.Media;
import javax.websocket.server.PathParam;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.UtilizadorTarefa;
import com.busybrain.api.prototipo.models.repositories.TarefaRepository;
import com.busybrain.api.prototipo.models.repositories.TipoTarefaRepository;
import com.busybrain.api.prototipo.models.repositories.UtilizadorTarefaRepository;
import com.busybrain.api.prototipo.views.UtilizadorTarefaView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/participantesgrupos")
public class UtilizadorTarefaController {
    
    private Logger logger = LoggerFactory.getLogger(UtilizadorTarefaController.class); 
    @Autowired
    private UtilizadorTarefaRepository utilizadorTarefaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) //COMPLETO
    public Iterable<UtilizadorTarefaView> getUtilizadorTarefa() {
        logger.info("A Exibir participantes de todas as tarefas na app");
        return utilizadorTarefaRepository.findAllUtilizadorTarefa();
    }



    //ADICIONAR UM UTILIZADOR A UM GRUPO (ADICIONAR A UMA TAREFA - ADICIONAR UM PARTICIPANTE)

    @PostMapping(path = "/addparticipant", produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilizadorTarefa saveParticipant(@RequestBody UtilizadorTarefa utilizadorTarefa){

      UtilizadorTarefa savedUtilizadorTarefa = utilizadorTarefaRepository.save(utilizadorTarefa);

      logger.info("Saving participant...");
      return savedUtilizadorTarefa;

    }

    //APAGAR UM UTILIZADOR DE UM GRUPO (REMOVER DE UMA TAREFA - REMOVER UM PARTICIPANTE PELO SEU ID DE PARTICIPANTE)

    @DeleteMapping(path = "/removeparticipant/{group_id}/{user_identifier}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteParticipante(@PathVariable("group_id") int groupid, @PathVariable("user_identifier") int userid){

        logger.info("Deleting participant of the group with id: " + groupid);

        utilizadorTarefaRepository.deleteById(userid);

    }

    
    @GetMapping(path = "/getallpersons", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UtilizadorTarefa> getAllPersons(){

        logger.info("Sending all persons....");

        return utilizadorTarefaRepository.findAll();

    }


    //OBTER OS PARTICIPANTES DE UM GRUPO

    @GetMapping(path = "/getparticipants/{group_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UtilizadorTarefaView> getParticipants(@PathVariable("group_id") int groupid){

      logger.info("Sending all participants from group with id: " + groupid);

      return utilizadorTarefaRepository.findUtilizadorTarefaByGroupid(groupid);

    }


  

    //OBTER OS PARTICIPANTES DE UM GRUPO (PASSANDO TAMBEM O ID DO UTILIZADOR LOGGADO NA CONTA)

    @GetMapping(path = "/getparticipants/{user_id_tarefa}/{group_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UtilizadorTarefaView> getParticipantsOfGroup(@PathVariable("user_id_tarefa") int useridtarefa, @PathVariable("group_id") int groupid){

      logger.info("Sending all participants of a group with id: " + groupid);

      return utilizadorTarefaRepository.findUtilizadorTarefaByUseridtarefaAndGroupid(useridtarefa, groupid);


    }

    ////////////////////////MÉTODO IGUAL AO DE CIMA//////////////////////////

    @GetMapping(path = "/getparticipantssss/{user_identifier}/{group_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UtilizadorTarefaView> getParticipantsOfAGroupId(@PathVariable("user_identifier") int userid, @PathVariable("group_id") int groupid){

      logger.info("Sending all participants of a group with id: " + groupid);

      return utilizadorTarefaRepository.findUtilizadorTarefaByUseridAndGroupid(userid, groupid);

    }

    //NO PATHVARIABLE A VARIAVEL ANTERIOR ERA -> user_id_tarefa

    //REMOVER UM PARTICIPANTE DE UM GRUPO (REMOVER UTILIZADOR DE UMA TAREFA)

    @DeleteMapping(path = "/deleteparticipant/{user_id_tarefa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteParticipant(@PathVariable("user_id_tarefa") int id){

        logger.info("Deleting participant with id: " + id);

        utilizadorTarefaRepository.deleteById(id);

    }


    
    //---------------------------------- MÉTODOS UTILIZADOS ACIMA NO CÓDIGO --------------------------------------------------------

    /*@PostMapping(path = "/createtask", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public Tarefa saveTarefa(@RequestBody Tarefa tarefa){

       Tarefa savedTarefa = tarefaRepository.save(tarefa);
       logger.info("Saving tarefa...");
       return savedTarefa;

    }*/

    /*
    @DeleteMapping(path = "/deletetask/{task_id}", produces = MediaType.APPLICATION_JSON_VALUE) //COMPLETO
    public void deleteTarefa(@PathVariable("task_id") int id){

         logger.info("Deleting task with id: " + id);

         tarefaRepository.deleteById(id);

    }
    */ 



}
