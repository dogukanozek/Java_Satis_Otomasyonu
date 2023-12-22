-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: kullanicilar
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `musteriler`
--

DROP TABLE IF EXISTS `musteriler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musteriler` (
  `idmusteriler` int NOT NULL AUTO_INCREMENT,
  `Ad` varchar(45) DEFAULT NULL,
  `SoyAd` varchar(45) DEFAULT NULL,
  `Sifre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmusteriler`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteriler`
--

LOCK TABLES `musteriler` WRITE;
/*!40000 ALTER TABLE `musteriler` DISABLE KEYS */;
INSERT INTO `musteriler` VALUES (1,'Dogukan','Ozek','dogukan100');
/*!40000 ALTER TABLE `musteriler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siparis_gecmisi`
--

DROP TABLE IF EXISTS `siparis_gecmisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siparis_gecmisi` (
  `MusterıId` int NOT NULL,
  `UrunId` int DEFAULT NULL,
  `Urun_ad` varchar(45) DEFAULT NULL,
  `Urun_adet` int DEFAULT NULL,
  `Musteri_ad` varchar(45) DEFAULT NULL,
  `Musteri_soyad` varchar(45) DEFAULT NULL,
  `Siparis_tarihi` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siparis_gecmisi`
--

LOCK TABLES `siparis_gecmisi` WRITE;
/*!40000 ALTER TABLE `siparis_gecmisi` DISABLE KEYS */;
INSERT INTO `siparis_gecmisi` VALUES (0,2,'asdasdasd',30,'','','1970-01-01 00:00:00'),(1,2,'asdasdasd',80,'asdasd','dsadasdasdsadsa','2023-12-07 00:00:00'),(1,2,'asdasdasd',50,'dsfsdfsd','sdfsdfsdf','2023-12-08 00:00:00'),(1,2,'asdasdasd',12,'dsfsdfsd','sdfsdfsdf','2023-12-08 00:00:00'),(2,2,'asdasdasd',13,'dsfsdfsdasdasdas','sdfsdfsdfdasdasdasdasda','2023-12-09 00:00:00');
/*!40000 ALTER TABLE `siparis_gecmisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urunler`
--

DROP TABLE IF EXISTS `urunler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urunler` (
  `İd` int NOT NULL AUTO_INCREMENT,
  `Urun_ad` varchar(45) DEFAULT NULL,
  `Urun_stok` int DEFAULT NULL,
  `Urun_kategori` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`İd`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urunler`
--

LOCK TABLES `urunler` WRITE;
/*!40000 ALTER TABLE `urunler` DISABLE KEYS */;
INSERT INTO `urunler` VALUES (2,'Fare',30,'Elektronik'),(3,'Bardak',50,'Mutfak'),(4,'Çip',100,'Elektronik');
/*!40000 ALTER TABLE `urunler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonetici_hesaplari`
--

DROP TABLE IF EXISTS `yonetici_hesaplari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yonetici_hesaplari` (
  `idYonetici_Hesaplari` int NOT NULL AUTO_INCREMENT,
  `Ad` varchar(45) DEFAULT NULL,
  `SoyAd` varchar(45) DEFAULT NULL,
  `Sifre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idYonetici_Hesaplari`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonetici_hesaplari`
--

LOCK TABLES `yonetici_hesaplari` WRITE;
/*!40000 ALTER TABLE `yonetici_hesaplari` DISABLE KEYS */;
INSERT INTO `yonetici_hesaplari` VALUES (1,'asdasdsadasd','asdasdsadasdasdsadas','dasdasdasdsadasdasdasdasdasd'),(2,'asdasdsadasdsadasdsad','asdasdsadasdasdsadasasdsadsadasd','dasdasdasdsadasdasdasdasdasasdasdasdasdasdd'),(3,'Dogukan','Ozek','dogukan10');
/*!40000 ALTER TABLE `yonetici_hesaplari` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-22 17:17:13
