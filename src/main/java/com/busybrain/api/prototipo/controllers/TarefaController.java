package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.repositories.TarefaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/busybrain/tasks")
public class TarefaController {
    
    private Logger logger = LoggerFactory.getLogger(TarefaController.class); 
    @Autowired
    private TarefaRepository tarefaRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tarefa> getTasks() {
        logger.info("A Exibir todas as tarefas criadas na app");
        return tarefaRepository.findAll();
    }

}
