-- DDL
create table user
(
    id int unsigned auto_increment primary key,
    email varchar(250) not null unique,
    password varchar(60) not null,
    name varchar(50) not null
);

CREATE TABLE university
(
    id    int unsigned auto_increment primary key,
    code  varchar(10)  not null,
    title varchar(250) not null
);

CREATE TABLE study_program
(
    id            int unsigned auto_increment primary key,
    title         varchar(250) not null,
    university_id int unsigned not null,
    foreign key (university_id) references university (id)
);

CREATE TABLE module
(
    id    int unsigned auto_increment primary key,
    title varchar(250) not null
);

CREATE TABLE study_program_module
(
    study_program_id int unsigned not null,
    module_id        int unsigned not null,
    foreign key (study_program_id) references study_program (id),
    foreign key (module_id) references module (id),
    unique (study_program_id, module_id)
);
