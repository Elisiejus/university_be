-- DML
insert into university (code, title) values ('KTU', 'Kaunas University of Technology');
insert into university (code, title) values ('VU', 'Vilnius University');

insert into study_program (title, university_id) VALUES ('Multimedia Technologies', (select id from university where code = 'KTU'));
insert into study_program (title, university_id) VALUES ('Informatics', (select id from university where code = 'KTU'));
insert into study_program (title, university_id) VALUES ('Software Systems', (select id from university where code = 'KTU'));

insert into module (title) values ('Computer Graphics');
insert into module (title) values ('Mathematics');
insert into module (title) values ('Fundamentals of Object-Oriented Programming');
insert into module (title) values ('Digital Logic');

insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Informatics'), (select id from module where title = 'Computer Graphics'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Informatics'), (select id from module where title = 'Mathematics'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Informatics'), (select id from module where title = 'Fundamentals of Object-Oriented Programming'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Informatics'), (select id from module where title = 'Digital Logic'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Software Systems'), (select id from module where title = 'Mathematics'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Software Systems'), (select id from module where title = 'Fundamentals of Object-Oriented Programming'));
