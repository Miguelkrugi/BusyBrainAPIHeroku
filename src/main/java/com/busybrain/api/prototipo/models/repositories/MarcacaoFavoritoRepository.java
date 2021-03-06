package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.MarcacaoFavorito;
import com.busybrain.api.prototipo.views.MarcacaoFavoritoView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MarcacaoFavoritoRepository extends CrudRepository<MarcacaoFavorito, Integer>{
    
   // public Iterable<MarcacaoFavorito> findByUserid(int userid);

    String queryByFavorite = "select marcacoes.favorite_id AS favId, users.user_name AS Username, locals.place_name AS Nameofplace " +
    "from marcacao_favorito AS marcacoes " + "inner join utilizador users on users.user_id = marcacoes.utilizador_id " +
    "inner join place locals on marcacoes.local_id = locals.place_id " +
    "where isfavorite = '0' and users.user_id=:userid";

    String queryByFavoriteStatus = "select marcacoes.favorite_id AS favId, users.user_name AS Username, locals.place_name AS Nameofplace, marcacoes.isfavorite AS Status " +
    "from marcacao_favorito AS marcacoes " + "inner join utilizador users on users.user_id = marcacoes.utilizador_id " +
    "inner join place locals on marcacoes.local_id = locals.place_id ";

    @Query(value = queryByFavoriteStatus + "where users.user_id=:userid", nativeQuery = true)
    Iterable<MarcacaoFavoritoView> findByFavoritestatus(@Param("userid") int userid); 
    //Iterable<MarcacaoFavoritoView> findByFavoritestatus(int userid);


    String q = "select marcacoes.favorite_id AS favoriteId, marcacoes.utilizador_id AS utilizadorId, locais.place_name AS placeName, locais.place_endereco AS placeEndereco, locais.place_id AS placeId " + 
    "from marcacao_favorito AS marcacoes " +  
    "inner join utilizador userss on marcacoes.utilizador_id  = userss.user_id " + 
    "inner join place locais on marcacoes.local_id = locais.place_id " + 
    "where marcacoes.isfavorite = '1' ";

    @Query(value = q, nativeQuery = true)
    Iterable<MarcacaoFavView> findByMarcacaoFavorito();
    
    //////////////////////////////////////////////////////////

    @Query(value = q + "and marcacoes.utilizador_id=:utilizadorid", nativeQuery = true)
    Iterable<MarcacaoFavView> findMarcacaoFavoritoByUtilizadorId(@Param("utilizadorid") int utilizadorid);

    /////////////////////////////////////////////////////QUERIES DE REMO????O DE FAVORITOS OU REMARCA????O DE FAVORITOS ///////////////////////////////////////////////

   //REMARCA????O DE LOCAIS FAVORITOS 

   // update marcacao_favorito set isfavorite = '1' where marcacoes.utilizador_id=:utilizadorid and marcacoes.local_id=:placeid (PUT MAPPING)

   //REMO????O DE LOCAIS FAVORITOS

   // update marcacao_favorito set isfavorite = '0' where marcacoes.utilizador_id=:utilizadorid and marcacoes.local_id=:placeid (PUT MAPPING)

}
