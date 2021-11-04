package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Utilizador;

import org.springframework.data.repository.CrudRepository;

public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer>{

    Iterable<Utilizador> findByUsername(String username);
    
}
