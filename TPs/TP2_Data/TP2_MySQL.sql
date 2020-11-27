# MySQL-Front Dump 2.2
#
# Host: localhost   Database: ssii
#--------------------------------------------------------
# Server version 3.23.51-max-nt-log


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
  `entree` date,
  `genre` varchar(5),
  `IDDpt` bigint(3) unsigned default NULL,
  PRIMARY KEY  (`Id`)
) ;



#
# Dumping data for table 'temploye'
#
INSERT INTO temploye VALUES("1","Jean Dupond","jd@plb.fr","01.41.21.61.25","2015-09-01","M","1");
INSERT INTO temploye VALUES("2","Marianne Predaut","mp@plb.fr","01.41.21.61.32","2015-09-01","F","1");
