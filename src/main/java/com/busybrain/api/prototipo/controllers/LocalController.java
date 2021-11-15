package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Local;
import com.busybrain.api.prototipo.models.repositories.LocalRepository;

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
@RequestMapping(path = "/api/locals")
public class LocalController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private LocalRepository localRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Local> findAllLocals(){

        logger.info("Sending All Locals");

        return localRepository.findAll();
    }

    @GetMapping(path = "/searchbyname/{place_name}")
    public Iterable<Local> localByName(@PathVariable(value = "place_name") String name){

        logger.info("Sending Local with: "+ name + "included.");

        return localRepository.findByNameContaining(name);
    }
    
    @GetMapping(path = "/searchbycategory/cafes")
    public Iterable<Local> localByCategory(){

        logger.info("Sending places with 'Coffee' category...");

        return localRepository.findLocalByCategoria();


    }

//MÉTODO DE SUPORTE PARA TESTE

@PostMapping(path = "/createplace", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
public Local savePlace(@RequestBody Local local){

   Local savedPlace = localRepository.save(local);
   logger.info("Saving place...");
   return savedPlace;

}

}
