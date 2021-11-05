package com.busybrain.api.prototipo.controllers;

import java.util.Optional;
import java.util.OptionalInt;

import com.busybrain.api.prototipo.models.Utilizador;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException;
import com.busybrain.api.prototipo.models.repositories.UtilizadorRepository;

import org.apache.catalina.startup.ListenerCreateRule.OptionalListener;
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
@RequestMapping(path = "/api/busybrain/users")
public class UtilizadorController {
    
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class); 
    @Autowired
    private UtilizadorRepository utilizadorRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUsers() {
        logger.info("A Exibir os utilizadores");
        return utilizadorRepository.findAll();
    }

    @GetMapping(path = "/getutilizador/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
     public Utilizador getUtilizador(@PathVariable("username") String username){
 
        logger.info("Sending user...");
 
        Optional<Utilizador> _utilizador = utilizadorRepository.findByUsername(username);
        if(_utilizador.isEmpty()) throw 
           new NotFoundException("" + username, "Utilizador", "username");
        else return _utilizador.get();   
 
     }


    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador saveUtilizador(@RequestBody Utilizador utilizador){

        Utilizador savedUtilizador = utilizadorRepository.save(utilizador);
        logger.info("Saving user...");
        return savedUtilizador;

    }

}
