package com.busybrain.api.prototipo.models.repositories;

import java.util.Optional;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.Utilizador;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer>{

    Optional<Utilizador> findByUsername(String username);
    
    @Query
    Iterable<Tarefa> findTaskbyUser(int id);

}
