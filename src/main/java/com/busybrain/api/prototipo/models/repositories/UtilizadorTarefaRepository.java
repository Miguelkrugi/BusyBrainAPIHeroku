package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.UtilizadorTarefa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilizadorTarefaRepository extends CrudRepository<UtilizadorTarefa, Integer>{
    
    @Query(value = "SELECT * FROM utilizador_tarefa", nativeQuery = true)
    Iterable<UtilizadorTarefa> findAllUtilizadorTarefa();

}
