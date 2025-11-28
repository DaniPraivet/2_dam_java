-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: instituto
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `carnet_conducir` tinyint DEFAULT NULL,
  `estado_matricula` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `direccion` varchar(200) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Juan Pérez',1,'Matriculado','Calle Falsa 123, Madrid'),(2,'Lucía Gómez',0,'Pendiente','Av. del Sol 45, Valencia'),(3,'Carlos Ruiz',1,'Matriculado','Calle Luna 78, Barcelona'),(4,'María López',1,'Matriculado','Paseo del Río 22, Sevilla'),(5,'Jorge Fernández',0,'Baja','Calle Jardín 15, Bilbao'),(6,'Elena Martínez',1,'Matriculado','Av. del Mar 89, Málaga'),(7,'Andrés Torres',0,'Pendiente','Calle Norte 101, Zaragoza'),(8,'Sandra Díaz',1,'Matriculado','Camino Real 33, Granada'),(9,'Pablo Navarro',0,'Baja','Calle Sur 66, Valladolid'),(10,'Natalia Romero',1,'Matriculado','Plaza Mayor 9, Alicante');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignatura` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `curso` smallint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,'Matemáticas I',1),(2,'Lengua Española',1),(3,'Historia Universal',2),(4,'Física',2),(5,'Química',2),(6,'Inglés Avanzado',3),(7,'Programación',3),(8,'Biología',1),(9,'Educación Física',1),(10,'Filosofía',2);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_alumno` int unsigned DEFAULT NULL,
  `id_asignatura` int unsigned DEFAULT NULL,
  `nota` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_alumno` (`id_alumno`),
  KEY `id_asignatura` (`id_asignatura`),
  CONSTRAINT `matricula_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id`),
  CONSTRAINT `matricula_ibfk_2` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,1,1,8.5),(2,1,2,7),(3,1,3,6.5),(4,1,4,9),(5,1,5,7.8),(6,2,1,5.5),(7,2,6,8.2),(8,2,7,6.9),(9,2,8,7.3),(10,2,9,9.1),(11,3,2,7.5),(12,3,3,6),(13,3,4,8),(14,3,5,5.9),(15,3,10,8.7),(16,4,1,9.2),(17,4,5,7.5),(18,4,6,6.4),(19,4,8,8.1),(20,4,10,9),(21,5,2,6.8),(22,5,3,5.5),(23,5,7,7.6),(24,5,8,6),(25,5,9,8.3),(26,6,4,7.7),(27,6,5,6.9),(28,6,6,9),(29,6,9,8.5),(30,6,10,7.1),(31,7,1,6.2),(32,7,3,7.4),(33,7,4,5.6),(34,7,6,6.7),(35,7,8,8.8),(36,8,2,8),(37,8,4,7.2),(38,8,5,6.1),(39,8,9,7.9),(40,8,10,8.4),(41,9,3,6.3),(42,9,5,8.6),(43,9,6,7),(44,9,7,7.3),(45,9,10,9.5),(46,10,1,5.8),(47,10,2,7.9),(48,10,8,6.6),(49,10,9,8.2),(50,10,10,7.7);
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `contrasena` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

-- Dump completed on 2025-11-28 17:58:09
