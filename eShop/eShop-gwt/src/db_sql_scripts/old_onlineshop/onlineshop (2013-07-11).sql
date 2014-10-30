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
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brands` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,'Apple'),(2,'Dell'),(3,'Sony'),(4,'HP');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `product_type_parts`
--

DROP TABLE IF EXISTS `product_type_parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_type_parts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type_parts`
--

LOCK TABLES `product_type_parts` WRITE;
/*!40000 ALTER TABLE `product_type_parts` DISABLE KEYS */;
INSERT INTO `product_type_parts` VALUES (1,'Notebooks and Computers'),(2,'Phones, MP3');
/*!40000 ALTER TABLE `product_type_parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_types`
--

DROP TABLE IF EXISTS `product_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_types` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_TYPE_PART_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `IMAGE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IMAGE_LINK_FK` (`IMAGE_ID`),
  KEY `PRODUCT_TYPE_PART_FK` (`PRODUCT_TYPE_PART_ID`),
  CONSTRAINT `IMAGE_LINK_FK` FOREIGN KEY (`IMAGE_ID`) REFERENCES `images` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_types`
--

LOCK TABLES `product_types` WRITE;
/*!40000 ALTER TABLE `product_types` DISABLE KEYS */;
INSERT INTO `product_types` VALUES (5,'1','Notebooks',7),(6,'1','Computers',8),(7,'1','Tablets',9),(8,'2','Mobile phones',16);
/*!40000 ALTER TABLE `product_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_TYPE_ID` int(11) NOT NULL,
  `BRAND_ID` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `FEATURES_ID` int(11) NOT NULL,
  `PRICE` float DEFAULT NULL,
  `IMAGES_ID` int(11) NOT NULL,
  `AVAILABLE` bit(1) NOT NULL,
  `COMMENTS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PRODUCT_TYPE_FK` (`PRODUCT_TYPE_ID`),
  KEY `BRAND_FK` (`BRAND_ID`),
  CONSTRAINT `BRAND_FK` FOREIGN KEY (`BRAND_ID`) REFERENCES `brands` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PRODUCT_TYPE_FK` FOREIGN KEY (`PRODUCT_TYPE_ID`) REFERENCES `product_types` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (15,5,1,'MacBook Air (MC969RS/A) Silver',999,13907.5,11,'',888),(16,5,2,'Inspiron M5110 (M5110H3500D4C640BSCLblack) Diamond Black',999,4603.01,12,'',888),(17,5,2,'Inspiron N7110 (DI7110I26706750B) Diamond Black',999,7345.03,13,'\0',888),(18,5,3,'VAIO VPCEJ1L1R/W (VPCEJ1L1R/W.RU3) White',999,7127.1,14,'\0',888);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'onlineshop'
--

--
-- Dumping routines for database 'onlineshop'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-11 11:32:44
