package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.TarefaGrupo;
import com.busybrain.api.prototipo.models.repositories.TarefaGrupoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
/*
    @GetMapping(path = "/gettasksgrupo/{group_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<>
    */


     //CRIAR UMA TAREFA NO GRUPO

    @PostMapping(path = "/createtaskgrupo", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public TarefaGrupo saveTarefaGrupo(@PathVariable(value = "group_id") int id,@RequestBody TarefaGrupo tarefaGrupo){

       TarefaGrupo savedTarefaGrupo = tarefaGrupoRepository.save(tarefaGrupo);
       logger.info("Saving tarefa...");
       return savedTarefaGrupo;

    }

    
}
