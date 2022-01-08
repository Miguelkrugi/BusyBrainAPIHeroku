package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarefa_grupo")
public class TarefaGrupo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "task_id") private int id;
    @Column(name = "task_title") private String title; //DEFINIDO PELO UTILIZADOR
    @Column(name = "task_desc") private String description; //DEFINIDO PELO UTILIZADOR
    @Column(name = "due_date") private String date; //DEFINIDO PELO UTILIZADOR
    @Column(name = "user_task_id") private int usertaskid; //ID DO UTILIZADOR (NÃO DEFINIDO PELO UTILIZADOR)
    @Column(name = "task_priority_id") private int priority; //DEFINIDO PELO UTILIZADOR
    @Column(name = "task_type_id") private int type; //NÃO DEFINIDO PELO UTILIZADOR (É OBRIGATORIAMENTE EM GRUPO)
    //@Column(name = "task_status") private boolean status;
    @Column(name = "task_group_id") private int taskgroupid; //NÃO DEFINIDO PELO UTILIZADOR (ID DO GRUPO)

    public TarefaGrupo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUsertaskid() {
        return usertaskid;
    }

    public void setUsertaskid(int usertaskid) {
        this.usertaskid = usertaskid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

   /* public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }*/
    

    public int getTaskgroupid() {
        return taskgroupid;
    }

    public void setTaskgroupid(int taskgroupid) {
        this.taskgroupid = taskgroupid;
    }

}
