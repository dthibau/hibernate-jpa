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

INSERT INTO tforfait VALUES('10000','ILO',3);
INSERT INTO tformation VALUES('Modélisation Objet',2);

INSERT INTO tregie VALUES(7,2);

INSERT INTO tposte (charge,libelle,description,IdEmp,idMission) VALUES('5','Animateur','animer les sessions...','1','1');
INSERT INTO tposte (charge,libelle,description,IdEmp,idMission) VALUES('2','Consultant','Aide à la spécification','1','1');
INSERT INTO tposte (charge,libelle,description,IdEmp,idMission) VALUES('2','Resp. qualité','Tests, procédures, méthodologies','2','3');

INSERT INTO ttache (libelle, charge, idforfait) VALUES('Analyse','2','3');
INSERT INTO ttache (libelle, charge, idforfait) VALUES('Production','20','3');
INSERT INTO ttache (libelle, charge, idforfait) VALUES('Tests','10','3');
