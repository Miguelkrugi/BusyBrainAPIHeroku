package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.MarcacaoPresenca;
import com.busybrain.api.prototipo.models.repositories.MarcacaoPresencaRepository;
import com.busybrain.api.prototipo.views.MarcacaoPresencaView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/presenca")
public class MarcacaoPresencaController {

    //private Logger logger = LoggerFactory.getLogger(MarcacaoFavoritoController.class);

    private Logger logger = LoggerFactory.getLogger(MarcacaoPresencaController.class);
    
    @Autowired
    private MarcacaoPresencaRepository marcacaoPresencaRepository;

    //Method to get favorite places from a user

    @GetMapping(path = "/presenceplaces/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoPresenca> getFavoritePlaces(@PathVariable(value = "utilizador_id") int userid){

        logger.info("Sending all favorite places from user with id: " + userid);

        return marcacaoPresencaRepository.findByUserid(userid);

    }

    //METHOD FOR TEST - GET ALL MARKED PLACES OF A USER

    @GetMapping(path = "/presencedplace/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoPresencaView> getAllPresencaPlacesbyUtilizadorid(@PathVariable(value = "utilizador_id") int userid){

        logger.info("Sending all marked places of a user");

       return marcacaoPresencaRepository.findPresencaByUserid(userid);

    }
    
}
