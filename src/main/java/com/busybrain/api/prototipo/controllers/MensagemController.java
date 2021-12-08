package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.repositories.MensagemRepository;
import com.busybrain.api.prototipo.views.MensagemView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/messages")
public class MensagemController {

    private Logger logger = LoggerFactory.getLogger(MensagemController.class);

    @Autowired
    private MensagemRepository mensagemRepository;
    
    @GetMapping(path = "/{chat_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MensagemView> getFavoritePlaces(@PathVariable(value = "chat_id") int chatid){

        logger.info("Sending all favorite places from user with id: " + chatid);

        return mensagemRepository.findByChatid(chatid);

    }

}
