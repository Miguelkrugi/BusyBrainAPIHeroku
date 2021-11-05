package com.busybrain.api.prototipo.models.repositories;

import java.util.Optional;

import com.busybrain.api.prototipo.models.Utilizador;

import org.springframework.data.repository.CrudRepository;

public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer>{

    Optional<Utilizador> findByUsername(String username);
    
}
