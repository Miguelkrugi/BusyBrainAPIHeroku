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

    //Obter uma lista de todos os websites disponiveis para bloquear

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Website> findAllWebsites(){

        logger.info("Sending All Websites available to block...");

        return websiteRepository.findAll();
    }

    @GetMapping(path = "/getsites", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<WebsiteView> getWebsites(){

        logger.info("Getting all blocked websites...");

        return websiteRepository.findWebsites();

     }

     //OS MÉTODOS ABAIXO NÃO FUNCIONAM //////////////////////////////////////////////////////////////////////////

     @GetMapping(path = "/getsitesfrom/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<WebsiteView> getWebsitesByUserid(@PathVariable("utilizador_id") int utilizadorid){

        logger.info("Getting all websites status from user by id given...");

        return websiteRepository.findWebsitesByUserid(utilizadorid);

     }

     @PostMapping(path = "/createwebsite", produces = MediaType.APPLICATION_JSON_VALUE)
     public Website saveWebsite(@RequestBody Website website){

       Website savedWebsite = websiteRepository.save(website);

       logger.info("Inserting a website that was blocked....");

       return savedWebsite;

     }

    //Adicionar um website -> METODO DE TESTE

    /*@PostMapping(path = "/createwebsite", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
     public Website saveWebsite(@RequestBody Website website){

      Website savedWebsite = websiteRepository.save(website);
     logger.info("Saving website...");
     return savedWebsite;

     }*/

     ///////////////////////////////////////////////////////////////////////////////////////////////////////////

     @GetMapping(path = "/getwebsites/{utilizador_id}/blocked", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<Website> getBlockedWebsites(@PathVariable(value = "utilizador_id") int utilizadorid){

        logger.info("Getting all blocked websites...");

        return websiteRepository.findWebsiteByUtilizadorId(utilizadorid);

     }

     //Exibir as informações de um website selecionado | EXIBIR WEBSITES BLOQUEADOS

    @GetMapping(path = "/getwebsites/blocked", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<Website> getBlockedWebsites(){

        logger.info("Getting all blocked websites...");

        return websiteRepository.findWebsiteByStatus();

     }

     //EXIBIR WEBSITES DESBLOQUEADOS

     @GetMapping(path = "/getwebsites/unlocked", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<Website> getUnlockedWebsites(){

        logger.info("Getting all unlocked websites...");

        return websiteRepository.findByStatus();

     }

     ///////////////////////////////////////////////////////////////////////////////////////

     @GetMapping(path = "/getwebsitesss/{website_user_block}", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<WebsiteViiew> getUnlockedSitesByWebsiteUserBlock(@PathVariable(value = "website_user_block") int userid){

       logger.info("Getting all unlocked websites by user: " + userid);

       return websiteRepository.findWebsitesByStatus(userid);


     }


}
