# Código de criação da Base de Dados

## Criação de tabelas

### Tabela "Utilizador"

create table utilizador(

   user_id SERIAL primary key,
   user_name varchar(20) not null,
   user_password varchar(30) not null,
   user_email varchar(50)

);

### Tabela "TipoTarefa"

create table tipotarefa(

   tasktype_id SERIAL primary key,
   tasktype_nome varchar(30) not null

);

### Tabela "PrioridadeTarefa"

create table prioridadetarefa(

   taskpriority_id SERIAL primary key,
   taskpriority_type varchar(10)

);

### Tabela "Tarefa"

create table tarefa(

   task_id SERIAL primary key,
   task_title varchar(50) not null,
   task_desc varchar(500) DEFAULT 'There is no description for this task',
   due_date date NOT NULL DEFAULT CURRENT_DATE,
   user_task_id int,	
   CONSTRAINT fk_usertaskid FOREIGN KEY(user_task_id) REFERENCES utilizador(user_id),
   task_priority_id int,
   CONSTRAINT fk_prioritytarefa FOREIGN KEY(task_priority_id) REFERENCES prioridadetarefa(taskpriority_id),
   task_type_id int,
   CONSTRAINT fk_tipotarefa FOREIGN KEY(task_type_id) REFERENCES tipotarefa(tasktype_id) 	

);

### Tabela "utilizador_tarefa"

create table utilizador_tarefa(

  user_id_tarefa SERIAL primary key,
  user_identifier int,
  CONSTRAINT fk_user_identifier FOREIGN KEY(user_identifier) REFERENCES utilizador(user_id),	
  task_identifier int,
  CONSTRAINT fk_task_identifier FOREIGN KEY(task_identifier) REFERENCES tarefa(task_id)	
  	
);

### Tabela "Local"

create table place(

  place_id SERIAL primary key,
  place_name varchar(100) not null,
  place_endereco varchar(300) not null,
  place_distancia int, 
  place_categoria_id int,
  CONSTRAINT fk_placecategoriaid FOREIGN KEY(place_categoria_id) REFERENCES categorialocal(categoria_id)
  place_latitude double,
  place_longitude double

);

### Tabela "categorialocal"

create table categorialocal(

  categoria_id SERIAL primary key,
  categoria_name varchar(15) not null

);

### Tabela "utilizador_local" -> MANTER OU NAO MANTER

create table utilizador_local(

  user_local_id SERIAL primary key,
  utilizador_id int,
  CONSTRAINT fk_utilizador_id FOREIGN KEY(utilizador_id) REFERENCES utilizador(user_id) 
  local_id int,
  CONSTRAINT fk_local_id FOREIGN KEY(local_id) REFERENCES place(place_id)
);

### Tabela "marcacao_presenca"

create table marcacao_presenca(

   presenca_id SERIAL primary key,
   wasThere bit (boolean),
   utilizador_id int,
   CONSTRAINT fk_utilizador_id FOREIGN KEY(utilizador_id) REFERENCES utilizador(user_id),
   local_id int,
   CONSTRAINT fk_local_id FOREIGN KEY(local_id) REFERENCES place(place_id)

);

### Tabela "marcacao_favorito"

create table marcacao_favorito(

   favorite_id SERIAL primary key,
   isFavorite bit (boolean),
   utilizador_id int,
   CONSTRAINT fk_utilizador_id FOREIGN KEY(utilizador_id) REFERENCES utilizador(user_id),
   local_id int,
   CONSTRAINT fk_local_id FOREIGN KEY(local_id) REFERENCES place(place_id)

);


CONSTRAINT fk_tarefa_id FOREIGN KEY(tarefa_id) REFERENCES tarefa(task_id)










