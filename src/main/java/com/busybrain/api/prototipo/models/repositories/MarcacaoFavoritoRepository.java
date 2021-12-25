package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.MarcacaoFavorito;
import com.busybrain.api.prototipo.views.MarcacaoFavoritoView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MarcacaoFavoritoRepository extends CrudRepository<MarcacaoFavorito, Integer>{
    
    public Iterable<MarcacaoFavorito> findByUserid(int userid);

    String queryByFavorite = "select marcacoes.favorite_id AS favId, users.user_name AS Username, locals.place_name AS Nameofplace " +
    "from marcacao_favorito AS marcacoes " + "inner join utilizador users on users.user_id = marcacoes.utilizador_id " +
    "inner join place locals on marcacoes.local_id = locals.place_id " +
    "where isfavorite = '0' and users.user_id=:userid";

    String queryByFavoriteStatus = "select marcacoes.favorite_id AS favId, users.user_name AS Username, locals.place_name AS Nameofplace, marcacoes.isfavorite AS Status " +
    "from marcacao_favorito AS marcacoes " + "inner join utilizador users on users.user_id = marcacoes.utilizador_id " +
    "inner join place locals on marcacoes.local_id = locals.place_id ";


/*
    String queryTestTaskRecyclerView = "select tarefas.task_title AS taskTitle, tarefas.task_desc AS taskDesc, priority.taskpriority_type AS prioridade, tarefas.task_id AS taskId, tarefas.user_task_id AS usertaskId " +
    "from tarefa AS tarefas " +
    "inner join prioridadetarefa priority on priority.taskpriority_id = tarefas.task_priority_id " + 
    "inner join tipotarefa tipo on tarefas.task_type_id = tipo.tasktype_id " +
    "inner join utilizador users on tarefas.user_task_id = users.user_id ";

*/

//GET MAPPING E CUSTOM QUERY DE TAREFAS PELO ID DO USER

/*
@GetMapping(path = "/gettarefas/{user_task_id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Iterable<TarefaView> getAllTarefasByUsertaskid(@PathVariable(value = "user_task_id") int usertaskid){

    logger.info("Sending all tasks of the user: " + usertaskid);
    return tarefaRepository.findAllTarefaByUserid(usertaskid);

} 
*/
/*
@Query(value = queryTestTaskRecyclerView + "where tarefas.user_task_id=:usertaskid", nativeQuery = true)
Iterable<TarefaView> findAllTarefaByUserid(@Param("usertaskid") int usertaskid);

@GetMapping(path = "/favoriteplaces/{utilizador_id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Iterable<MarcacaoFavoritoView> getFavoritePlaces(@PathVariable(value = "utilizador_id") int userid){

    logger.info("Sending all favorite places from user with id: " + userid);

    return marcacaoFavoritoRepository.findMarcacaoFavoritoByUserId(userid);

}
*/


    String queryByFavoritePlaces = "select favoritos.favorite_id AS favoriteId, favoritos.utilizador_id AS userId, locais.place_name AS placeName, locais.place_endereco AS placeEndereco, locais.place_id AS placeId " + 
    "from marcacao_favorito AS favoritos " + 
    "inner join utilizador userss on favoritos.utilizador_id = userss.user_id " + 
    "inner join place locais on favoritos.local_id = locais.place_id " + 
    "where favoritos.isfavorite = '1' and ";

    @Query(value = queryByFavoritePlaces + "favoritos.utilizador_id=:userid", nativeQuery = true)
    Iterable<MarcacaoFavoritoView> findMarcacaoFavoritoByUserId(@Param("user_id") int userid); 



    /*
    @Query(value = queryByFavoriteStatus + "where users.user_id=:userid", nativeQuery = true)
    Iterable<MarcacaoFavoritoView> findByFavoritestatus(@Param("userid") int userid); 
    //Iterable<MarcacaoFavoritoView> findByFavoritestatus(int userid);
    */


// select favorite_id, user_name, place_name 
//from marcacao_favorito
//inner join utilizador on user_id = utilizador_id
//inner join place on local_id = place_id
//where isfavorite = '1' and users.user_id=:userid
}
