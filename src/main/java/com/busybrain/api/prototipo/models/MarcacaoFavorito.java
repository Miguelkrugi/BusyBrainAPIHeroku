package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcacao_favorito")
public class MarcacaoFavorito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "favorite_id") private int favoriteid;
    @Column(name = "isfavorite") private boolean favoritestatus;
    @Column(name = "utilizador_id") private int userid;
    @Column(name = "local_id") private int placeid;

    public MarcacaoFavorito(){

    }

    public int getFavoriteid() {
        return favoriteid;
    }

    public void setFavoriteid(int favoriteid) {
        this.favoriteid = favoriteid;
    }

    public boolean isFavoritestatus() {
        return favoritestatus;
    }

    public void setFavoritestatus(boolean favoritestatus) {
        this.favoritestatus = favoritestatus;
    }

    public int getPlaceid() {
        return placeid;
    }

    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
