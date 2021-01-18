-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: appcampeonato
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `campeonato`
--

DROP TABLE IF EXISTS `campeonato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campeonato` (
  `idCamp` int NOT NULL AUTO_INCREMENT,
  `nomeCamp` varchar(45) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  PRIMARY KEY (`idCamp`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato`
--

LOCK TABLES `campeonato` WRITE;
/*!40000 ALTER TABLE `campeonato` DISABLE KEYS */;
INSERT INTO `campeonato` VALUES (1,'Campeonato da Galera','2020-11-19','2020-12-23');
/*!40000 ALTER TABLE `campeonato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partida` (
  `idPartida` int NOT NULL AUTO_INCREMENT,
  `time1` varchar(45) NOT NULL,
  `time2` varchar(45) NOT NULL,
  `data` date NOT NULL,
  `horario` varchar(45) NOT NULL,
  `estadio` enum('MINEIRAO','MARACANA','BEIRA_RIO','MORUMBI','FONTE_NOVA') NOT NULL,
  `idArbitro` int DEFAULT NULL,
  `idCamp` int DEFAULT NULL,
  PRIMARY KEY (`idPartida`),
  KEY `idPessoa_idx` (`idArbitro`),
  KEY `idcampeonato_idx` (`idCamp`),
  CONSTRAINT `idArbitro` FOREIGN KEY (`idArbitro`) REFERENCES `pessoa` (`idpessoa`),
  CONSTRAINT `idCamp` FOREIGN KEY (`idCamp`) REFERENCES `campeonato` (`idCamp`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
INSERT INTO `partida` VALUES (1,'Cruzeiro','São Paulo','2020-11-23','16:00','MINEIRAO',3,1),(6,'Manchester City','Manchester United','2020-12-12','17:00','BEIRA_RIO',5,1),(7,'Chelsea','Tupi','2020-01-20','17:00','MINEIRAO',12,1),(8,'Cruzeiro','Chelsea','2200-12-12','16:00','MINEIRAO',3,1);
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `idpessoa` int NOT NULL AUTO_INCREMENT,
  `nomePessoa` varchar(45) NOT NULL,
  `tipo` enum('Arbitro','Jogador','Tecnico') NOT NULL,
  `dataNasc` date NOT NULL,
  `sexo` enum('MASCULINO','FEMININO') NOT NULL,
  `altura` double NOT NULL,
  `nacionalidade` varchar(45) NOT NULL,
  `posicaoJogador` enum('GOLEIRO','ZAGUEIRO','LATERAL','MEIA','ATACANTE') DEFAULT NULL,
  `numeroCamisa` int DEFAULT NULL,
  `numRegTecnico` varchar(20) DEFAULT NULL,
  `idTime` int DEFAULT NULL,
  PRIMARY KEY (`idpessoa`),
  KEY `idTime_idx` (`idTime`),
  CONSTRAINT `idTime` FOREIGN KEY (`idTime`) REFERENCES `time` (`idTime`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='R';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Cesar Augusto','Jogador','1997-12-23','MASCULINO',1.75,'Brasileiro','LATERAL',2,NULL,1),(2,'Felipão','Tecnico','1957-12-23','MASCULINO',1.72,'Brasileiro',NULL,NULL,'1921',1),(3,'Daronco','Arbitro','1977-12-23','MASCULINO',1.87,'Brasileiro',NULL,NULL,NULL,NULL),(4,'Jorge','Tecnico','2020-11-01','MASCULINO',1.72,'Brasil',NULL,NULL,'252525',4),(5,'Zezim','Arbitro','2020-11-19','MASCULINO',1.72,'Brasil',NULL,NULL,NULL,NULL),(6,'Fernando Torres','Jogador','1978-11-25','MASCULINO',1.8,'Espanha','ATACANTE',9,NULL,1),(7,'Fernando D.','Tecnico','1985-11-19','MASCULINO',1.68,'Brasil',NULL,NULL,'777',2),(12,'Zezim Gas Ze','Arbitro','2020-11-19','MASCULINO',1.8,'Brasil',NULL,NULL,NULL,NULL),(15,'David Villa','Jogador','1978-11-25','MASCULINO',1.75,'Espanha','ATACANTE',9,NULL,1),(18,'Pelé','Jogador','1940-12-12','MASCULINO',1.75,'Brasil','ATACANTE',10,NULL,2),(21,'Lampard','Tecnico','2020-02-17','MASCULINO',1.75,'Inglaterra',NULL,NULL,'007',8),(23,'Editar','Arbitro','1997-12-23','MASCULINO',1.72,'Brasil',NULL,NULL,NULL,NULL),(24,'Editar','Jogador','2020-12-23','MASCULINO',1.72,'Brasil','GOLEIRO',10,NULL,2);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `idTime` int NOT NULL AUTO_INCREMENT,
  `nomeTime` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `anoFundacao` int NOT NULL,
  `cidade` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `categoria` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idTime`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,'Cruzeiro',1921,'Belo Horizonte','Profissional'),(2,'São Paulo',1930,'São Paulo','Profissional'),(4,'Flamengo',1985,'Rio de Janeiro','Profissional'),(5,'Grêmio',1903,'Porto Alegre','Profissional'),(7,'América-MG',1912,'Belo Horizonte','Profissional'),(8,'Chelsea',1905,'Londres','Profissiona'),(9,'Barcelona',1908,'Barcelona','Profissional'),(12,'Manchester United',1908,'Manchester','Profissional'),(14,'Manchester City',1980,'Manchester','Profissional'),(24,'Real Madrid',1900,'Madrid','Profissional'),(28,'Tupi',1912,'Juiz de Fora','Profissional');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_partida`
--

DROP TABLE IF EXISTS `time_partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_partida` (
  `idPartida` int DEFAULT NULL,
  `idTime` int DEFAULT NULL,
  KEY `idPartida_idx` (`idPartida`),
  KEY `idTime` (`idTime`),
  CONSTRAINT `time_partida_ibfk_1` FOREIGN KEY (`idPartida`) REFERENCES `partida` (`idPartida`),
  CONSTRAINT `time_partida_ibfk_2` FOREIGN KEY (`idTime`) REFERENCES `time` (`idTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_partida`
--

LOCK TABLES `time_partida` WRITE;
/*!40000 ALTER TABLE `time_partida` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Jesus','gracasaeleconsegui','elevive'),(2,'Cesar','cesar','1234567'),(4,'Zezim','zezimgasolina','7654321'),(5,'0','0','0'),(10,'Daves','daves','daves');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-27 18:07:32
