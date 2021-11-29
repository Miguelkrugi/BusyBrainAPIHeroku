package com.busybrain.api.prototipo.models.repositories;


import java.util.Optional;

import com.busybrain.api.prototipo.models.Local;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LocalRepository extends CrudRepository<Local, Integer>{
 
    public Iterable<Local> findByNameContaining(String name);

    public Iterable<Local> findLocalByCategoria(int categoria);

    

    //@Query(value = "SELECT * FROM place WHERE place_categoria = '1'", nativeQuery = true)
    //Iterable<Local> findLocalByCategoria();

    @Query(value = "SELECT * FROM place WHERE place_categoria = '2'", nativeQuery = true)
    Iterable<Local> findByCategoria();

    @Query(value = "SELECT * FROM place WHERE place_categoria = '3'", nativeQuery = true)
    Iterable<Local> findPlaceByCategoria();

    @Query(value = "SELECT * FROM place WHERE place_categoria = '4'", nativeQuery = true)
    Iterable<Local> findPlaceeByCategoria();

    @Query(value = "SELECT * FROM place ORDER BY place_distancia ASC", nativeQuery = true)
    Iterable<Local> findLocalByDistancia();

}
