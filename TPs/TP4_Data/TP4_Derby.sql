CONNECT 'jdbc:derby://localhost/ssii';

DROP TABLE tdpt;
CREATE TABLE tdpt (
  ID BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nom varchar(30) default NULL,
  code varchar(4) default NULL
) ;

INSERT INTO tdpt (nom,code) VALUES('E-Technologies','etch');
INSERT INTO tdpt (nom,code) VALUES('Services tertiaires','ster');
INSERT INTO tdpt (nom,code) VALUES('Administration','adm');


DROP TABLE temploye;
CREATE TABLE temploye (
  ID BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nom varchar(40) NOT NULL default '',
  email varchar(30) default NULL,
  tel varchar(30) default NULL,
  IDDpt bigint default NULL) ;

INSERT INTO temploye (nom,email,tel,iddpt) VALUES('Jean Dupond','jd@plb.fr','01.41.21.61.25',1);
INSERT INTO temploye (nom,email,tel,iddpt) VALUES('Marianne Predaut','mp@plb.fr','01.41.21.61.32',1);


DROP TABLE tmission;
CREATE TABLE tmission (
  ID BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  libelle varchar(200) default NULL,
  debut date default NULL,
  fin date default NULL
) ;

INSERT INTO tmission (libelle,debut,fin) VALUES('Formation CASA','2004-06-21','2004-07-10');
INSERT INTO tmission (libelle,debut,fin) VALUES('Audit Mthode projet TRANS','2004-07-01','2004-10-15');
INSERT INTO tmission (libelle,debut,fin) VALUES('Forfait ILO','2004-04-01','2005-01-15');

DROP TABLE tformation;
CREATE TABLE tformation (
  cours varchar(50) default '0',
  ID bigint default NULL
) ;

INSERT INTO tformation VALUES('Modélisation Objet',2,1);



DROP TABLE tregie;
CREATE TABLE tregie (
  taux int default 0,
  ID bigint default NULL
) ;

INSERT INTO tregie VALUES(7,2);


DROP TABLE tforfait;
CREATE TABLE tforfait (
  IDFORFAIT bigint default 0,
  prix int default NULL,
  projet varchar(100) default NULL
) ;

INSERT INTO tforfait VALUES(3,10000,'ILO');




