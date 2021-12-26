package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.MarcacaoPresenca;
import com.busybrain.api.prototipo.models.repositories.MarcacaoPreView;
import com.busybrain.api.prototipo.models.repositories.MarcacaoPresencaRepository;
import com.busybrain.api.prototipo.views.MarcacaoPresencaView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Iterable<MarcacaoPresencaView> getPresencaPlaces(@PathVariable(value = "utilizador_id") int userid){

        logger.info("Sending all favorite places from user with id: " + userid);

        return marcacaoPresencaRepository.findPresencasByUserid(userid);

    }


    @GetMapping(path = "/presencas/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MarcacaoPreView> getAllFavoritePlacesbyUtilizadorId(@PathVariable(value = "utilizador_id") int utilizadorid){

        logger.info("Sending all presenced places of a user with id: ");

       return marcacaoPresencaRepository.findMarcacaoPresencaByUtilizadorId(utilizadorid);

    }

    @PutMapping(path = "/updateplace/{presenca_id}")
    public MarcacaoPresenca atualizarPresenca(@PathVariable(value = "presenca_id") int preid, @RequestBody MarcacaoPresenca marcacaoPresenca){ //O request body recebe os dados de uma tarefa a atualizar

        MarcacaoPresenca marcacaopreAtual = marcacaoPresencaRepository.findById(preid).get(); //Aceder o ID da marcacao a atualizar (marcacao ou nao marcacao de "favorito")

        BeanUtils.copyProperties(marcacaoPresenca, marcacaopreAtual, "id"); //Quais sejam os dados atualizados, ele irá guardar esses novos dados (excepto o "ID", pois não pode ser alterado)
        return marcacaoPresencaRepository.save(marcacaopreAtual); //Guardar uma nova tarefa com os novos dados requisitados pelo utilizador através do "input" tarefa (no @RequestBody)

    }
    
}
