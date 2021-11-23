package com.busybrain.api.prototipo.controllers;

import java.util.Optional;

import com.busybrain.api.prototipo.models.App;
import com.busybrain.api.prototipo.models.repositories.AppRepository;

import org.hibernate.type.MapType;
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
@RequestMapping(path = "/api/apps")
public class AppController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private AppRepository appRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<App> findAllApps(){

        logger.info("Sending All Apps on users phone...");

        return appRepository.findAll();
    }

    @GetMapping(path = "/blocked", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<App> getBlockedApps(){

        logger.info("Getting all blocked apps");

        return appRepository.findAppByStatus();

    }

    @GetMapping(path = "/unlocked", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<App> getUnlockedApps(){

        logger.info("Getting all unlocked apps");

        return appRepository.findByStatus();

    }

    //METODO PARA TESTES - EM DESENVOLVIMENTO

    @PostMapping(path = "/createapp", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
     public App saveApp(@RequestBody App app){

      App savedApp = appRepository.save(app);
     logger.info("Saving app...");
     return savedApp;

     }

    //TODO -> CONTRUÇÃO DE METODOS DE searchbynamecontaining e blocked status

    /*@GetMapping(path = "/appstatus/{app_status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<App> getAppsBlocked(@PathVariable(value = "app_status") boolean status){

        logger.info("Sending apps that are blocked or unblocked...");
        return appRepository.findAppByStatus(status);
        
    }*/

    @GetMapping(path = "/searchbyname/{app_name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<App> getAppByName(@PathVariable(value = "app_name") String name){

     logger.info("Sending app(s) with the name: " + name);  

     return appRepository.findAppByNameContaining(name);

    }

}
