

DROP TABLE IF EXISTS tdpt;
CREATE TABLE tdpt (
  ID BIGSERIAL primary key ,
  nom varchar(30) default NULL,
  code varchar(4) default NULL
) ;


INSERT INTO tdpt (nom,code) VALUES('E-Technologies','etch');
INSERT INTO tdpt (nom,code) VALUES('Services tertiaires','ster');
INSERT INTO tdpt (nom,code) VALUES('Administration','adm');

DROP TABLE IF EXISTS temploye;
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


DROP TABLE IF EXISTS tmission;
CREATE TABLE tmission (
  ID BIGSERIAL primary key,
  libelle varchar(200) default NULL,
  debut date default NULL,
  fin date default NULL
) ;

INSERT INTO tmission (libelle,debut,fin) VALUES('Formation CASA','2004-06-21','2004-07-10');
INSERT INTO tmission (libelle,debut,fin) VALUES('Audit Mthode projet TRANS','2004-07-01','2004-10-15');
INSERT INTO tmission (libelle,debut,fin) VALUES('Forfait ILO','2004-04-01','2005-01-15');

DROP TABLE IF EXISTS tformation;
CREATE TABLE tformation (
  cours varchar(50) default '0',
  ID bigint default NULL
) ;

INSERT INTO tformation VALUES('Modélisation Objet','2','1');



DROP TABLE IF EXISTS tregie;
CREATE TABLE tregie (
  taux int default '0',
  ID bigint default NULL
) ;

INSERT INTO tregie VALUES('7','2');


DROP TABLE IF EXISTS tforfait;
CREATE TABLE tforfait (
  IDFORFAIT bigint default '0',
  prix int default NULL,
  projet varchar(100) default NULL
) ;

INSERT INTO tforfait VALUES('3','10000','ILO');




