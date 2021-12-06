package com.busybrain.api.prototipo.controllers;

import javax.websocket.server.PathParam;

import com.busybrain.api.prototipo.models.UtilizadorTarefa;
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
    
    private Logger logger = LoggerFactory.getLogger(TarefaController.class); 
    @Autowired
    private UtilizadorTarefaRepository utilizadorTarefaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) //COMPLETO
    public Iterable<UtilizadorTarefaView> getUtilizadorTarefa() {
        logger.info("A Exibir participantes de todas as tarefas na app");
        return utilizadorTarefaRepository.findAllUtilizadorTarefa();
    }

    //ADICIONAR UM UTILIZADOR A UM GRUPO (ADICIONAR A UMA TAREFA)

    @PostMapping(path = "/addparticipant", produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilizadorTarefa saveParticipant(@RequestBody UtilizadorTarefa utilizadorTarefa){

      UtilizadorTarefa savedUtilizadorTarefa = utilizadorTarefaRepository.save(utilizadorTarefa);

      logger.info("Saving participant...");
      return savedUtilizadorTarefa;

    }

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

    //MÉTODO PARA TESTE 

    @PutMapping(path = "/updateparticipante/{user_id_tarefa}")
     public UtilizadorTarefa atualizarParticipante(@PathVariable(value = "user_id_tarefa") int id, @RequestBody UtilizadorTarefa utilizadorTarefa){

     UtilizadorTarefa utilizadorTarefaAtual = utilizadorTarefaRepository.findById(id).get();

     BeanUtils.copyProperties(utilizadorTarefa, utilizadorTarefaAtual, "id");
     return utilizadorTarefaRepository.save(utilizadorTarefaAtual);

}

}
