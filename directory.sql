-- MySQL dump 10.13  Distrib 5.6.27, for Linux (x86_64)
--
-- Host: localhost    Database: directory
-- ------------------------------------------------------
-- Server version	5.6.27

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
-- Table structure for table `base_path`
--

DROP TABLE IF EXISTS `base_path`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_path` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(200) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `path` (`path`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_path`
--

LOCK TABLES `base_path` WRITE;
/*!40000 ALTER TABLE `base_path` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_path` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_log`
--

DROP TABLE IF EXISTS `system_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `op_user` bigint(20) DEFAULT NULL,
  `data_type` int(11) DEFAULT NULL,
  `data_id` varchar(100) DEFAULT NULL,
  `op_type` int(11) DEFAULT NULL,
  `log_describe` varchar(1000) DEFAULT NULL,
  `op_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6457 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_log`
--

LOCK TABLES `system_log` WRITE;
/*!40000 ALTER TABLE `system_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_file`
--

DROP TABLE IF EXISTS `task_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` bigint(20) NOT NULL,
  `source_Path` varchar(200) NOT NULL,
  `dest_Path` varchar(200) NOT NULL,
  `length` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_file`
--

LOCK TABLES `task_file` WRITE;
/*!40000 ALTER TABLE `task_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_file`
--

DROP TABLE IF EXISTS `transfer_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer_file` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` bigint(20) NOT NULL,
  `source_Path` varchar(200) NOT NULL,
  `dest_Path` varchar(200) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `retry` int(11) NOT NULL DEFAULT '0',
  `t_lock` int(11) NOT NULL DEFAULT '0',
  `t_status` int(11) NOT NULL DEFAULT '0',
  `executionTime` datetime DEFAULT NULL,
  `length` bigint(20) DEFAULT NULL,
  `copylength` bigint(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2862 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_file`
--

LOCK TABLES `transfer_file` WRITE;
/*!40000 ALTER TABLE `transfer_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_task`
--

DROP TABLE IF EXISTS `transfer_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  `task_name` varchar(200) DEFAULT NULL,
  `user_account` varchar(500) DEFAULT NULL,
  `retry` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=810 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_task`
--

LOCK TABLES `transfer_task` WRITE;
/*!40000 ALTER TABLE `transfer_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_folder`
--

DROP TABLE IF EXISTS `user_folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_folder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  `rw` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_folder`
--

LOCK TABLES `user_folder` WRITE;
/*!40000 ALTER TABLE `user_folder` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `expire` datetime NOT NULL,
  `create_date` datetime NOT NULL,
  `yn` int(11) NOT NULL DEFAULT '0',
  `role` int(11) NOT NULL,
  `is_auto_transfer` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'admin','F379EAF3C831B04DE153469D1BEC345E','admin','18600959107','文档管理','文档管理','3950-02-01 00:00:00','2015-12-22 09:58:38',1,1,1);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-03 15:39:57
