﻿# MySQL-Front Dump 2.2
#
# Host: localhost   Database: ssii
#--------------------------------------------------------
# Server version 3.23.51-max-nt-log


#
# Table structure for table 'tclient'
#

DROP TABLE IF EXISTS tclient;
CREATE TABLE `tclient` (
  `ID` bigint(5) unsigned NOT NULL auto_increment,
  `nom` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ;



#
# Dumping data for table 'tclient'
#
INSERT INTO tclient VALUES("1","Java.SA");
INSERT INTO tclient VALUES("2","Computing corp");


#
# Table structure for table 'tdpt'
#

DROP TABLE IF EXISTS tdpt;
CREATE TABLE `tdpt` (
  `ID` bigint(3) unsigned NOT NULL auto_increment,
  `nom` varchar(30) default NULL,
  `code` varchar(4) default NULL,
  PRIMARY KEY  (`ID`)
) ;



#
# Dumping data for table 'tdpt'
#
INSERT INTO tdpt VALUES("1","E-Technologies","etch");
INSERT INTO tdpt VALUES("2","Services tertiaires","ster");
INSERT INTO tdpt VALUES("3","Administration","adm");


#
# Table structure for table 'temploye'
#

DROP TABLE IF EXISTS temploye;
CREATE TABLE `temploye` (
  `Id` bigint(4) unsigned NOT NULL auto_increment,
  `nom` varchar(40) NOT NULL default '',
  `email` varchar(30) default NULL,
  `tel` varchar(30) default NULL,
  `entree` date DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,	
  `IDDpt` bigint(3) unsigned default NULL,
  PRIMARY KEY  (`Id`)
) ;



#
# Dumping data for table 'temploye'
#
INSERT INTO temploye VALUES("1","Jean Dupond","jd@plb.fr","01.41.21.61.25","2010-11-29","HOMME","1");
INSERT INTO temploye VALUES("2","Marianne Predaut","mp@plb.fr","01.41.21.61.32","2010-11-29","FEMME","1");
INSERT INTO temploye VALUES("3","Henri Prevost","hp@plb.fr","01.41.21.61.47","2010-11-29","HOMME","1");
INSERT INTO temploye VALUES("4","Eric Dardaine","","01.41.21.61.47","2010-11-29","HOMME","2");

#
# Table structure for table 'tforfait'
#

DROP TABLE IF EXISTS tforfait;
CREATE TABLE `tforfait` (
  `ID` bigint(5) unsigned default '0',
  `prix` int(9) unsigned default NULL,
  `projet` varchar(100) default NULL
) ;



#
# Dumping data for table 'tforfait'
#
INSERT INTO tforfait VALUES("3","10000","ILO");


#
# Table structure for table 'tformation'
#

DROP TABLE IF EXISTS tformation;
CREATE TABLE `tformation` (
  `cours` varchar(50) default '0',
  `IDType` int(3) unsigned default NULL,
  `ID` bigint(3) unsigned default NULL
) ;



#
# Dumping data for table 'tformation'
#
INSERT INTO tformation VALUES("Modélisation Objet","2","1");


#
# Table structure for table 'tmission'
#

DROP TABLE IF EXISTS tmission;
CREATE TABLE `tmission` (
  `ID` bigint(5) unsigned NOT NULL auto_increment,
  `libelle` varchar(200) default NULL,
  `debut` date default NULL,
  `fin` date default NULL,
  `IDClient` bigint(5) unsigned default NULL,
  PRIMARY KEY  (`ID`)
) ;



#
# Dumping data for table 'tmission'
#
INSERT INTO tmission VALUES("1","Formation CASA","2004-06-21","2004-07-10","1");
INSERT INTO tmission VALUES("2","Audit Mthode projet TRANS","2004-07-01","2004-10-15","1");
INSERT INTO tmission VALUES("3","Forfait ILO","2004-04-01","2005-01-15","2");


#
# Table structure for table 'tposte'
#

DROP TABLE IF EXISTS tposte;
CREATE TABLE `tposte` (
  `Id` bigint(5) unsigned NOT NULL auto_increment,
  `charge` float default NULL,
  `libelle` varchar(50) default NULL,
  `description` longtext,
  `IdEmp` bigint(5) unsigned default NULL,
  `idMission` bigint(5) unsigned default NULL,
  PRIMARY KEY  (`Id`)
) ;



#
# Dumping data for table 'tposte'
#
INSERT INTO tposte VALUES("1","5","Animateur","animer les sessions...","1","1");
INSERT INTO tposte VALUES("2","2","Consultant","Aide à la spécification","1","1");
INSERT INTO tposte VALUES("3","2","Resp. qualité","Tests, procédures, méthodologies","2","3");


#
# Table structure for table 'tregie'
#

DROP TABLE IF EXISTS tregie;
CREATE TABLE `tregie` (
  `taux` int(3) unsigned default '0',
  `ID` bigint(5) unsigned default NULL
) ;



#
# Dumping data for table 'tregie'
#
INSERT INTO tregie VALUES("7","2");


#
# Table structure for table 'ttache'
#

DROP TABLE IF EXISTS ttache;
CREATE TABLE `ttache` (
  `ID` bigint(3) unsigned NOT NULL auto_increment,
  `libelle` varchar(30) default NULL,
  `charge` int(3) unsigned default NULL,
  `IDForfait` bigint(5) unsigned default NULL,
  PRIMARY KEY  (`ID`)
) ;



#
# Dumping data for table 'tdpt'
#
INSERT INTO ttache VALUES("1","Analyse","2","3");
INSERT INTO ttache VALUES("2","Production","20","3");
INSERT INTO ttache VALUES("3","Tests","10","3");

