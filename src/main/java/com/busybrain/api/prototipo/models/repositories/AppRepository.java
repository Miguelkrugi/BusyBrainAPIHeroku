package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.App;

import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends CrudRepository<App, Integer>{
    
   Iterable<App> findAppByNameContaining(String name); 

}
