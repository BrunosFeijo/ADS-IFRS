use escola;

insert into aluno (ra,nome,endereco,telefone,rg,cpf)
values (12354,'Marcos Paulo', 'Rua dos Eucaliptos', '(51)3247-0987', 8878788, 123445590);

insert into aluno (ra,nome,endereco,telefone,rg,cpf)
values (8667,'Caroline Silveira', 'Rua das Margaridas', '(51)98765-9877', 7657657, 178678609);

insert into aluno (ra,nome,endereco,telefone,rg,cpf)
values (65654,'Inácio Pena', 'Rua dos Marimbondos', '(51)7676-87709', 76576588, 5467587);

insert into aluno (ra,nome,endereco,telefone,rg,cpf)
values (8987,'Carla Farias', 'Rua das Gurias', '(51)9865-5576', 7657657, 987643419);

insert into professor (num_matricula,nome,endereco,telefone ,email)
values (1223,'Joana Mendes','Rua das Princesas','(53)98767-9770','joana.mendes@gmail.com');

insert into professor (num_matricula,nome,endereco,telefone ,email)
values (4523,'Flávio Canto','Rua dos Cangurus','(53)87654-9087','flavio.cantop@hotmail.com');

insert into curso (duracao ,    id , nome,   professor_num_matricula)
values (60,1,'Informática Básica',4523);

insert into curso (duracao ,    id , nome,    professor_num_matricula)
values (90,2,'Informática Avançada',1223);

insert into sala (numero,nome,id)
values (401,'Laboratorio de Info I',1);

insert into sala (numero,nome,id)
values (404,'Laboratorio de Info II',2);

insert into sala (numero,nome,id)
values (403,'Laboratorio de Info III',3);

insert into curso_has_aluno(curso_id, aluno_ra)
values (1,12354);

insert into curso_has_aluno(curso_id, aluno_ra)
values (1,8667);

insert into curso_has_aluno(curso_id, aluno_ra)
values (2,8667);

insert into curso_has_aluno(curso_id, aluno_ra)
values (2,65654);

insert into curso_has_aluno(curso_id, aluno_ra)
values (1,8987);

insert into curso_has_aluno(curso_id, aluno_ra)
values (2,8987);

