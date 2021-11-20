package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Convivio;
import com.busybrain.api.prototipo.models.repositories.ConvivioRepository;

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
@RequestMapping(path = "/api/convivios")
public class ConvivioController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private ConvivioRepository convivioRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Convivio> findAllConvivios(){

        logger.info("Sending All 'convivios'...");

        return convivioRepository.findAll();
    }

    @PostMapping(path = "/createconvivio", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public Convivio saveGroup(@RequestBody Convivio convivio){

       Convivio savedConvivio = convivioRepository.save(convivio);
       logger.info("Saving convivio...");
       return savedConvivio;

    }

}
