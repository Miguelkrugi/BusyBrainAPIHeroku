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

    @Query(value = queryByFavorite, nativeQuery = true)
    Iterable<MarcacaoFavoritoView> findByFavoritestatus(@Param("user_id") int userid); 
    //Iterable<MarcacaoFavoritoView> findByFavoritestatus(int userid);


// select favorite_id, user_name, place_name 
//from marcacao_favorito
//inner join utilizador on user_id = utilizador_id
//inner join place on local_id = place_id
//where isfavorite = '1'
}
