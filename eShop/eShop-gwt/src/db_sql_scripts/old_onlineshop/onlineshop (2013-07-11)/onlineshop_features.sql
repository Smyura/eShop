CREATE DATABASE  IF NOT EXISTS `onlineshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `onlineshop`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: onlineshop
-- ------------------------------------------------------
-- Server version	5.6.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `features`
--

DROP TABLE IF EXISTS `features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `features` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DISPLAY` varchar(100) DEFAULT NULL,
  `CPU` varchar(100) DEFAULT NULL,
  `RAM` varchar(45) DEFAULT NULL,
  `CHIPSET` varchar(45) DEFAULT NULL,
  `HD` varchar(45) DEFAULT NULL,
  `GRAPHICS_ADAPTER` varchar(45) DEFAULT NULL,
  `NETWORK_ADAPTER` varchar(45) DEFAULT NULL,
  `OPTICAL_DRIVE` varchar(45) DEFAULT NULL,
  `IO` varchar(100) DEFAULT NULL,
  `OS` varchar(45) DEFAULT NULL,
  `BATTERY` varchar(45) DEFAULT NULL,
  `HWD` varchar(45) DEFAULT NULL,
  `WEIGHT` varchar(45) DEFAULT NULL,
  `KIT` varchar(100) DEFAULT NULL,
  `GUARANTEE` varchar(20) DEFAULT NULL,
  `COLOUR` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `features`
--

LOCK TABLES `features` WRITE;
/*!40000 ALTER TABLE `features` DISABLE KEYS */;
/*!40000 ALTER TABLE `features` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-11 11:32:14