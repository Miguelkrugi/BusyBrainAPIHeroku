package com.busybrain.api.prototipo.models;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "task_id") private int id;
    @Column(name = "task_title") private String title;
    @Column(name = "task_desc") private String description;
    @Column(name = "due_date") private String date;
    @Column(name = "user_task_id") private int usertaskid;
    @Column(name = "task_priority_id") private int priority;
    @Column(name = "task_type_id") private int type;
    
    //private ArrayList<Enrolment> enrolments;

    //@OneToMany
    //private ArrayList<Enrolment> enrolments = new ArrayList<>();

    public Tarefa(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUsertaskid() {
        return usertaskid;
    }

    public void setUsertaskid(int usertaskid) {
        this.usertaskid = usertaskid;
    }
    /*public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(ArrayList<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }*/

}
