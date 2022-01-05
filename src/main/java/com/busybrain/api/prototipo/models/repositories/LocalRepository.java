package com.busybrain.api.prototipo.models.repositories;


import java.util.Optional;

import com.busybrain.api.prototipo.models.Local;
import com.busybrain.api.prototipo.views.LocalUtilizadorView;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LocalRepository extends CrudRepository<Local, Integer>{
 
    String queryByLocalInfo = "select locais.place_id AS placeId, locais.place_name AS placeName, locais.place_endereco AS placeEndereco, locais.place_latitude AS placeLatitude, locais.place_longitude AS placeLongitude, locais.place_favorite AS placeFavorite, locais.place_presenca AS placePresenca, userss.user_id AS userId " + 
    "from place AS locais " +  
   "inner join utilizador userss on userss.user_id = locais.user_request_id";

   @Query(value = queryByLocalInfo + " where userss.user_id=:userid and locais.place_id=:placeid", nativeQuery = true)
   Iterable<LocalUtilizadorView> findLocalUtilizadorByUserIdAndPlaceId(@Param("userid") int userid, @Param("placeid") int placeid);

    public Iterable<Local> findByNameContaining(String name);



    //public Iterable<Local> findLocalByCategoria(String categoria);

    ////////////////////////////////////QUERY TO MODIFY////////////////////////////////////////////
/*
    @Modifying
    @Query(value = "update")
*/

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    

    //@Query(value = "SELECT * FROM place WHERE place_categoria = '1'", nativeQuery = true)
    //Iterable<Local> findLocalByCategoria();
/*
    @Query(value = "SELECT * FROM place WHERE place_categoria = '2'", nativeQuery = true)
    Iterable<Local> findByCategoria();

    @Query(value = "SELECT * FROM place WHERE place_categoria = '3'", nativeQuery = true)
    Iterable<Local> findPlaceByCategoria();

    @Query(value = "SELECT * FROM place WHERE place_categoria = '4'", nativeQuery = true)
    Iterable<Local> findPlaceeByCategoria();

    @Query(value = "SELECT * FROM place ORDER BY place_distancia ASC", nativeQuery = true)
    Iterable<Local> findLocalByDistancia();*/

}
