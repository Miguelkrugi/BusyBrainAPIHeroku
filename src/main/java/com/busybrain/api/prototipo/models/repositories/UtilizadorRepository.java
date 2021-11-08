package com.busybrain.api.prototipo.models.repositories;

import java.util.Optional;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.Utilizador;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer>{

    Optional<Utilizador> findByUsername(String username);
    
    //@Query
    //Iterable<Tarefa> findTaskbyUser(int id);

    @Query(value = "select user_password from utilizador" +  " WHERE user_password LIKE 'j%'", nativeQuery = true)
    Iterable<Utilizador> findByPasswordLikeJ();


}
