package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Local;

import org.springframework.data.repository.CrudRepository;

public interface LocalRepository extends CrudRepository<Local, Integer>{
 
    public Iterable<Local> findByNameContaining(String name);

}
