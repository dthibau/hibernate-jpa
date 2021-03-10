
DROP TABLE IF EXISTS temploye;
DROP TABLE IF EXISTS tdpt;

CREATE TABLE tdpt (
  ID BIGSERIAL primary key ,
  nom varchar(30) default NULL,
  code varchar(4) default NULL
) ;


INSERT INTO tdpt (nom,code) VALUES('E-Technologies','etch');
INSERT INTO tdpt (nom,code) VALUES('Services tertiaires','ster');
INSERT INTO tdpt (nom,code) VALUES('Administration','adm');


CREATE TABLE temploye (
  Id BIGSERIAL primary key ,
  nom varchar(40) NOT NULL default '',
  email varchar(30) default NULL,
  tel varchar(30) default NULL,
  entree date DEFAULT NULL,
  genre varchar(255) DEFAULT NULL,	
  IDDpt bigint default NULL
) ;




INSERT INTO temploye (nom,email,tel,entree,genre,iddpt ) VALUES('Jean Dupond','jd@plb.fr','01.41.21.61.25','2015-09-01','M','1');
INSERT INTO temploye (nom,email,tel,entree,genre,iddpt ) VALUES('Marianne Predaut','mp@plb.fr','01.41.21.61.32','2015-09-01','F','1');
