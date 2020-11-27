

DROP TABLE IF EXISTS tdpt;
CREATE TABLE tdpt (
  ID bigint NOT NULL ,
  nom varchar(30) default NULL,
  code varchar(4) default NULL,
  PRIMARY KEY  (ID)
) ;


INSERT INTO tdpt VALUES(1,'E-Technologies','etch');
INSERT INTO tdpt VALUES(2,'Services tertiaires','ster');
INSERT INTO tdpt VALUES(3,'Administration','adm');

DROP TABLE IF EXISTS temploye;
CREATE TABLE temploye (
  Id bigint NOT NULL ,
  nom varchar(40) NOT NULL default '',
  email varchar(30) default NULL,
  tel varchar(30) default NULL,
  IDDpt bigint default NULL,
  PRIMARY KEY  (Id)
) ;




INSERT INTO temploye VALUES(1,'Jean Dupond','jd@plb.fr','01.41.21.61.25','1');
INSERT INTO temploye VALUES(2,'Marianne Predaut','mp@plb.fr','01.41.21.61.32','1');
