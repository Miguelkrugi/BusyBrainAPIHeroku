package com.busybrain.api.prototipo.controllers;

import javax.print.attribute.standard.Media;

import com.busybrain.api.prototipo.models.Website;
import com.busybrain.api.prototipo.models.repositories.WebsiteRepository;
import com.busybrain.api.prototipo.views.WebsiteView;
import com.busybrain.api.prototipo.views.WebsiteViiew;
import com.fasterxml.jackson.databind.type.MapType;

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
@RequestMapping(path = "/api/websites")
public class WebsiteController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private WebsiteRepository websiteRepository;

    //OBTER O HISTORICO DE BLOQUEIO E DESBLOQUEIO DE WEBSITES NO GERAL (BASE DE DADOS)

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Website> findAllWebsites(){

        logger.info("Sending All Websites available to block...");

        return websiteRepository.findAll();
    }

    
    //Adicionar um website -> METODO DE TESTE
/*
    @PostMapping(path = "/createwebsite", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
     public Website saveWebsite(@RequestBody Website website){

      Website savedWebsite = websiteRepository.save(website);
     logger.info("Saving website...");
     return savedWebsite;

     }*/

    //ESTE POST SÓ OCORRE QUANDO UM SITE É BLOQUEADO (INCOMPLETO DEVIDO AO POST DO VALOR BOOLEANO) | A PARTIR DAÍ, QUALQUER ALTERAÇÃO FEITA A ESSE DOMINIO, É REALIZADA ATRAVÉS DE UPDATES POR BOOLEAN.

     @PostMapping(path = "/createsite", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
     public Website saveWebsite(@RequestBody Website website){
 
        Website savedWebsite = websiteRepository.save(website);
        logger.info("Saving website...");
        return savedWebsite;
 
     }

     ///////////////////////////////////////////////////////////////////////////////////////////////////////////

     @GetMapping(path = "/getwebsites/{utilizador_id}/blocked", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<Website> getBlockedWebsites(@PathVariable(value = "utilizador_id") int utilizadorid){

        logger.info("Getting all blocked websites...");

        return websiteRepository.findWebsiteByUtilizadorId(utilizadorid);

     }


     ///////////////////////////////////MÉTODO FUNCIONAL - OBTER OS WEBSITES BLOQUEADOS///////////////////////////////////////////////////////////////

     @GetMapping(path = "/getlockedwebsitesss/{website_user_block}", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<WebsiteViiew> getLockedSitesByWebsiteUserBlock(@PathVariable(value = "website_user_block") int userid){

       logger.info("Getting all locked websites by user: " + userid);

       return websiteRepository.findWebsitesByStatus(userid);


     }

     //OBTER OS WEBSITES DESBLOQUEADOS (PARA APRESENTAR NA LISTVIEW EM ANDROID)

     @GetMapping(path = "/getunlockedwebsitesss/{website_user_block}", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<WebsiteViiew> getUnlockedSitesByWebsiteUserBlock(@PathVariable(value = "website_user_block") int userid){

      logger.info("Getting all unlocked websites by user: " + userid);

      return websiteRepository.findWebsitesByBlockedStatus(userid);

     }


}
