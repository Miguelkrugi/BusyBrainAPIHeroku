package com.busybrain.api.prototipo.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "convivio")
public class Convivio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "data_convivio") private Date date;
    @Column(name = "convivio_id") private int id;
    @Column(name = "grupo_id") private int grupoid;
    @Column(name = "placee_id") private int placeid;

    public Convivio(){

    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public int getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(int grupoid) {
        this.grupoid = grupoid;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getPlaceid() {
        return placeid;
    }

    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }

}
