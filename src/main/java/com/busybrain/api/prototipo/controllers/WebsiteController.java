package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Website;
import com.busybrain.api.prototipo.models.repositories.WebsiteRepository;
import com.fasterxml.jackson.databind.type.MapType;

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
@RequestMapping(path = "/api/websites")
public class WebsiteController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private WebsiteRepository websiteRepository;

    //Obter uma lista de todos os websites disponiveis para bloquear

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Website> findAllWebsites(){

        logger.info("Sending All Websites available to block...");

        return websiteRepository.findAll();
    }

    //Adicionar um website -> METODO DE TESTE

    @PostMapping(path = "/createapp", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
     public Website saveWebsite(@RequestBody Website website){

      Website savedWebsite = websiteRepository.save(website);
     logger.info("Saving website...");
     return savedWebsite;

     }

     //

}
