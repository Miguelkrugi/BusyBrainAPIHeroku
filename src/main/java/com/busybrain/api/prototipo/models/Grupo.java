package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "group_id") private int id;
    @Column(name = "group_name") private String name;
    @Column(name = "group_description") private String description;
    @Column(name = "tarefa_id") private int tarefaid;
    
    public Grupo(){

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTarefaid() {
        return tarefaid;
    }

    public void setTarefaid(int tarefaid) {
        this.tarefaid = tarefaid;
    }

    

}
