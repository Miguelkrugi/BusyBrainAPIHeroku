package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.MarcacaoPresenca;
import com.busybrain.api.prototipo.views.MarcacaoPresencaView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MarcacaoPresencaRepository extends CrudRepository<MarcacaoPresenca, Integer>{

    public Iterable<MarcacaoPresenca> findByUserid(int userid);

    String queryByPresenca = "select marcacoesp.presenca_id AS preId, userss.user_name AS username, localss.place_name AS nome, marcacoesp.wasthere AS presenca " + 
    "from marcacao_presenca AS marcacoesp " +
    "inner join utilizador userss on userss.user_id = marcacoesp.utilizador_id " +
    "inner join place localss on marcacoesp.local_id = localss.place_id";

    String queryyyy = "select marcacoes.presenca_id AS presencaId, marcacoes.utilizador_id AS utilizadorId, locais.place_name AS placeName, locais.place_endereco AS placeEndereco, locais.place_id AS placeId " + 
    "from marcacao_presenca AS marcacoes " + 
    "inner join utilizador userss on marcacoes.utilizador_id = userss.user_id " + 
    "inner join place locais on marcacoes.local_id = locais.place_id " + 
    "where marcacoes.wasthere = '1' and ";

    @Query(value = queryyyy + "marcacoes.utilizador_id=:utilizadorid", nativeQuery = true)
    Iterable<MarcacaoPreView> findMarcacaoPresencaByUtilizadorId(@Param("utilizadorid") int utilizadorid);

    @Query(value = queryByPresenca + " where userss.user_id=:userid", nativeQuery = true)
    Iterable<MarcacaoPresencaView> findPresencasByUserid(@Param("userid") int userid);

    /*select marcarpresencas.presenca_id AS presencaId, users.user_name AS Username, locais.place_name AS Nameofplace
    from marcacao_presenca AS marcarpresencas
    inner join utilizador users on users.user_id = marcarpresencas.utilizador_id
    inner join place locais on marcarpresencas.local_id = locais.place_id
    where wasthere = '1' and users.user_id=:userid*/

    /*
    select marcarpresencas.presenca_id AS presencaId, users.user_name AS Username, locais.place_name AS Nameofplace, marcarpresencas.wasthere AS presencaStatus       
from marcacao_presenca AS marcarpresencas
inner join utilizador users on users.user_id = marcarpresencas.utilizador_id
inner join place locais on marcarpresencas.local_id = locais.place_id
--where-- wasthere = '1' 
where users.user_id=:userid
    
    
    */ 

}
