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
  ID bigint NOT NULL ,
  nom varchar(100) default NULL,
  PRIMARY KEY  (ID)
) ;

CREATE TABLE tdpt (
  ID bigint NOT NULL ,
  nom varchar(30) default NULL,
  code varchar(4) default NULL,
  PRIMARY KEY  (ID)
) ;


CREATE TABLE temploye (
  Id bigint NOT NULL ,
  nom varchar(40) NOT NULL default '',
  email varchar(30) default NULL,
  tel varchar(30) default NULL,
  entree date DEFAULT NULL,
  genre varchar(255) DEFAULT NULL,	
  IDDpt bigint default NULL,
  PRIMARY KEY  (Id)
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
  ID bigint NOT NULL ,
  libelle varchar(200) default NULL,
  debut date default NULL,
  fin date default NULL,
  IDClient bigint default NULL,
  PRIMARY KEY  (ID)
) ;


CREATE TABLE tposte (
  Id bigint NOT NULL ,
  charge float default NULL,
  libelle varchar(50) default NULL,
  description text,
  IdEmp bigint default NULL,
  idMission bigint default NULL,
  PRIMARY KEY  (Id)
) ;

CREATE TABLE tregie (
  taux int default '0',
  ID bigint default NULL
) ;


CREATE TABLE ttache (
  ID bigint NOT NULL ,
  libelle varchar(30) default NULL,
  charge int default NULL,
  IDForfait bigint default NULL,
  PRIMARY KEY  (ID)
) ;

INSERT INTO tclient (ID,nom) VALUES(1,'Java.SA');
INSERT INTO tclient (ID,nom) VALUES(2,'Computing corp');

INSERT INTO tdpt VALUES('1','E-Technologies','etch');
INSERT INTO tdpt VALUES('2','Services tertiaires','ster');
INSERT INTO tdpt VALUES('3','Administration','adm');

INSERT INTO temploye VALUES('1','Jean Dupond','jd@plb.fr','01.41.21.61.25','2010-11-29','HOMME','1');
INSERT INTO temploye VALUES('2','Marianne Predaut','mp@plb.fr','01.41.21.61.32','2010-11-29','FEMME','1');
INSERT INTO temploye VALUES('3','Henri Prevost','hp@plb.fr','01.41.21.61.47','2010-11-29','HOMME','1');
INSERT INTO temploye VALUES('4','Eric Dardaine','e','01.41.21.61.47','2010-11-29','HOMME','2');

INSERT INTO tmission VALUES('1','Formation CASA','2004-06-21','2004-07-10','1');
INSERT INTO tmission VALUES('2','Audit Mthode projet TRANS','2004-07-01','2004-10-15','1');
INSERT INTO tmission VALUES('3','Forfait ILO','2004-04-01','2005-01-15','2');

INSERT INTO tforfait VALUES('3','10000','ILO');
INSERT INTO tformation VALUES('Modélisation Objet','2','1');

INSERT INTO tregie VALUES('7','2');

INSERT INTO tposte VALUES('1','5','Animateur','animer les sessions...','1','1');
INSERT INTO tposte VALUES('2','2','Consultant','Aide à la spécification','1','1');
INSERT INTO tposte VALUES('3','2','Resp. qualité','Tests, procédures, méthodologies','2','3');

INSERT INTO ttache VALUES('1','Analyse','2','3');
INSERT INTO ttache VALUES('2','Production','20','3');
INSERT INTO ttache VALUES('3','Tests','10','3');


