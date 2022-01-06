package com.busybrain.api.prototipo.controllers;

import java.util.Optional;

import com.busybrain.api.prototipo.models.Local;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException3;
import com.busybrain.api.prototipo.models.repositories.LocalRepository;
import com.busybrain.api.prototipo.views.LocalUtilizadorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //MÉTODOS ELIMINADO//

    @GetMapping(path = "/getplace/{user_id}/{place_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LocalUtilizadorView> getPlaceSelected(@PathVariable(value = "user_id") int userid, @PathVariable(value = "place_id") int placeid){

         logger.info("Sending place with id: " + placeid + " that was selected by the user: " + userid);

         return localRepository.findLocalUtilizadorByUserIdAndPlaceId(userid, placeid);

    }

    

    //FAZER 2 UPDATES (1 UPDATE PARA FAVORITOS E OUTRO UPDATE PARA PRESENCAS)

    @PutMapping(path = "/updateplace")
    public @ResponseBody String  updateLocal(@RequestBody Local local){

         localRepository.save(local);

         return "";


    }
    ////////////////////////////////////////////////////////////////////


    //OBTER TODOS OS LOCAIS COM PRESENCAS MARCADAS DE UM UTILIZADOR (MARCACAO_PRESENCA)


    /*/OBTER INFORMACOES PARA PASSAR ID DO UTILIZADOR E ID DO LOCAL SELECIONADO

    @GetMapping(path = "/getplace/{user_id}/{place_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LocalUtilizadorView> getPlaceSelected(@PathVariable(value = "user_id") int userid, @PathVariable(value = "place_id") int placeid){

         logger.info("Sending place with id: " + placeid + " that was selected by the user: " + userid);

         return localRepository.findLocalUtilizadorByUserId(userid, placeid);

    }
    */
    

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
    
    /*@GetMapping(path = "/searchbycategory/bar")
    public Iterable<Local> localByBar(){

        logger.info("Sending places with 'Bar' category...");

        return localRepository.findByCategoria();

    }*/

    /*/TODO METODO COMENTADO TEMPORIARIAMENTE |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    @GetMapping(path = "/searchbycategory/{place_categoria}")
    public Iterable<Local> localByBiblioteca(@PathVariable(value ="place_categoria") String categoria){

        logger.info("Sending places with category with id..." + categoria);

        return localRepository.findLocalByCategoria(categoria);

    }

    */

   /* @GetMapping(path = "/searchbycategory/cafes")
    public Iterable<Local> localByCafes(){

        logger.info("Sending places with 'Coffee' category...");

        return localRepository.findLocalByCategoria();

    }*/

    /*@GetMapping(path = "/searchbycategory/restaurant")
    public Iterable<Local> localByCategory(){

        logger.info("Sending places with 'Restaurant' category...");

        return localRepository.findPlaceByCategoria();

    }*/


    /*///////////////////////////////MÉTODO COMENTADO TEMPORARIAMENTE//////////////////////////////////

    @GetMapping(path = "/closestplaces")
    public Iterable<Local> getclosestPlaces(){

         logger.info("Sending closest places by distance: ");

         return localRepository.findLocalByDistancia();

    } */

//MÉTODO QUE SERVIRÁ PARA FAZER O POST DAS INFORMACOES DO PLACES API PARA A REST API

@PostMapping(path = "/createplace", produces = MediaType.APPLICATION_JSON_VALUE)  //COMPLETO
public Local savePlace(@RequestBody Local local){

   Local savedPlace = localRepository.save(local);
   logger.info("Saving place...");
   return savedPlace;

}

//-----------------------------------------------------------------------

@PutMapping(path = "/updateplace/{place_id}")
public Local atualizarLocal(@PathVariable(value = "place_id") int id, @RequestBody Local local){

   Local localAtual = localRepository.findById(id).get();

   BeanUtils.copyProperties(local, localAtual, "id");
   return localRepository.save(localAtual);

}

}
