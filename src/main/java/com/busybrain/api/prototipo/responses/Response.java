package com.busybrain.api.prototipo.responses;

import java.util.ArrayList;

import com.busybrain.api.prototipo.models.Tarefa;

public class Response {
    
    public ArrayList<Tarefa> tarefas;

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}
