package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.MarcacaoFavorito;
import com.busybrain.api.prototipo.models.repositories.MarcacaoFavoritoRepository;
import com.busybrain.api.prototipo.views.MarcacaoFavoritoView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //METHOD FOR TEST - GET ALL FAVORITE PLACES ON THE APP

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoFavoritoView> getAllFavoritePlaces(){

        logger.info("Sending all favorited places on the app database");

       return marcacaoFavoritoRepository.findByFavoritestatus();

    }

}
