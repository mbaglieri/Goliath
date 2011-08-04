-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.3


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema LASDISMARIO
--

CREATE DATABASE IF NOT EXISTS LASDISMARIO;
USE LASDISMARIO;

--
-- Definition of table `LASDISMARIO`.`requestmap`
--

DROP TABLE IF EXISTS `LASDISMARIO`.`requestmap`;
CREATE TABLE  `LASDISMARIO`.`requestmap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `url` varchar(255) NOT NULL,
  `config_attribute` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `url` (`url`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LASDISMARIO`.`requestmap`
--

/*!40000 ALTER TABLE `requestmap` DISABLE KEYS */;
LOCK TABLES `requestmap` WRITE;
INSERT INTO `LASDISMARIO`.`requestmap` VALUES  (1,0,'/accesorios/list','ROLE_ADMIN');
UNLOCK TABLES;
/*!40000 ALTER TABLE `requestmap` ENABLE KEYS */;


--
-- Definition of table `LASDISMARIO`.`roles`
--

DROP TABLE IF EXISTS `LASDISMARIO`.`roles`;
CREATE TABLE  `LASDISMARIO`.`roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `authority` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authority` (`authority`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LASDISMARIO`.`roles`
--

/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
LOCK TABLES `roles` WRITE;
INSERT INTO `LASDISMARIO`.`roles` VALUES  (1,2,'ROLE_ADMIN','Administrador');
UNLOCK TABLES;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


--
-- Definition of table `LASDISMARIO`.`roles_people`
--

DROP TABLE IF EXISTS `LASDISMARIO`.`roles_people`;
CREATE TABLE  `LASDISMARIO`.`roles_people` (
  `roles_id` bigint(20) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`roles_id`,`usuario_id`),
  KEY `FK9ABA0251E94612DA` (`usuario_id`),
  KEY `FK9ABA0251F4E1AC7A` (`roles_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LASDISMARIO`.`roles_people`
--

/*!40000 ALTER TABLE `roles_people` DISABLE KEYS */;
LOCK TABLES `roles_people` WRITE;
INSERT INTO `LASDISMARIO`.`roles_people` VALUES  (1,1),
 (1,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `roles_people` ENABLE KEYS */;


--
-- Definition of table `LASDISMARIO`.`usuario`
--

DROP TABLE IF EXISTS `LASDISMARIO`.`usuario`;
CREATE TABLE  `LASDISMARIO`.`usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `passwd` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email_show` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `user_real_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LASDISMARIO`.`usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
LOCK TABLES `usuario` WRITE;
INSERT INTO `LASDISMARIO`.`usuario` VALUES  (1,1,'40bd001563085fc35165329ea1ff5c5ecbdbbeef',0x01,'adminisrrador',0x01,'admin@admin.com','Administrador','administrador'),
 (2,1,'601f1889667efaebb33b8c12572835da3f027f78',0x01,'admin',0x01,'admin@admin.com','admin','admin');
UNLOCK TABLES;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
