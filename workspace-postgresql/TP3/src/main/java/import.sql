
INSERT INTO Departement (id,nom,code) VALUES(1,'E-Technologies','etch');
INSERT INTO Departement (id,nom,code) VALUES(2,'Services tertiaires','ster');
INSERT INTO Departement (id,nom,code) VALUES(3,'Administration','adm');

INSERT INTO Employe(id,nom,email,telephone,entree,genre) VALUES (1,'Jean Dupond','jd@plb.fr','01.41.21.61.25','2010-11-29',1);
INSERT INTO Employe(id,nom,email,telephone,entree,genre) VALUES(2,'Marianne Predaut','mp@plb.fr','01.41.21.61.32','2010-11-29',2);
INSERT INTO Employe (id,nom,email,telephone,entree,genre) VALUES(3,'Henri Prevost','hp@plb.fr','01.41.21.61.47','2010-11-29',1);
INSERT INTO Employe (id,nom,email,telephone,entree,genre) VALUES(4,'Eric Dardaine','e','01.41.21.61.47','2010-11-29',1);

INSERT INTO Departement_Employe VALUES(1,1);
