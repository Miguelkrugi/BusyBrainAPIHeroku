package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.MarcacaoFavorito;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MarcacaoFavoritoRepository extends CrudRepository<MarcacaoFavorito, Integer>{
    
    public Iterable<MarcacaoFavorito> findByUserid(int userid);

    @Query(value = "select * from marcacao_favorito where isfavorite = '1'", nativeQuery = true)
    Iterable<MarcacaoFavorito> findByFavoritestatus();

}
