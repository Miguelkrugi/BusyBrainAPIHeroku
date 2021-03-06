package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.MarcacaoFavorito;
import com.busybrain.api.prototipo.models.repositories.MarcacaoFavView;
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

    @GetMapping(path = "/fav", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoFavView> getAllFavoritePlaces(){

        logger.info("Sending all favorite places of a user");

       return marcacaoFavoritoRepository.findByMarcacaoFavorito();

    }

    //OBTER LOCAIS FAVORITOS PELO UTILIZADOR

    @GetMapping(path = "/favs/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoFavView> getAllFavoritePlacesbyUtilizadorId(@PathVariable(value = "utilizador_id") int utilizadorid){

        logger.info("Sending all favorite places of a user with id: " + utilizadorid);

       return marcacaoFavoritoRepository.findMarcacaoFavoritoByUtilizadorId(utilizadorid);

    }

    //CRIA????O DA PRIMEIRA MARCA????O

    @PostMapping(path = "/createmarcacao", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
    public MarcacaoFavorito saveMarcacaoFavorito(@RequestBody MarcacaoFavorito marcacaoFavorito){

     MarcacaoFavorito savedMarcacaoFavorito = marcacaoFavoritoRepository.save(marcacaoFavorito);
     logger.info("Saving marca????o...");
     return savedMarcacaoFavorito;

    }
    

    //MARCAR LOCAIS FAVORITOS -- TERMINAR AMANHA (UPDATE A VALORES BOOLEANOSch10)
    

   /* @PutMapping(path = "/updateplace/{favorite_id}")
    public MarcacaoFavorito atualizarFavorito(@PathVariable(value = "favorite_id") int id, @RequestBody MarcacaoFavorito marcacaoFavorito){ //O request body recebe os dados de uma tarefa a atualizar

        MarcacaoFavorito marcacaofavAtual = marcacaoFavoritoRepository.findById(id).get();//Aceder o ID da marcacao a atualizar (marcacao ou nao marcacao de "favorito")

        logger.info("" + marcacaofavAtual);

        BeanUtils.copyProperties(marcacaoFavorito, marcacaofavAtual, "id");
        //BeanUtils.copyProperties(marcacaofavAtual, marcacaoFavorito, "id"); | //Quais sejam os dados atualizados, ele ir?? guardar esses novos dados (excepto o "ID", pois n??o pode ser alterado)
        return marcacaoFavoritoRepository.save(marcacaofavAtual); //Guardar uma nova tarefa com os novos dados requisitados pelo utilizador atrav??s do "input" tarefa (no @RequestBody)

    }*/

    //TODO PODER?? SER DEVIDO AO PUT OCORRER NUMA VIEW??? || ATENCAO!!

    /*@PutMapping(path = "/update/{favorite_id}")
    public MarcacaoFavoritoView atualizarFav(@PathVariable(value = "favorite_id") int id, @RequestBody MarcacaoFavorito marcarFavorito){

        MarcacaoFavoritoView marcarFavoritoAtual = marcacaoFavoritoRepository.findById(id).get();

        BeanUtils.copyProperties(marcarFavorito, marcarFavoritoAtual, "id");
        return marcacaoFavoritoRepository.save(marcarFavoritoAtual);

    }*/

    //---------------------------------------------------------------------------------------------------
    
    //METHOD FOR TEST - GET ALL FAVORITE PLACES OF A USER  

    /*@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoFavoritoView> getAllFavoritePlaces(){

        logger.info("Sending all favorited places on the app database");

       return marcacaoFavoritoRepository.findByFavoritestatus();

    }*/

}
