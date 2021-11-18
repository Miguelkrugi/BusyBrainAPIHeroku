package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "website")
public class Website {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "website_id") private int id;
    @Column(name = "website_domain") private String domain;
    @Column(name = "website_status") private boolean status;

    public Website(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public String getDomain() {
        return domain;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
