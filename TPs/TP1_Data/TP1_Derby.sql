CONNECT 'jdbc:derby:vignerons';

DROP TABLE tdpt;
CREATE TABLE tdpt (
  ID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nom varchar(30) default NULL,
  code varchar(4) default NULL
) ;

INSERT INTO tdpt (nom,code) VALUES('E-Technologies','etch');
INSERT INTO tdpt (nom,code) VALUES('Services tertiaires','ster');
INSERT INTO tdpt (nom,code) VALUES('Administration','adm');

DROP TABLE temploye;
CREATE TABLE temploye (
  ID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nom varchar(40) NOT NULL default '',
  email varchar(30) default NULL,
  tel varchar(30) default NULL,
  IDDpt bigint default NULL) ;

INSERT INTO temploye (nom,email,tel,iddpt) VALUES('Jean Dupond','jd@plb.fr','01.41.21.61.25',1);
INSERT INTO temploye (nom,email,tel,iddpt) VALUES('Marianne Predaut','mp@plb.fr','01.41.21.61.32',1);
