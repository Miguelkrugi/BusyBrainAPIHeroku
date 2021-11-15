package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.App;
import com.busybrain.api.prototipo.models.repositories.AppRepository;

import org.hibernate.type.MapType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

    //TODO -> CONTRUÇÃO DE METODOS DE searchbynamecontaining e blocked status

}
