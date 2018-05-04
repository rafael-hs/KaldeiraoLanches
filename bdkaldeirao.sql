-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: bdkaldeirao
-- ------------------------------------------------------
-- Server version	5.6.22

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(45) NOT NULL,
  `cpfCliente` varchar(45) DEFAULT NULL,
  `celularCliente` varchar(45) DEFAULT NULL,
  `telefoneCliente` varchar(45) NOT NULL,
  `nascCliente` date NOT NULL,
  `idClienteEndereco` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`),
  UNIQUE KEY `telefoneCliente_UNIQUE` (`telefoneCliente`),
  UNIQUE KEY `cpfCliente_UNIQUE` (`cpfCliente`),
  UNIQUE KEY `celularCliente_UNIQUE` (`celularCliente`),
  KEY `fk_Cliente_Endereco1_idx` (`idClienteEndereco`),
  CONSTRAINT `fk_Cliente_Endereco1` FOREIGN KEY (`idClienteEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,'gabriel','14629676416','997027386','32568973','1996-05-26',5),(4,'rafael','0','0','99875948','1998-05-14',6),(6,'joao','00000000000','998567343','33568594','1996-05-26',8);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comanda` (
  `idPedido` int(11) NOT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `obsProduto` varchar(45) DEFAULT NULL,
  KEY `fk_Pedido_has_Produto_Produto1_idx` (`idProduto`),
  KEY `fk_Pedido_has_Produto_Pedido1_idx` (`idPedido`),
  CONSTRAINT `fk_Pedido_has_Produto_Pedido1` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Pedido_has_Produto_Produto1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
INSERT INTO `comanda` VALUES (24,1,'fdasasdfasdf'),(24,2,'bife,alface,tomate,batata palha,bacon.'),(24,2,'bife,alface,tomate,batata palha,bacon.');
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `ruaEndereco` varchar(45) NOT NULL,
  `bairroEndereco` varchar(45) NOT NULL,
  `cepEndereco` varchar(45) NOT NULL,
  `cidadeEndereco` varchar(45) NOT NULL,
  `nDaCasaEndereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (3,'sopadkasdop','asopaskokop','2978456','zxm,nmzxc',41),(4,'bhashdsah','sduahusdahu','23568975','sdkoaasd',98),(5,'belao','arru','29120258','vilao',25),(6,'chu','cdra','29000258','vila velhao',85),(8,'belao','arru','29120258','vilao',25);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` varchar(45) NOT NULL,
  `cpfFuncionario` varchar(45) DEFAULT NULL,
  `celularFuncionario` varchar(45) DEFAULT NULL,
  `telefoneFuncionario` varchar(45) NOT NULL,
  `nascFuncionario` date NOT NULL,
  `idFuncionarioEndereco` int(11) NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `idFuncionario_UNIQUE` (`idFuncionario`),
  UNIQUE KEY `telefoneFuncionario_UNIQUE` (`telefoneFuncionario`),
  UNIQUE KEY `celularFuncionario_UNIQUE` (`celularFuncionario`),
  UNIQUE KEY `cpfFuncionario_UNIQUE` (`cpfFuncionario`),
  KEY `fk_Funcionario_Endereco1_idx` (`idFuncionarioEndereco`),
  CONSTRAINT `fk_Funcionario_Endereco1` FOREIGN KEY (`idFuncionarioEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'luigi','15748946814','998562345','32457896','1996-05-14',3),(2,'mario','14578965217','997254686','32567319','1996-05-18',4);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `nomePedido` varchar(45) DEFAULT NULL,
  `precoPedido` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `dataPedido` date DEFAULT NULL,
  `horaPedido` time(5) DEFAULT NULL,
  `statusPedido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPedido`),
  UNIQUE KEY `idPedido_UNIQUE` (`idPedido`),
  KEY `fk_Pedido_Cliente1_idx` (`idCliente`),
  KEY `fk_Pedido_Funcionario1_idx` (`idFuncionario`),
  CONSTRAINT `fk_Pedido_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Pedido_Funcionario1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (24,NULL,'0.0',4,2,'2015-07-02','14:45:00.00000','Em Aberto');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProduto` varchar(45) NOT NULL,
  `precoProduto` decimal(10,2) NOT NULL,
  `numProduto` int(11) NOT NULL,
  `descricaoProduto` varchar(45) NOT NULL,
  PRIMARY KEY (`idProduto`),
  UNIQUE KEY `numProduto_UNIQUE` (`numProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'asdffasd',5.99,1,'fdasasdfasdf'),(2,'x-tudo',8.99,2,'bife,alface,tomate,batata palha,bacon.');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-02 15:28:09
