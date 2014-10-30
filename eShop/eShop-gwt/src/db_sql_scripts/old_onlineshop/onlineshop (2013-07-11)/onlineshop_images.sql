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
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `images` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IMAGE_LINK` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (7,'/ONLINESHOP/IMAGES/PRODUCT_TYPES/NOTEBOOKS.jpg'),(8,'/ONLINESHOP/IMAGES/PRODUCT_TYPES/COMPUTERS.jpg'),(9,'/ONLINESHOP/IMAGES/PRODUCT_TYPES/TABLETS.jpg'),(11,'/ONLINESHOP/IMAGES/PRODUCTS/NOTEBOOKS/APPLE/Apple_MacBook_Air_MC969RS-A_Silver.jpg'),(12,'/ONLINESHOP/IMAGES//PRODUCTS/NOTEBOOKS/DELL/Dell_Inspiron_M5110_Diamond_Black.jpg'),(13,'/ONLINESHOP/IMAGES//PRODUCTS/NOTEBOOKS/DELL/Dell_Inspiron_N7110_Diamond_Black.jpg'),(14,'/ONLINESHOP/IMAGES/PRODUCTS/NOTEBOOKS/SONY/Sony_VAIO_VPCEJ1L1R-W_White.jpg'),(15,'/ONLINESHOP/IMAGES/PRODUCTS/NOTEBOOKS/HP'),(16,'/ONLINESHOP/IMAGES/PRODUCT_TYPES/MOBILE_PHONES.jpg');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-11 11:32:15