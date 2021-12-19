package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Grupo;
import com.busybrain.api.prototipo.models.repositories.GrupoRepository;
import com.busybrain.api.prototipo.views.GrupoView;

import org.apache.catalina.connector.Response;
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
@RequestMapping(path = "/api/grupos")
public class GrupoController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private GrupoRepository grupoRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Grupo> findAllGroups(){

        logger.info("Sending All groups...");

        return grupoRepository.findAll();
    }

    /*@GetMapping(path = "/getgroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GrupoView> findAllGrupos(){

        logger.info("Sending all groupss...");

        return grupoRepository.findAllGrupos();

    }*/

    @GetMapping(path = "/getgroups/{user_task_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GrupoView> findAllGrupos(@PathVariable(value = "user_task_id") int usertaskid){

        logger.info("Sending all groups...");

        return grupoRepository.findAllGrupos(usertaskid);

    }

    @PostMapping(path = "/creategroup", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public Grupo saveGroup(@RequestBody Grupo grupo){

       Grupo savedGrupo = grupoRepository.save(grupo);
       logger.info("Saving grupo...");
       return savedGrupo;

    }

    
    //Apagar um grupo
    
    @DeleteMapping(path = "/deletegroup/{group_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGroup(@PathVariable("group_id") int id){

        logger.info("Deleting group with id: " + id);

        grupoRepository.deleteById(id);

    }

   /* @DeleteMapping(path = "/deletetask/{task_id}", produces = MediaType.APPLICATION_JSON_VALUE) //COMPLETO
    public void deleteTarefa(@PathVariable("task_id") int id){

         logger.info("Deleting task with id: " + id);

         tarefaRepository.deleteById(id);

    }*/

}
