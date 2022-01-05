package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Convivio;
import com.busybrain.api.prototipo.views.ConvivioView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConvivioRepository extends CrudRepository<Convivio, Integer>{

    String queryByGrupo = "select convivios.convivio_id AS convivioId, groupss.group_name AS groupName, placess.place_name AS placeName, placess.place_endereco AS placeEndereco ,convivios.data_convivio AS convivioData " +
    "from convivio AS convivios " +
    "inner join grupo AS groupss on groupss.group_id = convivios.grupo_id " +
    "inner join place AS placess on placess.place_id = convivios.placee_id ";

    

    @Query(value = queryByGrupo + "where groupss.group_id=:grupoid", nativeQuery = true)
    Iterable<ConvivioView> findConvivioByGroupId(@Param("grupoid") int grupoid);

}
