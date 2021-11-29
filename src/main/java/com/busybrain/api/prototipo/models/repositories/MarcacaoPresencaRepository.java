package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.MarcacaoPresenca;
import com.busybrain.api.prototipo.views.MarcacaoPresencaView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MarcacaoPresencaRepository extends CrudRepository<MarcacaoPresenca, Integer>{

    public Iterable<MarcacaoPresenca> findByUserid(int userid);

    String queryByPresenca = "select marcarpresencas.presenca_id AS presencaId, users.user_name AS Username, locais.place_name AS Nameofplace " + 
    "from marcacao_presenca AS marcarpresencas " +
    "inner join utilizador users on users.user_id = marcarpresencas.utilizador_id " +
    "inner join place locais on marcarpresencas.local_id = locais.place_id" + 
    "where wasthere = '1' and users.user_id=:userid";

    @Query(value = queryByPresenca, nativeQuery = true)
    Iterable<MarcacaoPresencaView> findByPresencastatus(@Param("userid") int userid); 

    /*select marcarpresencas.presenca_id AS presencaId, users.user_name AS Username, locais.place_name AS Nameofplace
    from marcacao_presenca AS marcarpresencas
    inner join utilizador users on users.user_id = marcarpresencas.utilizador_id
    inner join place locais on marcarpresencas.local_id = locais.place_id
    where wasthere = '1' and users.user_id=:userid*/

}
