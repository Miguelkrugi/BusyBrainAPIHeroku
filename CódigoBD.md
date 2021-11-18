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

### Tabela "grupo"

create table grupo(

    group_id SERIAL primary key,
    group_name varchar(30) not null,
    group_description varchar(150)

);

### Tabela "convivio"

create table convivio(

    data_convivio date,
    convivio_id int primary key,
    grupo_id int,
    CONSTRAINT fk_grupo_id FOREIGN KEY(grupo_id) REFERENCES grupo(group_id)
    placee_id int,
    CONSTRAINT fk_place_id FOREIGN KEY(placee_id) REFERENCES place(place_id)

);

### Tabela "bloqueamento"

create table bloqueamento(

    utilizador_id int,
    CONSTRAINT fk_user_id FOREIGN KEY(utilizador_id) REFERENCES utilizador(user_id),
    blocked_status boolean (bit),
    
);

### Tabela "bloqueamento_app"

create table app(

  app_id SERIAL primary key,
  app_name varchar(50)

) inherits (bloqueamento);

### Tabela "utilizador_app"

create table utilizador_app(

   user_app_id SERIAL primary key,
   application_id int,
   CONSTRAINT fk_app_id FOREIGN KEY(application_id) REFERENCES app(app_id),
   utilizador_id int,
   CONSTRAINT fk_user_id FOREIGN KEY(utilizador_id) REFERENCES utilizador(user_id)
   
);

### Tabela "utilizador_website"

create table utilizador_website(

  user_website_id SERIAL primary key,
  website_id int,
  CONSTRAINT fk_user_id FOREIGN KEY(utilizador_id) REFERENCES utilizador(user_id),
  utilizador_id,
  CONSTRAINT fk_user_id FOREIGN KEY(utilizador_id) REFERENCES utilizador(user_id),
)

### Tabela "bloqueamento_website"

create table website(

  website_id SERIAL primary key,
  website_domain varchar(150)

) inherits (bloqueamento);

## Inserts em tabelas

### Tabela "tarefa"

insert into tarefa (task_title, task_desc, due_date, user_task_id, task_priority_id, task_type_id) 
values ('Math homework', 'Do the math homework', '2015-03-08', '3', '2', '1')

insert into tarefa (task_title, task_desc, due_date, user_task_id, task_priority_id, task_type_id) 
values ('Cook the dinner', 'Cook the dinner for Christmas Day', '2015-03-08', '3', '1', '3')

insert into tarefa (task_title, task_desc, due_date, user_task_id, task_priority_id, task_type_id) 
values ('Buy groceries', 'Buy all the groceries to lunch', '2020-01-12', '4', '3', '2')

### Tabela "utilizador"

insert into utilizador (user_name, user_password, user_email) 
values ('johndoe', 'johndoeoriginal', 'jdoe@gmail.com')


insert into utilizador (user_name, user_password, user_email) 
values ('marydoe', 'marydoeoriginal', 'mdoe@gmail.com')


insert into utilizador (user_name, user_password, user_email) 
values ('laurendoe', 'laudoeoriginal', 'lauren12doe@gmail.com')


insert into utilizador (user_name, user_password, user_email) 
values ('joaofepas12', 'fepasjoaoxxx12', 'fepas@gmail.com')


insert into utilizador (user_name, user_password, user_email) 
values ('miguel12', 'miguel2002', 'miguel12@gmail.com')


insert into utilizador (user_name, user_password, user_email) 
values ('juliotrinta56', 'julio56password', 'julio56@gmail.com')


insert into utilizador (user_name, user_password, user_email) 
values ('hugoferreira22', 'huguinhopp', 'hugoferras22@gmail.com')

### Tabela "tipotarefa"

insert into tipotarefa (tasktype_nome) 
values ('Individual')

insert into tipotarefa (tasktype_nome) 
values ('Grupo')

### Tabela "prioridadetarefa"

insert into prioridadetarefa (taskpriority_type) 
values ('Low')

insert into prioridadetarefa (taskpriority_type) 
values ('Medium')

insert into prioridadetarefa (taskpriority_type) 
values ('High')

insert into prioridadetarefa (taskpriority_type) 
values ('Urgent')

### Tabela "categorialocal"

insert into categorialocal (categoria_name) 
values ('Cafe')

insert into categorialocal (categoria_name) 
values ('Bar')

insert into categorialocal (categoria_name) 
values ('Restaurante')

insert into categorialocal (categoria_name) 
values ('Livraria')

insert into categorialocal (categoria_name) 
values ('Biblioteca')

### Tabela "bloqueamento_app"

insert into categorialocal (categoria_name) 
values ('Biblioteca')


### Tabela "bloqueamento_website"

## Queries









