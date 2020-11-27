DROP TABLE IF EXISTS ttache;
DROP TABLE IF EXISTS tforfait;
DROP TABLE IF EXISTS tformation;
DROP TABLE IF EXISTS tregie;
DROP TABLE IF EXISTS tposte;
DROP TABLE IF EXISTS tmission;

DROP TABLE IF EXISTS temploye;
DROP TABLE IF EXISTS tdpt;
DROP TABLE IF EXISTS tclient;

CREATE TABLE tclient (
  ID BIGSERIAL primary key ,
  nom varchar(100) default NULL
) ;

CREATE TABLE tdpt (
  ID BIGSERIAL primary key,
  nom varchar(30) default NULL,
  code varchar(4) default NULL
) ;


CREATE TABLE temploye (
  ID BIGSERIAL primary key ,
  nom varchar(40) NOT NULL default '',
  email varchar(30) default NULL,
  tel varchar(30) default NULL,
  entree date DEFAULT NULL,
  genre varchar(255) DEFAULT NULL,	
  IDDpt bigint default NULL
) ;


CREATE TABLE tforfait (
  IDFORFAIT bigint default '0',
  prix int default NULL,
  projet varchar(100) default NULL
) ;

CREATE TABLE tformation (
  cours varchar(50) default '0',
  IDType int default NULL,
  ID bigint default NULL
) ;


CREATE TABLE tmission (
  ID bigserial primary key,
  libelle varchar(200) default NULL,
  debut date default NULL,
  fin date default NULL,
  IDClient bigint default NULL
) ;


CREATE TABLE tposte (
  Id bigserial primary key,
  charge float default NULL,
  libelle varchar(50) default NULL,
  description text,
  IdEmp bigint default NULL,
  idMission bigint default NULL
) ;

CREATE TABLE tregie (
  taux int default '0',
  ID bigint default NULL
) ;


CREATE TABLE ttache (
  Id bigserial primary key,
  libelle varchar(30) default NULL,
  charge int default NULL,
  IDForfait bigint default NULL
) ;

INSERT INTO tclient (nom) VALUES('Java.SA');
INSERT INTO tclient (nom) VALUES('Computing corp');

INSERT INTO tdpt (nom,code) VALUES('E-Technologies','etch');
INSERT INTO tdpt (nom,code) VALUES('Services tertiaires','ster');
INSERT INTO tdpt (nom,code) VALUES('Administration','adm');

INSERT INTO temploye(nom,email,tel,entree,genre,IDDpt) VALUES ('Jean Dupond','jd@plb.fr','01.41.21.61.25','2010-11-29','HOMME','1');
INSERT INTO temploye(nom,email,tel,entree,genre,IDDpt) VALUES('Marianne Predaut','mp@plb.fr','01.41.21.61.32','2010-11-29','FEMME','1');
INSERT INTO temploye (nom,email,tel,entree,genre,IDDpt) VALUES('Henri Prevost','hp@plb.fr','01.41.21.61.47','2010-11-29','HOMME','1');
INSERT INTO temploye (nom,email,tel,entree,genre,IDDpt) VALUES('Eric Dardaine','e','01.41.21.61.47','2010-11-29','HOMME','2');

INSERT INTO tmission (libelle, debut, fin, IDClient) VALUES('Formation CASA','2004-06-21','2004-07-10','1');
INSERT INTO tmission (libelle, debut, fin, IDClient) VALUES('Audit Mthode projet TRANS','2004-07-01','2004-10-15','1');
INSERT INTO tmission (libelle, debut, fin, IDClient) VALUES('Forfait ILO','2004-04-01','2005-01-15','2');

INSERT INTO tforfait VALUES(3,'10000','ILO');
INSERT INTO tformation VALUES('Modélisation Objet',2,1);

INSERT INTO tregie VALUES(7,2);

INSERT INTO tposte (charge,libelle,description,IdEmp,idMission) VALUES('5','Animateur','animer les sessions...','1','1');
INSERT INTO tposte (charge,libelle,description,IdEmp,idMission) VALUES('2','Consultant','Aide à la spécification','1','1');
INSERT INTO tposte (charge,libelle,description,IdEmp,idMission) VALUES('2','Resp. qualité','Tests, procédures, méthodologies','2','3');

INSERT INTO ttache (libelle, charge, idforfait) VALUES('Analyse','2','3');
INSERT INTO ttache (libelle, charge, idforfait) VALUES('Production','20','3');
INSERT INTO ttache (libelle, charge, idforfait) VALUES('Tests','10','3');



