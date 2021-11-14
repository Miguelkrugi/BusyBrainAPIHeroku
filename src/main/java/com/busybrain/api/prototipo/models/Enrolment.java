package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utilizador_tarefa")
public class Enrolment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "utilizador_id") private int utilizadorid;

    @ManyToOne
    @JoinColumn(name = "tarefa_id") private int tarefaid;

    @Column(name = "user_tarefa_id") private int usertarefaid;

    public Enrolment(){


    }

    public int getUtilizadorid() {
        return utilizadorid;
    }

    public void setUtilizadorid(int utilizadorid) {
        this.utilizadorid = utilizadorid;
    }

    public int getTarefaid() {
        return tarefaid;
    }

    public void setTarefaid(int tarefaid) {
        this.tarefaid = tarefaid;
    }

    public int getUsertarefaid() {
        return usertarefaid;
    }

    public void setUsertarefaid(int usertarefaid) {
        this.usertarefaid = usertarefaid;
    }

}

/*package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

    

}*/
