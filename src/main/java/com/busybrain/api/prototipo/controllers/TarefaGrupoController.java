package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.TarefaGrupo;
import com.busybrain.api.prototipo.models.repositories.TarefaGrupoRepository;
import com.busybrain.api.prototipo.views.TarefaGrupoView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/tasksgrupo")
public class TarefaGrupoController {

    private Logger logger = LoggerFactory.getLogger(TarefaGrupoController.class);
    @Autowired
    private TarefaGrupoRepository tarefaGrupoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) //COMPLETO
   // public Iterable<Tarefa> getTasks() {

    public Iterable<TarefaGrupo> getAllTarefasGrupo(){

        logger.info("A Exibir todas as tarefas criadas na app");

        return tarefaGrupoRepository.findAll();
    }

    //OBTER TODAS AS TAREFAS CRIADAS NUM GRUPO (INFORMAÇÕES A OBTER -> )

    @GetMapping(path = "/gettasksgrupo/{task_group_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TarefaGrupoView> getAllTarefasGrupoGroupId(@PathVariable(value = "task_group_id") int taskgroupid){

        logger.info("Sending all tasks of a group with id: " + taskgroupid);

        return tarefaGrupoRepository.findAllTarefaGrupo(taskgroupid);


    }

    //APAGAR UMA TAREFA (USAR UM DELETE E O ID DA TAREFA)

    @DeleteMapping(path = "/deletetaskfromgrupo/{task_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTarefa(@PathVariable("task_id") int id){

        logger.info("Delete the task with id: " + id);

        tarefaGrupoRepository.deleteById(id);

    }
    


     //CRIAR UMA TAREFA NO GRUPO (SENDO UM DOS ATRIBUTOS O ID DO GRUPO A QUE AQUELA TAREFA PERTENCE)

    @PostMapping(path = "/createtaskgrupo", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public TarefaGrupo saveTarefaGrupo(@RequestBody TarefaGrupo tarefaGrupo){

       TarefaGrupo savedTarefaGrupo = tarefaGrupoRepository.save(tarefaGrupo);
       logger.info("Saving tarefa...");
       return savedTarefaGrupo;

    }

    
}
