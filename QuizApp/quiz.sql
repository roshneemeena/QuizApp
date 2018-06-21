

CREATE TABLE quiz_App.MCQChoice (
    question varchar(200),opt1 varchar(50),opt2 varchar(50),opt3 varchar(50),opt4 varchar(50)
  
);

insert  into quiz_App.MCQChoice(id,question,option1,option2,option3,option4) values (1,'Java is ?','Object Oriented','Procedural','Asembly','Machin Level'),(2,'Static block loaded','Afer the class','Before the class','never','No such variable in java');

insert  into quiz_App.Answers(id,questionId,answer) values (1,1,'Object Oriented'),(2,2,'Before the class');

select * from quiz_App.MCQChoice

select * from quiz_App.Question

insert into quiz_App.Admin(id,email,password) values (1,'admin','admin')
insert into quiz_App.Question(id,question) values (1,'What is java')
select * from quiz_App.Admin
select * from quiz_App.Students