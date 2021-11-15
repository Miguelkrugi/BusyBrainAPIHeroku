package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "app")
public class App {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "app_id") private int id;
    @Column(name = "app_name") private String name;
    @Column(name = "app_status") private boolean status;

    public App(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
