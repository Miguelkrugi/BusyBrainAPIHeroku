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










    String queryByFavoritePlaces = "select favoritos.favorite_id AS favoriteId, userss.user_id AS userId, locais.place_name AS placeName, locais.place_endereco AS placeEndereco, locais.place_id AS placeId " + 
    "from marcacao_favorito AS favoritos " + 
    "inner join utilizador userss on favoritos.utilizador_id = userss.user_id " + 
    "inner join place locais on locais.place_id = favoritos.local_id " + 
    "where favoritos.isfavorite = '1' and ";

    @Query(value = queryByFavoritePlaces + "userss.user_id=:userid", nativeQuery = true)
    Iterable<MarcacaoFavoritoView> findMarcacaoFavoritoByUserId(@Param("utilizador_id") int userid); 



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
