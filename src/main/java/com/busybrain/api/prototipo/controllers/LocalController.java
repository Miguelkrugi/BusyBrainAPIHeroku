package com.busybrain.api.prototipo.controllers;

import java.util.Optional;

import com.busybrain.api.prototipo.models.Local;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException3;
import com.busybrain.api.prototipo.models.repositories.LocalRepository;

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
@RequestMapping(path = "/api/locals")
public class LocalController {
    
    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private LocalRepository localRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Local> findAllLocals(){

        logger.info("Sending All Locals");

        return localRepository.findAll();
    }

    //TODO --> ADICIONAR MÉTODO PARA OBTER AS INFORMACOES DE UM LOCAL COM BASE NA SELECAO POR ID

   @GetMapping(path = "/getinfo/{place_id}")
   public Local localById(@PathVariable(value = "place_id") int id){

       logger.info("Sending info from local with id: " + id);

       Optional<Local> _local = localRepository.findById(id);

       if(!_local.isPresent()) throw 
         new NotFoundException3("" + id, "Local", "ID");
         else return _local.get();
       
   }

    @GetMapping(path = "/searchbyname/{place_name}")
    public Iterable<Local> localByName(@PathVariable(value = "place_name") String name){

        logger.info("Sending Local with: "+ name + "included.");


        return localRepository.findByNameContaining(name);
    }
    
    @GetMapping(path = "/searchbycategory/bar")
    public Iterable<Local> localByBar(){

        logger.info("Sending places with 'Bar' category...");

        return localRepository.findByCategoria();

    }

    @GetMapping(path = "/searchbycategory/livraria")
    public Iterable<Local> localByBiblioteca(){

        logger.info("Sending places with 'Livraria' category...");

        return localRepository.findPlaceeByCategoria();

    }

    @GetMapping(path = "/searchbycategory/cafes")
    public Iterable<Local> localByCafes(){

        logger.info("Sending places with 'Coffee' category...");

        return localRepository.findLocalByCategoria();

    }

    @GetMapping(path = "/searchbycategory/restaurant")
    public Iterable<Local> localByCategory(){

        logger.info("Sending places with 'Restaurant' category...");

        return localRepository.findPlaceByCategoria();

    }

    @GetMapping(path = "/closestplaces")
    public Iterable<Local> getclosestPlaces(){

         logger.info("Sending closest places by distance: ");

         return localRepository.findLocalByDistancia();

    }

//MÉTODO DE SUPORTE PARA TESTE

@PostMapping(path = "/createplace", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
public Local savePlace(@RequestBody Local local){

   Local savedPlace = localRepository.save(local);
   logger.info("Saving place...");
   return savedPlace;

}

}
