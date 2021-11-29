package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.MarcacaoFavorito;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MarcacaoFavoritoRepository extends CrudRepository<MarcacaoFavorito, Integer>{
    
    public Iterable<MarcacaoFavorito> findByUserid(int userid);

    @Query(value = "select favorite_id, user_name, place_name from marcacao_favorito inner join utilizador on user_id = utilizador_id inner join place on local_id = place_id where isfavorite = '1'", nativeQuery = true)
    Iterable<MarcacaoFavorito> findByFavoritestatus();


   // select favorite_id, user_name, place_name 
//from marcacao_favorito
//inner join utilizador on user_id = utilizador_id
//inner join place on local_id = place_id
//where isfavorite = '1'
}
