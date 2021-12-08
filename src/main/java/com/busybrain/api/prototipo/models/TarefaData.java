package com.busybrain.api.prototipo.models;

import java.util.List;

public class TarefaData {
    
  /* Iterable<Tarefa> tarefas;

   public Iterable<Tarefa> getTarefas() {
       return tarefas;
   }

   public void setTarefas(Iterable<Tarefa> tarefas) {
       this.tarefas = tarefas;
   }*/

   List<Tarefa> tarefas;

   public TarefaData(List<Tarefa> tarefas){

      this.tarefas = tarefas;

   }

   public List<Tarefa> getTarefas() {
       return tarefas;
   }

   public void setTarefas(List<Tarefa> tarefas) {
       this.tarefas = tarefas;
   }

}
