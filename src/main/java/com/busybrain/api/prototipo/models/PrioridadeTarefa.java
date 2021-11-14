package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "prioridadetarefa")
public class PrioridadeTarefa {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "taskpriority_id") private int taskpriorityid;
    @Column(name = "taskpriority_nome") private String taskprioritynome;

    public PrioridadeTarefa(){

    }

    public int getTaskpriorityid() {
        return taskpriorityid;
    }

    public void setTaskpriorityid(int taskpriorityid) {
        this.taskpriorityid = taskpriorityid;
    }

    public String getTaskprioritynome() {
        return taskprioritynome;
    }

    public void setTaskprioritynome(String taskprioritynome) {
        this.taskprioritynome = taskprioritynome;
    }

}
