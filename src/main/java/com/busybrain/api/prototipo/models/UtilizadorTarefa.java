package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilizador_tarefa")
public class UtilizadorTarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id_tarefa") private int id;
    @Column(name = "user_identifier") private int userid;
    @Column(name = "task_identifier") private int taskid;

    public UtilizadorTarefa(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

}
