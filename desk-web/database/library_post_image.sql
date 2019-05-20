-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `post_image`
--

DROP TABLE IF EXISTS `post_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `post_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `belong_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_image`
--

LOCK TABLES `post_image` WRITE;
/*!40000 ALTER TABLE `post_image` DISABLE KEYS */;
INSERT INTO `post_image` VALUES (1,'http://172.16.63.1:8080/photo/S90429-111229.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90429-111229.jpg',2),(2,'http://172.16.63.1:8080/photo/S90410-112748.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90410-112748.jpg',3),(3,'http://172.16.63.1:8080/photo/S90406-140103.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90406-140103.jpg',3),(4,'http://172.16.63.1:8080/photo/shareimage.jpg','#l#m#s','http://192.168.0.115:8080/photo/shareimage.jpg',3),(5,'http://172.16.63.1:8080/photo/S90406-141746.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90406-141746.jpg',3),(6,'http://172.16.63.1:8080/photo/Photoplus.jpg','#l#m#s','http://192.168.0.115:8080/photo/Photoplus.jpg',3),(7,'http://172.16.63.1:8080/photo/S90408-225955.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90408-225955.jpg',3),(8,'http://172.16.63.1:8080/photo/S90409-105956.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90409-105956.jpg',3),(9,'http://172.16.63.1:8080/photo/652666256.jpg','#l#m#s','http://192.168.0.115:8080/photo/652666256.jpg',3),(10,'http://172.16.63.1:8080/photo/S90406-140035.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90406-140035.jpg',3),(11,'http://172.16.63.1:8080/photo/S90503-143521.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90503-143521.jpg',4),(12,'http://172.16.63.1:8080/photo/S90503-143817.jpg','#l#m#s','http://192.168.0.115:8080/photo/S90503-143817.jpg',4),(13,'http://172.16.63.1:8080/photo/1558267210606.jpg','#l#m#s','http://192.168.0.115:8080/photo/1558267210606.jpg',5);
/*!40000 ALTER TABLE `post_image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-20 11:42:49
