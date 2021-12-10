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

    @Column(name = "bloqueamento_id") private int bloqueamentoid;
    @Column(name = "utilizador_id") private int utilizadorid;
    @Column(name = "blocked_status") private boolean status;
    @Column(name = "website_id") private int id;
    @Column(name = "website_domain_id") private String domainid;

    public Website(){

    }

    public int getBloqueamentoid() {
        return bloqueamentoid;
    }

    public void setBloqueamentoid(int bloqueamentoid) {
        this.bloqueamentoid = bloqueamentoid;
    }

    public int getUtilizadorid() {
        return utilizadorid;
    }

    public void setUtilizadorid(int utilizadorid) {
        this.utilizadorid = utilizadorid;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
    }

}
