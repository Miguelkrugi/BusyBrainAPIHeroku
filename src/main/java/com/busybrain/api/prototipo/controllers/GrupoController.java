package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Grupo;
import com.busybrain.api.prototipo.models.repositories.GrupoRepository;

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
@RequestMapping(path = "/api/grupos")
public class GrupoController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private GrupoRepository grupoRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Grupo> findAllWebsites(){

        logger.info("Sending All groups...");

        return grupoRepository.findAll();
    }

    @PostMapping(path = "/creategroup", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public Grupo saveGroup(@RequestBody Grupo grupo){

       Grupo savedGrupo = grupoRepository.save(grupo);
       logger.info("Saving grupo...");
       return savedGrupo;

    }

}
