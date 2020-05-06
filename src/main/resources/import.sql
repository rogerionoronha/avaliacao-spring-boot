--EFETUE A CRIACAO DOS SCRIPTS QUE IRAO FAZER A CARGA DOS DADOS

insert into estudante (id, nome, email, telefone, matricula, curso) values ((select ESTUDANTE_SEQ.nextval from dual), 'Xawoy', 'xawoy@tms.com.br ', '7777','123456', 'Engenharia da Computação');


insert into estudante (id, nome, email, telefone, matricula, curso) values ((select ESTUDANTE_SEQ.nextval from dual), 'Furae', 'furae@tms.com.br ', '7778','678912', 'Ciência da Computação');


insert into estudante (id, nome, email, telefone, matricula, curso) values ((select ESTUDANTE_SEQ.nextval from dual), 'Fupuy', 'fupuy@tms.com.br ', '7779','321654', 'Engenharia da Computação');


insert into estudante (id, nome, email, telefone, matricula, curso) values ((select ESTUDANTE_SEQ.nextval from dual), 'Kuer', 'kuer@tms.com.br ', '7780','654987', 'Análise de Dados');


insert into estudante (id, nome, email, telefone, matricula, curso) values ((select ESTUDANTE_SEQ.nextval from dual), 'Blias', 'blias@tms.com.br ', '7781','666131', 'Ciência da Computação');
