package com.busybrain.api.prototipo.models.repositories;

import java.util.Optional;

import com.busybrain.api.prototipo.models.App;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends CrudRepository<App, Integer>{
    
   Iterable<App> findAppByNameContaining(String name);
   
   Iterable<App> findAppByStatus(boolean status);

   @Query(value = "SELECT * FROM app WHERE blocked_status = '1'", nativeQuery = true)
    Iterable<App> findAppByStatus();

    @Query(value = "SELECT * FROM app WHERE blocked_status = '0'", nativeQuery = true)
    Iterable<App> findAppBystatus();

}
