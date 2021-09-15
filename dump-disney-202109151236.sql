-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: disney
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `imagen` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Romance','/desktop/Romance.png'),(2,'Terror','/desktop/Terror.png'),(3,'Comedia','/desktop/Comedia.png');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie`
--

DROP TABLE IF EXISTS `pelicula_serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imagen` varchar(500) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `calificacion` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie`
--

LOCK TABLES `pelicula_serie` WRITE;
/*!40000 ALTER TABLE `pelicula_serie` DISABLE KEYS */;
INSERT INTO `pelicula_serie` VALUES (2,'/desktop/simpsons.png','Los simpsons','1909-09-21',7);
/*!40000 ALTER TABLE `pelicula_serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie_genero`
--

DROP TABLE IF EXISTS `pelicula_serie_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie_genero` (
  `id_pelicula_serie` int DEFAULT NULL,
  `id_genero` int DEFAULT NULL,
  KEY `pelicula_serie_genero_FK` (`id_genero`),
  KEY `pelicula_serie_genero_FK_1` (`id_pelicula_serie`),
  CONSTRAINT `pelicula_serie_genero_FK` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id`),
  CONSTRAINT `pelicula_serie_genero_FK_1` FOREIGN KEY (`id_pelicula_serie`) REFERENCES `pelicula_serie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie_genero`
--

LOCK TABLES `pelicula_serie_genero` WRITE;
/*!40000 ALTER TABLE `pelicula_serie_genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `pelicula_serie_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie_personaje`
--

DROP TABLE IF EXISTS `pelicula_serie_personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie_personaje` (
  `id_personaje` int DEFAULT NULL,
  `id_pelicula_serie` int DEFAULT NULL,
  KEY `pelicula_serie_personaje_FK` (`id_personaje`),
  KEY `pelicula_serie_personaje_FK_1` (`id_pelicula_serie`),
  CONSTRAINT `pelicula_serie_personaje_FK` FOREIGN KEY (`id_personaje`) REFERENCES `personaje` (`id`),
  CONSTRAINT `pelicula_serie_personaje_FK_1` FOREIGN KEY (`id_pelicula_serie`) REFERENCES `pelicula_serie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie_personaje`
--

LOCK TABLES `pelicula_serie_personaje` WRITE;
/*!40000 ALTER TABLE `pelicula_serie_personaje` DISABLE KEYS */;
INSERT INTO `pelicula_serie_personaje` VALUES (25,2),(26,2),(28,2);
/*!40000 ALTER TABLE `pelicula_serie_personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `imagen` varchar(500) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `historia` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (3,'Hola','/tmp/asd.png',32,56,'personaje de aventuras'),(4,'ricardo','desktop/ricardo.png',18,51,'personaje de aventuras'),(24,'asd','/tmp/hola.png',32,56,'personaje de aventuras'),(25,'Gustavo','/tmp/Gustavo.png',11,38,'personaje de aventuras'),(26,'Cristobal','/tmp/cristobalpower.png',41,70,'personaje de accion'),(28,'Ricardo','desktop/ricardo.png',18,60,'personaje de ficcion');
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mail` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `contraseña` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'albarezlucas99@gmail.com','423'),(6,'ejemplo@gmail.com','12345');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'disney'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-15 12:36:52
