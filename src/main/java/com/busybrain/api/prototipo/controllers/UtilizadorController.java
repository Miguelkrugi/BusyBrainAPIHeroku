package com.busybrain.api.prototipo.controllers;

import java.util.Optional;
import java.util.OptionalInt;

import com.busybrain.api.prototipo.models.Utilizador;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException2;
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

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
     public Utilizador getUtilizador(@PathVariable("id") int id){
 
        logger.info("Sending user with id: " + id);
 
        Optional<Utilizador> _utilizador = utilizadorRepository.findById(id);
        if(!_utilizador.isPresent()) throw 
           new NotFoundException2("" + id, "Utilizador", "ID");
        else return _utilizador.get();   
 
     }

    @GetMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizadorUsername(@PathVariable("username") String username){

         logger.info("Sending user with username: " + username);

         Optional<Utilizador> _utilizador = utilizadorRepository.findByUsername(username);
         if(!_utilizador.isPresent()) throw
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
