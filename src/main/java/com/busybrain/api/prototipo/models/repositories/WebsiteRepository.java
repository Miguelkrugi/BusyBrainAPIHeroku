package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Website;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WebsiteRepository extends CrudRepository<Website, Integer>{
    
    @Query(value = "SELECT * FROM website WHERE blocked_status = '1'", nativeQuery = true)
    Iterable<Website> findWebsiteByStatus();

    @Query(value = "SELECT * FROM website WHERE blocked_status = '0'", nativeQuery = true)
    Iterable<Website> findByStatus();

}
