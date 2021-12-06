package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.MarcacaoFavorito;
import com.busybrain.api.prototipo.models.repositories.MarcacaoFavoritoRepository;
import com.busybrain.api.prototipo.views.MarcacaoFavoritoView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/favorite")
public class MarcacaoFavoritoController {
    
    //private Logger logger = LoggerFactory.getLogger(LocalController.class);

    private Logger logger = LoggerFactory.getLogger(MarcacaoFavoritoController.class);

    @Autowired
    private MarcacaoFavoritoRepository marcacaoFavoritoRepository;
   
    //Method to get favorite places from a user

    @GetMapping(path = "/favoriteplaces/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoFavorito> getFavoritePlaces(@PathVariable(value = "utilizador_id") int userid){

        logger.info("Sending all favorite places from user with id: " + userid);

        return marcacaoFavoritoRepository.findByUserid(userid);

    }

    //METHOD FOR TEST - GET ALL FAVORITE PLACES OF A USER

    @GetMapping(path = "/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoFavoritoView> getAllFavoritePlacesbyUtilizadorid(@PathVariable(value = "utilizador_id") int userid){

        logger.info("Sending all favorite places of a user");

       return marcacaoFavoritoRepository.findByFavoritestatus(userid);

    }

    //MARCAR LOCAIS FAVORITOS -- TERMINAR AMANHA (UPDATE A VALORES BOOLEANOSch10)
    
    
    @PutMapping(path = "/updateplace/{favorite_id}")
    public MarcacaoFavorito atualizarFavorito(@PathVariable(value = "favorite_id") int id, @RequestBody MarcacaoFavorito marcacaoFavorito){ //O request body recebe os dados de uma tarefa a atualizar

        MarcacaoFavorito marcacaofavAtual = marcacaoFavoritoRepository.findById(id).get();//Aceder o ID da marcacao a atualizar (marcacao ou nao marcacao de "favorito")

        logger.info("" + marcacaofavAtual);

        BeanUtils.copyProperties(marcacaofavAtual, marcacaoFavorito, "id"); //Quais sejam os dados atualizados, ele irá guardar esses novos dados (excepto o "ID", pois não pode ser alterado)
        return marcacaoFavoritoRepository.save(marcacaofavAtual); //Guardar uma nova tarefa com os novos dados requisitados pelo utilizador através do "input" tarefa (no @RequestBody)

    }

    
    //METHOD FOR TEST - GET ALL FAVORITE PLACES OF A USER  

    /*@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoFavoritoView> getAllFavoritePlaces(){

        logger.info("Sending all favorited places on the app database");

       return marcacaoFavoritoRepository.findByFavoritestatus();

    }*/

}
