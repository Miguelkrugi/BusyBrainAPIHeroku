package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "") private int usertaskid;
    @Column(name = "") private Utilizador utilizador;
    @Column(name = "") private Tarefa tarefa;

    public Enrolment(){


    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public int getUsertaskid() {
        return usertaskid;
    }

    public void setUsertaskid(int usertaskid) {
        this.usertaskid = usertaskid;
    }

    

}
