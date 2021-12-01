package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.UtilizadorTarefa;
import com.busybrain.api.prototipo.models.repositories.UtilizadorTarefaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Iterable<UtilizadorTarefa> getUtilizadorTarefa() {
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

    /*@PostMapping(path = "/createtask", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public Tarefa saveTarefa(@RequestBody Tarefa tarefa){

       Tarefa savedTarefa = tarefaRepository.save(tarefa);
       logger.info("Saving tarefa...");
       return savedTarefa;

    }*/

}
