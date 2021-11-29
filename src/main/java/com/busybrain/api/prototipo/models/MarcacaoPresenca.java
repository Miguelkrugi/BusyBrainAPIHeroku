package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcacao_presenca")
public class MarcacaoPresenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "presenca_id") private int presencaid;
    @Column(name = "wasthere") private boolean presencastatus;
    @Column(name = "utilizador_id") private int userid;
    @Column(name = "local_id") private int placeid;

    public MarcacaoPresenca(){

    }

    public int getPlaceid() {
        return placeid;
    }

    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }

    public int getPresencaid() {
        return presencaid;
    }

    public void setPresencaid(int presencaid) {
        this.presencaid = presencaid;
    }

    public int getUserid() {
        return userid;
    }

    public void setPresencastatus(boolean presencastatus) {
        this.presencastatus = presencastatus;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean isPresencastatus() {
        return presencastatus;
    }

    
    
}
