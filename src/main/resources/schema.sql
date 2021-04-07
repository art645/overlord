SET SCHEMA PUBLIC;
DROP TABLE if exists lords CASCADE;
DROP TABLE if exists planets;
CREATE TABLE lords (
id integer primary key,
name varchar(50) not null,
age integer not null
);
CREATE TABLE planets (
id integer primary key,
name varchar(50) not null,
lord_id integer,
foreign key (lord_id) references lords (id)
);
INSERT INTO lords (id,name,age) VALUES
(1,'Абрам',100),
(2,'Аваз',300),
(3,'Август',600),
(4,'Авдей',200),
(5,'Автандил',400),
(6,'Адам',900),
(7,'Адис',700),
(8,'Адриан',500),
(9,'Азарий',5419),
(10,'Аким',5000),
(11,'Альберт',1000),
(12,'Альфред',800);
INSERT INTO planets(id,name) VALUES
(1,'Абанол'),
(2,'Абафар'),
(3,'Аббаджи'),
(4,'Абеднедо'),
(5,'Абиссисса'),
(6,'Або-Дрет'),
(7,'Абраксин'),
(8,'Абрегадо-Рей'),
(9,'Абхин'),
(10,'Аведот'),
(11,'Авишан'),
(12,'Агомар'),
(13,'Агра'),
(14,'Адана');
INSERT INTO planets(id,name,lord_id) VALUES
(15,'Циклоферон',1),
(16,'Садам',2);

