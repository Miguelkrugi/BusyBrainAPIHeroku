package com.busybrain.api.prototipo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name = "tarefa")
public class Tarefa {
    
    @Column(name = "task_id") private int id;
    @Column(name = "task_title") private String title;
    @Column(name = "task_desc") private String description;
    @Column(name = "due_date") private Date date;
    @Column(name = "task_priority_id") private int priorityid;
    @Column(name = "task_type_id") private int typeid;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPriorityid() {
        return priorityid;
    }

    public void setPriorityid(int priorityid) {
        this.priorityid = priorityid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    /*public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(ArrayList<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }*/

}
