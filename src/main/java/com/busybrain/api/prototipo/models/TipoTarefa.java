package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "tipotarefa")
public class TipoTarefa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "tasktype_id") private int tasktypeid;
    @Column(name = "tasktype_nome") private String tasktypenome;

    public TipoTarefa(){


    }

    public int getTasktypeid() {
        return tasktypeid;
    }

    public void setTasktypeid(int tasktypeid) {
        this.tasktypeid = tasktypeid;
    }

    public String getTasktypenome() {
        return tasktypenome;
    }

    public void setTasktypenome(String tasktypenome) {
        this.tasktypenome = tasktypenome;
    }

}
