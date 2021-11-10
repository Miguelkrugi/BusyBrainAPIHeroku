package com.busybrain.api.prototipo.controllers;

import java.util.Optional;
import java.util.OptionalInt;

import javax.print.attribute.standard.Media;

import com.busybrain.api.prototipo.models.Utilizador;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException2;
import com.busybrain.api.prototipo.models.repositories.UtilizadorRepository;

import org.apache.catalina.startup.ListenerCreateRule.OptionalListener;
import org.apache.coyote.Response;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //Indica que estamos a usar um controller
@RequestMapping(path = "/api/users") //URL "geral" do controller. Será a partir deste URL que poderemos aceder aos métodos deste controller
public class UtilizadorController { //Inicio do controller
    
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class); //Criação do logger. Será responsável 
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

     @GetMapping(path = "/getUsernameById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
     public String getUsernameById(@PathVariable("id") int id){
 
        logger.info("Sending user with id: " + id);
 
        Optional<Utilizador> _utilizador = utilizadorRepository.findById(id);
        if(!_utilizador.isPresent()) throw 
           new NotFoundException2("" + id, "Utilizador", "ID");
        else return _utilizador.get().getUsername();   
 
     }

     //CHANGED
    /*@GetMapping(path = "/getusernames/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsernameById(@PathVariable("id") int id, @RequestParam("username") String username){

       return "Username " + username;


    }*/

    @GetMapping(path = "/userbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizadorUsername(@PathVariable(value = "username") String username){

         logger.info("Sending user with username: " + username);

         Optional<Utilizador> _utilizadorr = utilizadorRepository.findByUsername(username);
         if(!_utilizadorr.isPresent()) throw
           new NotFoundException("" + username, "Utilizador", "username");
           else return _utilizadorr.get();

    } 

    @GetMapping(path = "/getpassword", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadorPasswordLike(){

        logger.info("Sending user with password like 'j'");
        return utilizadorRepository.findByPasswordLikeJ();

    }


    @PostMapping(path = "/createuser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador saveUtilizador(@RequestBody Utilizador utilizador){

        Utilizador savedUtilizador = utilizadorRepository.save(utilizador);
        logger.info("Saving user...");
        return savedUtilizador;

    }

}
