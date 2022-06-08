CREATE DATABASE  IF NOT EXISTS `workix` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `workix`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: workix
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

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
-- Table structure for table `Author`
--

DROP TABLE IF EXISTS `Author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Author` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `aboutText` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Author`
--

LOCK TABLES `Author` WRITE;
/*!40000 ALTER TABLE `Author` DISABLE KEYS */;
INSERT INTO `Author` (`id`, `createdAt`, `updatedAt`, `uuid`, `version`, `aboutText`, `name`, `picture`) VALUES (201,'2018-08-03 15:10:47',NULL,'395eb6de-933d-4429-90f7-7c3d4d2494b6',0,'Sobre o Autor 0','Autor \'Mockup\' 1','http://localhost/resources/placeholder/140x140.jpg'),(202,'2018-08-03 15:10:47',NULL,'675dd566-893a-406f-b041-f5f118ad8496',0,'Sobre o Autor 1','Autor \'Mockup\' 2','http://localhost/resources/placeholder/140x140.jpg'),(203,'2018-08-03 15:10:47',NULL,'d2975e2b-5398-44fa-9fb1-23e677d1a2c3',0,'Sobre o Autor 2','Autor \'Mockup\' 3','http://localhost/resources/placeholder/140x140.jpg'),(204,'2018-08-03 15:10:47',NULL,'fc926ccc-db41-415d-9043-9d047c7c86df',0,'Sobre o Autor 3','Autor \'Mockup\' 4','http://localhost/resources/placeholder/140x140.jpg'),(205,'2018-08-03 15:10:47',NULL,'34498ed8-bcec-4460-b3fb-21acae9ccc4b',0,'Sobre o Autor 4','Autor \'Mockup\' 5','http://localhost/resources/placeholder/140x140.jpg'),(206,'2018-08-03 15:10:47',NULL,'c541f222-1602-48a7-9218-7c947ee7523e',0,'Sobre o Autor 5','Autor \'Mockup\' 6','http://localhost/resources/placeholder/140x140.jpg'),(207,'2018-08-03 15:10:47',NULL,'faa84efa-9148-43fb-98dc-4bd5577ead64',0,'Sobre o Autor 6','Autor \'Mockup\' 7','http://localhost/resources/placeholder/140x140.jpg'),(208,'2018-08-03 15:10:47',NULL,'d97d944a-db5f-4c15-b5ab-a4f9283622b7',0,'Sobre o Autor 7','Autor \'Mockup\' 8','http://localhost/resources/placeholder/140x140.jpg'),(209,'2018-08-03 15:10:47',NULL,'dccc9389-0a6a-4f44-ae8d-9266ade5397d',0,'Sobre o Autor 8','Autor \'Mockup\' 9','http://localhost/resources/placeholder/140x140.jpg'),(210,'2018-08-03 15:10:48',NULL,'6d34ee02-ac64-4d2e-a0d9-de2094de2904',0,'Sobre o Autor 9','Autor \'Mockup\' 10','http://localhost/resources/placeholder/140x140.jpg'),(211,'2018-08-03 15:10:48',NULL,'ce1a138c-d6d9-4135-a98c-a0d7bea301f1',0,'Sobre o Autor 10','Autor \'Mockup\' 11','http://localhost/resources/placeholder/140x140.jpg'),(212,'2018-08-03 15:10:48',NULL,'dc196258-b4a2-47df-81bf-f53291d3909b',0,'Sobre o Autor 11','Autor \'Mockup\' 12','http://localhost/resources/placeholder/140x140.jpg'),(213,'2018-08-03 15:10:48',NULL,'963a1bc3-dd53-4d0e-8eb3-f5f0786a800a',0,'Sobre o Autor 12','Autor \'Mockup\' 13','http://localhost/resources/placeholder/140x140.jpg'),(214,'2018-08-03 15:10:48',NULL,'a12701b5-547e-45a1-a4cc-e74400e84cbd',0,'Sobre o Autor 13','Autor \'Mockup\' 14','http://localhost/resources/placeholder/140x140.jpg'),(215,'2018-08-03 15:10:48',NULL,'4619cf92-520c-4733-b7da-cbe81fffdf97',0,'Sobre o Autor 14','Autor \'Mockup\' 15','http://localhost/resources/placeholder/140x140.jpg'),(216,'2018-08-03 15:10:48',NULL,'06a74dcf-a32f-432d-90a9-70fc4e7ad26c',0,'Sobre o Autor 15','Autor \'Mockup\' 16','http://localhost/resources/placeholder/140x140.jpg'),(217,'2018-08-03 15:10:48',NULL,'319ee771-0e02-49f3-a6a6-8834349ca443',0,'Sobre o Autor 16','Autor \'Mockup\' 17','http://localhost/resources/placeholder/140x140.jpg'),(218,'2018-08-03 15:10:48',NULL,'4761852a-d0ed-4484-af04-aa47c332d5bc',0,'Sobre o Autor 17','Autor \'Mockup\' 18','http://localhost/resources/placeholder/140x140.jpg'),(219,'2018-08-03 15:10:48',NULL,'716ef7e5-46f1-4bbd-b582-271a2c23638a',0,'Sobre o Autor 18','Autor \'Mockup\' 19','http://localhost/resources/placeholder/140x140.jpg'),(220,'2018-08-03 15:10:48',NULL,'64e57417-7d46-485a-a837-b5222d6e1f45',0,'Sobre o Autor 19','Autor \'Mockup\' 20','http://localhost/resources/placeholder/140x140.jpg'),(221,'2018-08-03 15:10:48',NULL,'b1a194a5-dafd-4f14-aecd-46d0f7e236a0',0,'Sobre o Autor 20','Autor \'Mockup\' 21','http://localhost/resources/placeholder/140x140.jpg'),(222,'2018-08-03 15:10:48',NULL,'4be51aaf-d395-4eee-9c87-f11f3a427df9',0,'Sobre o Autor 21','Autor \'Mockup\' 22','http://localhost/resources/placeholder/140x140.jpg'),(223,'2018-08-03 15:10:49',NULL,'d13c9439-80fc-489c-a4c5-f4438548dd5b',0,'Sobre o Autor 22','Autor \'Mockup\' 23','http://localhost/resources/placeholder/140x140.jpg'),(224,'2018-08-03 15:10:49',NULL,'344f4b5f-2625-4e63-87e5-36fabcecdc97',0,'Sobre o Autor 23','Autor \'Mockup\' 24','http://localhost/resources/placeholder/140x140.jpg'),(225,'2018-08-03 15:10:49',NULL,'b4f2b37a-973e-4451-9d03-0fd3596f9b72',0,'Sobre o Autor 24','Autor \'Mockup\' 25','http://localhost/resources/placeholder/140x140.jpg'),(226,'2018-08-03 15:10:49',NULL,'c6e3a63e-15d6-4c5c-9d2d-581856616b6e',0,'Sobre o Autor 25','Autor \'Mockup\' 26','http://localhost/resources/placeholder/140x140.jpg'),(227,'2018-08-03 15:10:49',NULL,'9579fd03-0b1b-448e-b298-b71b62650ad0',0,'Sobre o Autor 26','Autor \'Mockup\' 27','http://localhost/resources/placeholder/140x140.jpg'),(228,'2018-08-03 15:10:49',NULL,'87d489ca-2340-45b4-8b58-6e4c52e318b5',0,'Sobre o Autor 27','Autor \'Mockup\' 28','http://localhost/resources/placeholder/140x140.jpg'),(229,'2018-08-03 15:10:49',NULL,'c03af399-7b60-45b1-86d1-ab60a29c175c',0,'Sobre o Autor 28','Autor \'Mockup\' 29','http://localhost/resources/placeholder/140x140.jpg'),(230,'2018-08-03 15:10:49',NULL,'b5dbca95-1c85-46d0-81ed-bccc45a3c90f',0,'Sobre o Autor 29','Autor \'Mockup\' 30','http://localhost/resources/placeholder/140x140.jpg'),(231,'2018-08-03 15:10:49',NULL,'8b33f21a-f2a0-4a07-b3f3-6e8ab3a50cb0',0,'Sobre o Autor 30','Autor \'Mockup\' 31','http://localhost/resources/placeholder/140x140.jpg'),(232,'2018-08-03 15:10:49',NULL,'7d0c69b7-32d6-4a92-bbf1-3e24acc93648',0,'Sobre o Autor 31','Autor \'Mockup\' 32','http://localhost/resources/placeholder/140x140.jpg'),(233,'2018-08-03 15:10:49',NULL,'a4007a67-0db1-485c-9563-b37d06ad4650',0,'Sobre o Autor 32','Autor \'Mockup\' 33','http://localhost/resources/placeholder/140x140.jpg'),(234,'2018-08-03 15:10:49',NULL,'631b24a8-0050-4d34-af96-b82cd37e874e',0,'Sobre o Autor 33','Autor \'Mockup\' 34','http://localhost/resources/placeholder/140x140.jpg'),(235,'2018-08-03 15:10:49',NULL,'3e591c44-387a-45da-b857-1d3b994bb00a',0,'Sobre o Autor 34','Autor \'Mockup\' 35','http://localhost/resources/placeholder/140x140.jpg'),(236,'2018-08-03 15:10:49',NULL,'6da83149-458b-4033-a681-9f53c1317412',0,'Sobre o Autor 35','Autor \'Mockup\' 36','http://localhost/resources/placeholder/140x140.jpg'),(237,'2018-08-03 15:10:50',NULL,'53e9770a-07bb-40ef-b0b1-eadd85e8903d',0,'Sobre o Autor 36','Autor \'Mockup\' 37','http://localhost/resources/placeholder/140x140.jpg'),(238,'2018-08-03 15:10:50',NULL,'dde9622f-e94c-490b-accf-6747e77ca1e7',0,'Sobre o Autor 37','Autor \'Mockup\' 38','http://localhost/resources/placeholder/140x140.jpg'),(239,'2018-08-03 15:10:50',NULL,'91f87b8d-be1f-4485-8d2a-34da61e243fc',0,'Sobre o Autor 38','Autor \'Mockup\' 39','http://localhost/resources/placeholder/140x140.jpg'),(240,'2018-08-03 15:10:50',NULL,'c5a9b738-206f-42b2-a7bc-9266c5d21aad',0,'Sobre o Autor 39','Autor \'Mockup\' 40','http://localhost/resources/placeholder/140x140.jpg'),(241,'2018-08-03 15:10:50',NULL,'7773e3f8-9d23-47c7-9609-e760a01534a9',0,'Sobre o Autor 40','Autor \'Mockup\' 41','http://localhost/resources/placeholder/140x140.jpg'),(242,'2018-08-03 15:10:50',NULL,'f5c1b953-9801-4e7f-a648-3b97a7a27d6f',0,'Sobre o Autor 41','Autor \'Mockup\' 42','http://localhost/resources/placeholder/140x140.jpg'),(243,'2018-08-03 15:10:50',NULL,'51f662e3-82a9-4ebb-9464-9a2c69dda945',0,'Sobre o Autor 42','Autor \'Mockup\' 43','http://localhost/resources/placeholder/140x140.jpg'),(244,'2018-08-03 15:10:50',NULL,'c4383a82-5e13-4f97-8c51-07bc90e4865a',0,'Sobre o Autor 43','Autor \'Mockup\' 44','http://localhost/resources/placeholder/140x140.jpg'),(245,'2018-08-03 15:10:50',NULL,'ef9d345e-e3a0-4cd7-bab2-4a8465c481fc',0,'Sobre o Autor 44','Autor \'Mockup\' 45','http://localhost/resources/placeholder/140x140.jpg'),(246,'2018-08-03 15:10:50',NULL,'1b343319-6fec-4b08-948a-554e78e6603d',0,'Sobre o Autor 45','Autor \'Mockup\' 46','http://localhost/resources/placeholder/140x140.jpg'),(247,'2018-08-03 15:10:50',NULL,'eee014ad-1b55-4e15-a261-d4bc4ef55b0e',0,'Sobre o Autor 46','Autor \'Mockup\' 47','http://localhost/resources/placeholder/140x140.jpg'),(248,'2018-08-03 15:10:50',NULL,'e0a9c957-f3a4-4715-a65b-c6099e4c1f1b',0,'Sobre o Autor 47','Autor \'Mockup\' 48','http://localhost/resources/placeholder/140x140.jpg'),(249,'2018-08-03 15:10:50',NULL,'066fca54-4e62-4691-b6d7-280c8ff1e613',0,'Sobre o Autor 48','Autor \'Mockup\' 49','http://localhost/resources/placeholder/140x140.jpg'),(250,'2018-08-03 15:10:51',NULL,'2b111292-9291-44af-8e6a-3343b1530a0a',0,'Sobre o Autor 49','Autor \'Mockup\' 50','http://localhost/resources/placeholder/140x140.jpg'),(251,'2018-08-03 15:10:51',NULL,'de121dd2-1985-4c64-99a6-6fdd27f9d598',0,'Sobre o Autor 50','Autor \'Mockup\' 51','http://localhost/resources/placeholder/140x140.jpg'),(252,'2018-08-03 15:10:51',NULL,'96b16dba-9999-4294-b901-7c1440b8ffc6',0,'Sobre o Autor 51','Autor \'Mockup\' 52','http://localhost/resources/placeholder/140x140.jpg'),(253,'2018-08-03 15:10:51',NULL,'2a6cc02f-2e00-48d7-9837-ee812c9c5bd9',0,'Sobre o Autor 52','Autor \'Mockup\' 53','http://localhost/resources/placeholder/140x140.jpg'),(254,'2018-08-03 15:10:51',NULL,'6616baf0-88f1-42f8-9a97-cf151b2d34fa',0,'Sobre o Autor 53','Autor \'Mockup\' 54','http://localhost/resources/placeholder/140x140.jpg'),(255,'2018-08-03 15:10:51',NULL,'31a84dc5-0ab4-4e31-b28d-74850bc09280',0,'Sobre o Autor 54','Autor \'Mockup\' 55','http://localhost/resources/placeholder/140x140.jpg'),(256,'2018-08-03 15:10:51',NULL,'07c80539-276c-42fb-b698-62a08bb4da4c',0,'Sobre o Autor 55','Autor \'Mockup\' 56','http://localhost/resources/placeholder/140x140.jpg'),(257,'2018-08-03 15:10:51',NULL,'393b8358-c01b-45f6-86d3-8206afdb947c',0,'Sobre o Autor 56','Autor \'Mockup\' 57','http://localhost/resources/placeholder/140x140.jpg'),(258,'2018-08-03 15:10:51',NULL,'dadd430f-6db8-4115-b0b6-5024e27c690a',0,'Sobre o Autor 57','Autor \'Mockup\' 58','http://localhost/resources/placeholder/140x140.jpg'),(259,'2018-08-03 15:10:51',NULL,'07cb80de-912a-4cef-9c4c-e76314f27a80',0,'Sobre o Autor 58','Autor \'Mockup\' 59','http://localhost/resources/placeholder/140x140.jpg'),(260,'2018-08-03 15:10:51',NULL,'d9f01094-6bbd-4c29-bd20-e84f8ccff694',0,'Sobre o Autor 59','Autor \'Mockup\' 60','http://localhost/resources/placeholder/140x140.jpg'),(261,'2018-08-03 15:10:51',NULL,'83a135ac-4f67-40d6-9b2f-8e0b8e374752',0,'Sobre o Autor 60','Autor \'Mockup\' 61','http://localhost/resources/placeholder/140x140.jpg'),(262,'2018-08-03 15:10:51',NULL,'d1a19ce2-e596-4e48-9af8-27767ab74f27',0,'Sobre o Autor 61','Autor \'Mockup\' 62','http://localhost/resources/placeholder/140x140.jpg'),(263,'2018-08-03 15:10:52',NULL,'dcd49ade-50c4-47d1-8b86-19cc010f3e8d',0,'Sobre o Autor 62','Autor \'Mockup\' 63','http://localhost/resources/placeholder/140x140.jpg'),(264,'2018-08-03 15:10:52',NULL,'a748d4c4-b37e-453b-b9a9-5ebbd0f5677f',0,'Sobre o Autor 63','Autor \'Mockup\' 64','http://localhost/resources/placeholder/140x140.jpg'),(265,'2018-08-03 15:10:52',NULL,'2c23b61a-e2bd-4055-9697-f566b00c8a27',0,'Sobre o Autor 64','Autor \'Mockup\' 65','http://localhost/resources/placeholder/140x140.jpg'),(266,'2018-08-03 15:10:52',NULL,'f4770045-651e-4760-bc23-0b5d2c26cce3',0,'Sobre o Autor 65','Autor \'Mockup\' 66','http://localhost/resources/placeholder/140x140.jpg'),(267,'2018-08-03 15:10:52',NULL,'880025b9-d74e-4706-90c1-e76767d8c7ac',0,'Sobre o Autor 66','Autor \'Mockup\' 67','http://localhost/resources/placeholder/140x140.jpg'),(268,'2018-08-03 15:10:52',NULL,'f2effea0-6879-426e-be41-54a90b688cb1',0,'Sobre o Autor 67','Autor \'Mockup\' 68','http://localhost/resources/placeholder/140x140.jpg'),(269,'2018-08-03 15:10:52',NULL,'02c8162d-6e69-436d-a9a8-59d92fc881c0',0,'Sobre o Autor 68','Autor \'Mockup\' 69','http://localhost/resources/placeholder/140x140.jpg'),(270,'2018-08-03 15:10:52',NULL,'9dc39396-25ba-44a1-bab5-7ec60c4b774d',0,'Sobre o Autor 69','Autor \'Mockup\' 70','http://localhost/resources/placeholder/140x140.jpg'),(271,'2018-08-03 15:10:52',NULL,'43538a2b-49fb-4a68-8ea5-d2e3a01bee51',0,'Sobre o Autor 70','Autor \'Mockup\' 71','http://localhost/resources/placeholder/140x140.jpg'),(272,'2018-08-03 15:10:52',NULL,'608b86b8-d9fb-4ba5-8729-920fa50a0685',0,'Sobre o Autor 71','Autor \'Mockup\' 72','http://localhost/resources/placeholder/140x140.jpg'),(273,'2018-08-03 15:10:52',NULL,'773eace1-45d8-4b7b-b1e6-f570eb8b5a0c',0,'Sobre o Autor 72','Autor \'Mockup\' 73','http://localhost/resources/placeholder/140x140.jpg'),(274,'2018-08-03 15:10:52',NULL,'12748f2b-4898-42fc-977d-8412dcbe1828',0,'Sobre o Autor 73','Autor \'Mockup\' 74','http://localhost/resources/placeholder/140x140.jpg'),(275,'2018-08-03 15:10:52',NULL,'bda63240-0476-479f-8f8b-afd952c01eee',0,'Sobre o Autor 74','Autor \'Mockup\' 75','http://localhost/resources/placeholder/140x140.jpg'),(276,'2018-08-03 15:10:52',NULL,'7645038d-c91c-4d4a-9cba-9e0982d8df7c',0,'Sobre o Autor 75','Autor \'Mockup\' 76','http://localhost/resources/placeholder/140x140.jpg'),(277,'2018-08-03 15:10:53',NULL,'44ee3d89-fdc0-4b76-bd36-c1778805d16b',0,'Sobre o Autor 76','Autor \'Mockup\' 77','http://localhost/resources/placeholder/140x140.jpg'),(278,'2018-08-03 15:10:53',NULL,'bb836ae5-bfd4-4833-9b53-0c68ecf002eb',0,'Sobre o Autor 77','Autor \'Mockup\' 78','http://localhost/resources/placeholder/140x140.jpg'),(279,'2018-08-03 15:10:53',NULL,'34d33f1b-f3c0-4b5e-9ab7-a9cdc977c3d5',0,'Sobre o Autor 78','Autor \'Mockup\' 79','http://localhost/resources/placeholder/140x140.jpg'),(280,'2018-08-03 15:10:53',NULL,'16864aeb-7e57-4abd-b9b1-0049a534c474',0,'Sobre o Autor 79','Autor \'Mockup\' 80','http://localhost/resources/placeholder/140x140.jpg'),(281,'2018-08-03 15:10:53',NULL,'d7d4a1bf-74ba-4b76-93c9-06ee9be08d20',0,'Sobre o Autor 80','Autor \'Mockup\' 81','http://localhost/resources/placeholder/140x140.jpg'),(282,'2018-08-03 15:10:53',NULL,'66254d9a-ecc9-49d2-8f7a-14323c5c52e5',0,'Sobre o Autor 81','Autor \'Mockup\' 82','http://localhost/resources/placeholder/140x140.jpg'),(283,'2018-08-03 15:10:53',NULL,'26e3d94c-140d-4359-9125-ac1229cd3c26',0,'Sobre o Autor 82','Autor \'Mockup\' 83','http://localhost/resources/placeholder/140x140.jpg'),(284,'2018-08-03 15:10:53',NULL,'8cb19c3f-6d71-4c0d-8553-c73d21e6a7e7',0,'Sobre o Autor 83','Autor \'Mockup\' 84','http://localhost/resources/placeholder/140x140.jpg'),(285,'2018-08-03 15:10:53',NULL,'4cce9a27-b333-453c-a894-4692535dc120',0,'Sobre o Autor 84','Autor \'Mockup\' 85','http://localhost/resources/placeholder/140x140.jpg'),(286,'2018-08-03 15:10:53',NULL,'c5b4aa1d-62e3-4aca-aa5c-291c7e2b7c09',0,'Sobre o Autor 85','Autor \'Mockup\' 86','http://localhost/resources/placeholder/140x140.jpg'),(287,'2018-08-03 15:10:53',NULL,'2fa0b29c-58df-4fb9-ada1-c1f1dd52f485',0,'Sobre o Autor 86','Autor \'Mockup\' 87','http://localhost/resources/placeholder/140x140.jpg'),(288,'2018-08-03 15:10:53',NULL,'07ed940c-5101-4e7b-95d5-ba9455abc001',0,'Sobre o Autor 87','Autor \'Mockup\' 88','http://localhost/resources/placeholder/140x140.jpg'),(289,'2018-08-03 15:10:53',NULL,'f08988ae-1f06-4404-bdc5-af4f5e5570e0',0,'Sobre o Autor 88','Autor \'Mockup\' 89','http://localhost/resources/placeholder/140x140.jpg'),(290,'2018-08-03 15:10:53',NULL,'e6b34b1a-570c-4501-946b-76392bc06dce',0,'Sobre o Autor 89','Autor \'Mockup\' 90','http://localhost/resources/placeholder/140x140.jpg'),(291,'2018-08-03 15:10:54',NULL,'09478742-f9be-4274-8597-6f5132165b43',0,'Sobre o Autor 90','Autor \'Mockup\' 91','http://localhost/resources/placeholder/140x140.jpg'),(292,'2018-08-03 15:10:54',NULL,'0aea1964-e454-4492-b510-5eb2704aae0f',0,'Sobre o Autor 91','Autor \'Mockup\' 92','http://localhost/resources/placeholder/140x140.jpg'),(293,'2018-08-03 15:10:54',NULL,'90ccdaee-6aab-47fc-8217-17379d9bfaba',0,'Sobre o Autor 92','Autor \'Mockup\' 93','http://localhost/resources/placeholder/140x140.jpg'),(294,'2018-08-03 15:10:54',NULL,'d717bf2e-68a6-4f1a-9735-71c6daed2b26',0,'Sobre o Autor 93','Autor \'Mockup\' 94','http://localhost/resources/placeholder/140x140.jpg'),(295,'2018-08-03 15:10:54',NULL,'4afde9a2-25ed-46e9-b798-7259042f864b',0,'Sobre o Autor 94','Autor \'Mockup\' 95','http://localhost/resources/placeholder/140x140.jpg'),(296,'2018-08-03 15:10:54',NULL,'3b9004d6-45bb-40c3-8a36-7e4cb3ca5543',0,'Sobre o Autor 95','Autor \'Mockup\' 96','http://localhost/resources/placeholder/140x140.jpg'),(297,'2018-08-03 15:10:54',NULL,'205a1cbd-a7af-4293-96d8-f1b36119a99e',0,'Sobre o Autor 96','Autor \'Mockup\' 97','http://localhost/resources/placeholder/140x140.jpg'),(298,'2018-08-03 15:10:54',NULL,'d425623b-9614-49e2-aaa1-fb248c233ee7',0,'Sobre o Autor 97','Autor \'Mockup\' 98','http://localhost/resources/placeholder/140x140.jpg'),(299,'2018-08-03 15:10:54',NULL,'74944199-e5ae-41b8-ac08-5a2dbc67b064',0,'Sobre o Autor 98','Autor \'Mockup\' 99','http://localhost/resources/placeholder/140x140.jpg'),(300,'2018-08-03 15:10:54',NULL,'65c06480-a990-4a65-967a-4e56fc18adaf',0,'Sobre o Autor 99','Autor \'Mockup\' 100','http://localhost/resources/placeholder/140x140.jpg');
/*!40000 ALTER TABLE `Author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Author_Medias`
--

DROP TABLE IF EXISTS `Author_Medias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Author_Medias` (
  `id` bigint(20) NOT NULL,
  `media` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  KEY `FKom56f8tff6ioalnx6jdmrcuw1` (`id`),
  CONSTRAINT `FKom56f8tff6ioalnx6jdmrcuw1` FOREIGN KEY (`id`) REFERENCES `Author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Author_Medias`
--

LOCK TABLES `Author_Medias` WRITE;
/*!40000 ALTER TABLE `Author_Medias` DISABLE KEYS */;
INSERT INTO `Author_Medias` (`id`, `media`, `url`) VALUES (201,'Facebook','http://www.facebook.com.br'),(201,'Twitter','http://www.twitter.com.br'),(201,'Google Plus','http://www.plus.google.com'),(202,'Facebook','http://www.facebook.com.br'),(202,'Twitter','http://www.twitter.com.br'),(202,'Google Plus','http://www.plus.google.com'),(203,'Facebook','http://www.facebook.com.br'),(203,'Twitter','http://www.twitter.com.br'),(203,'Google Plus','http://www.plus.google.com'),(204,'Facebook','http://www.facebook.com.br'),(204,'Twitter','http://www.twitter.com.br'),(204,'Google Plus','http://www.plus.google.com'),(205,'Facebook','http://www.facebook.com.br'),(205,'Twitter','http://www.twitter.com.br'),(205,'Google Plus','http://www.plus.google.com'),(206,'Facebook','http://www.facebook.com.br'),(206,'Twitter','http://www.twitter.com.br'),(206,'Google Plus','http://www.plus.google.com'),(207,'Facebook','http://www.facebook.com.br'),(207,'Twitter','http://www.twitter.com.br'),(207,'Google Plus','http://www.plus.google.com'),(208,'Facebook','http://www.facebook.com.br'),(208,'Twitter','http://www.twitter.com.br'),(208,'Google Plus','http://www.plus.google.com'),(209,'Facebook','http://www.facebook.com.br'),(209,'Twitter','http://www.twitter.com.br'),(209,'Google Plus','http://www.plus.google.com'),(210,'Facebook','http://www.facebook.com.br'),(210,'Twitter','http://www.twitter.com.br'),(210,'Google Plus','http://www.plus.google.com'),(211,'Facebook','http://www.facebook.com.br'),(211,'Twitter','http://www.twitter.com.br'),(211,'Google Plus','http://www.plus.google.com'),(212,'Facebook','http://www.facebook.com.br'),(212,'Twitter','http://www.twitter.com.br'),(212,'Google Plus','http://www.plus.google.com'),(213,'Facebook','http://www.facebook.com.br'),(213,'Twitter','http://www.twitter.com.br'),(213,'Google Plus','http://www.plus.google.com'),(214,'Facebook','http://www.facebook.com.br'),(214,'Twitter','http://www.twitter.com.br'),(214,'Google Plus','http://www.plus.google.com'),(215,'Facebook','http://www.facebook.com.br'),(215,'Twitter','http://www.twitter.com.br'),(215,'Google Plus','http://www.plus.google.com'),(216,'Facebook','http://www.facebook.com.br'),(216,'Twitter','http://www.twitter.com.br'),(216,'Google Plus','http://www.plus.google.com'),(217,'Facebook','http://www.facebook.com.br'),(217,'Twitter','http://www.twitter.com.br'),(217,'Google Plus','http://www.plus.google.com'),(218,'Facebook','http://www.facebook.com.br'),(218,'Twitter','http://www.twitter.com.br'),(218,'Google Plus','http://www.plus.google.com'),(219,'Facebook','http://www.facebook.com.br'),(219,'Twitter','http://www.twitter.com.br'),(219,'Google Plus','http://www.plus.google.com'),(220,'Facebook','http://www.facebook.com.br'),(220,'Twitter','http://www.twitter.com.br'),(220,'Google Plus','http://www.plus.google.com'),(221,'Facebook','http://www.facebook.com.br'),(221,'Twitter','http://www.twitter.com.br'),(221,'Google Plus','http://www.plus.google.com'),(222,'Facebook','http://www.facebook.com.br'),(222,'Twitter','http://www.twitter.com.br'),(222,'Google Plus','http://www.plus.google.com'),(223,'Facebook','http://www.facebook.com.br'),(223,'Twitter','http://www.twitter.com.br'),(223,'Google Plus','http://www.plus.google.com'),(224,'Facebook','http://www.facebook.com.br'),(224,'Twitter','http://www.twitter.com.br'),(224,'Google Plus','http://www.plus.google.com'),(225,'Facebook','http://www.facebook.com.br'),(225,'Twitter','http://www.twitter.com.br'),(225,'Google Plus','http://www.plus.google.com'),(226,'Facebook','http://www.facebook.com.br'),(226,'Twitter','http://www.twitter.com.br'),(226,'Google Plus','http://www.plus.google.com'),(227,'Facebook','http://www.facebook.com.br'),(227,'Twitter','http://www.twitter.com.br'),(227,'Google Plus','http://www.plus.google.com'),(228,'Facebook','http://www.facebook.com.br'),(228,'Twitter','http://www.twitter.com.br'),(228,'Google Plus','http://www.plus.google.com'),(229,'Facebook','http://www.facebook.com.br'),(229,'Twitter','http://www.twitter.com.br'),(229,'Google Plus','http://www.plus.google.com'),(230,'Facebook','http://www.facebook.com.br'),(230,'Twitter','http://www.twitter.com.br'),(230,'Google Plus','http://www.plus.google.com'),(231,'Facebook','http://www.facebook.com.br'),(231,'Twitter','http://www.twitter.com.br'),(231,'Google Plus','http://www.plus.google.com'),(232,'Facebook','http://www.facebook.com.br'),(232,'Twitter','http://www.twitter.com.br'),(232,'Google Plus','http://www.plus.google.com'),(233,'Facebook','http://www.facebook.com.br'),(233,'Twitter','http://www.twitter.com.br'),(233,'Google Plus','http://www.plus.google.com'),(234,'Facebook','http://www.facebook.com.br'),(234,'Twitter','http://www.twitter.com.br'),(234,'Google Plus','http://www.plus.google.com'),(235,'Facebook','http://www.facebook.com.br'),(235,'Twitter','http://www.twitter.com.br'),(235,'Google Plus','http://www.plus.google.com'),(236,'Facebook','http://www.facebook.com.br'),(236,'Twitter','http://www.twitter.com.br'),(236,'Google Plus','http://www.plus.google.com'),(237,'Facebook','http://www.facebook.com.br'),(237,'Twitter','http://www.twitter.com.br'),(237,'Google Plus','http://www.plus.google.com'),(238,'Facebook','http://www.facebook.com.br'),(238,'Twitter','http://www.twitter.com.br'),(238,'Google Plus','http://www.plus.google.com'),(239,'Facebook','http://www.facebook.com.br'),(239,'Twitter','http://www.twitter.com.br'),(239,'Google Plus','http://www.plus.google.com'),(240,'Facebook','http://www.facebook.com.br'),(240,'Twitter','http://www.twitter.com.br'),(240,'Google Plus','http://www.plus.google.com'),(241,'Facebook','http://www.facebook.com.br'),(241,'Twitter','http://www.twitter.com.br'),(241,'Google Plus','http://www.plus.google.com'),(242,'Facebook','http://www.facebook.com.br'),(242,'Twitter','http://www.twitter.com.br'),(242,'Google Plus','http://www.plus.google.com'),(243,'Facebook','http://www.facebook.com.br'),(243,'Twitter','http://www.twitter.com.br'),(243,'Google Plus','http://www.plus.google.com'),(244,'Facebook','http://www.facebook.com.br'),(244,'Twitter','http://www.twitter.com.br'),(244,'Google Plus','http://www.plus.google.com'),(245,'Facebook','http://www.facebook.com.br'),(245,'Twitter','http://www.twitter.com.br'),(245,'Google Plus','http://www.plus.google.com'),(246,'Facebook','http://www.facebook.com.br'),(246,'Twitter','http://www.twitter.com.br'),(246,'Google Plus','http://www.plus.google.com'),(247,'Facebook','http://www.facebook.com.br'),(247,'Twitter','http://www.twitter.com.br'),(247,'Google Plus','http://www.plus.google.com'),(248,'Facebook','http://www.facebook.com.br'),(248,'Twitter','http://www.twitter.com.br'),(248,'Google Plus','http://www.plus.google.com'),(249,'Facebook','http://www.facebook.com.br'),(249,'Twitter','http://www.twitter.com.br'),(249,'Google Plus','http://www.plus.google.com'),(250,'Facebook','http://www.facebook.com.br'),(250,'Twitter','http://www.twitter.com.br'),(250,'Google Plus','http://www.plus.google.com'),(251,'Facebook','http://www.facebook.com.br'),(251,'Twitter','http://www.twitter.com.br'),(251,'Google Plus','http://www.plus.google.com'),(252,'Facebook','http://www.facebook.com.br'),(252,'Twitter','http://www.twitter.com.br'),(252,'Google Plus','http://www.plus.google.com'),(253,'Facebook','http://www.facebook.com.br'),(253,'Twitter','http://www.twitter.com.br'),(253,'Google Plus','http://www.plus.google.com'),(254,'Facebook','http://www.facebook.com.br'),(254,'Twitter','http://www.twitter.com.br'),(254,'Google Plus','http://www.plus.google.com'),(255,'Facebook','http://www.facebook.com.br'),(255,'Twitter','http://www.twitter.com.br'),(255,'Google Plus','http://www.plus.google.com'),(256,'Facebook','http://www.facebook.com.br'),(256,'Twitter','http://www.twitter.com.br'),(256,'Google Plus','http://www.plus.google.com'),(257,'Facebook','http://www.facebook.com.br'),(257,'Twitter','http://www.twitter.com.br'),(257,'Google Plus','http://www.plus.google.com'),(258,'Facebook','http://www.facebook.com.br'),(258,'Twitter','http://www.twitter.com.br'),(258,'Google Plus','http://www.plus.google.com'),(259,'Facebook','http://www.facebook.com.br'),(259,'Twitter','http://www.twitter.com.br'),(259,'Google Plus','http://www.plus.google.com'),(260,'Facebook','http://www.facebook.com.br'),(260,'Twitter','http://www.twitter.com.br'),(260,'Google Plus','http://www.plus.google.com'),(261,'Facebook','http://www.facebook.com.br'),(261,'Twitter','http://www.twitter.com.br'),(261,'Google Plus','http://www.plus.google.com'),(262,'Facebook','http://www.facebook.com.br'),(262,'Twitter','http://www.twitter.com.br'),(262,'Google Plus','http://www.plus.google.com'),(263,'Facebook','http://www.facebook.com.br'),(263,'Twitter','http://www.twitter.com.br'),(263,'Google Plus','http://www.plus.google.com'),(264,'Facebook','http://www.facebook.com.br'),(264,'Twitter','http://www.twitter.com.br'),(264,'Google Plus','http://www.plus.google.com'),(265,'Facebook','http://www.facebook.com.br'),(265,'Twitter','http://www.twitter.com.br'),(265,'Google Plus','http://www.plus.google.com'),(266,'Facebook','http://www.facebook.com.br'),(266,'Twitter','http://www.twitter.com.br'),(266,'Google Plus','http://www.plus.google.com'),(267,'Facebook','http://www.facebook.com.br'),(267,'Twitter','http://www.twitter.com.br'),(267,'Google Plus','http://www.plus.google.com'),(268,'Facebook','http://www.facebook.com.br'),(268,'Twitter','http://www.twitter.com.br'),(268,'Google Plus','http://www.plus.google.com'),(269,'Facebook','http://www.facebook.com.br'),(269,'Twitter','http://www.twitter.com.br'),(269,'Google Plus','http://www.plus.google.com'),(270,'Facebook','http://www.facebook.com.br'),(270,'Twitter','http://www.twitter.com.br'),(270,'Google Plus','http://www.plus.google.com'),(271,'Facebook','http://www.facebook.com.br'),(271,'Twitter','http://www.twitter.com.br'),(271,'Google Plus','http://www.plus.google.com'),(272,'Facebook','http://www.facebook.com.br'),(272,'Twitter','http://www.twitter.com.br'),(272,'Google Plus','http://www.plus.google.com'),(273,'Facebook','http://www.facebook.com.br'),(273,'Twitter','http://www.twitter.com.br'),(273,'Google Plus','http://www.plus.google.com'),(274,'Facebook','http://www.facebook.com.br'),(274,'Twitter','http://www.twitter.com.br'),(274,'Google Plus','http://www.plus.google.com'),(275,'Facebook','http://www.facebook.com.br'),(275,'Twitter','http://www.twitter.com.br'),(275,'Google Plus','http://www.plus.google.com'),(276,'Facebook','http://www.facebook.com.br'),(276,'Twitter','http://www.twitter.com.br'),(276,'Google Plus','http://www.plus.google.com'),(277,'Facebook','http://www.facebook.com.br'),(277,'Twitter','http://www.twitter.com.br'),(277,'Google Plus','http://www.plus.google.com'),(278,'Facebook','http://www.facebook.com.br'),(278,'Twitter','http://www.twitter.com.br'),(278,'Google Plus','http://www.plus.google.com'),(279,'Facebook','http://www.facebook.com.br'),(279,'Twitter','http://www.twitter.com.br'),(279,'Google Plus','http://www.plus.google.com'),(280,'Facebook','http://www.facebook.com.br'),(280,'Twitter','http://www.twitter.com.br'),(280,'Google Plus','http://www.plus.google.com'),(281,'Facebook','http://www.facebook.com.br'),(281,'Twitter','http://www.twitter.com.br'),(281,'Google Plus','http://www.plus.google.com'),(282,'Facebook','http://www.facebook.com.br'),(282,'Twitter','http://www.twitter.com.br'),(282,'Google Plus','http://www.plus.google.com'),(283,'Facebook','http://www.facebook.com.br'),(283,'Twitter','http://www.twitter.com.br'),(283,'Google Plus','http://www.plus.google.com'),(284,'Facebook','http://www.facebook.com.br'),(284,'Twitter','http://www.twitter.com.br'),(284,'Google Plus','http://www.plus.google.com'),(285,'Facebook','http://www.facebook.com.br'),(285,'Twitter','http://www.twitter.com.br'),(285,'Google Plus','http://www.plus.google.com'),(286,'Facebook','http://www.facebook.com.br'),(286,'Twitter','http://www.twitter.com.br'),(286,'Google Plus','http://www.plus.google.com'),(287,'Facebook','http://www.facebook.com.br'),(287,'Twitter','http://www.twitter.com.br'),(287,'Google Plus','http://www.plus.google.com'),(288,'Facebook','http://www.facebook.com.br'),(288,'Twitter','http://www.twitter.com.br'),(288,'Google Plus','http://www.plus.google.com'),(289,'Facebook','http://www.facebook.com.br'),(289,'Twitter','http://www.twitter.com.br'),(289,'Google Plus','http://www.plus.google.com'),(290,'Facebook','http://www.facebook.com.br'),(290,'Twitter','http://www.twitter.com.br'),(290,'Google Plus','http://www.plus.google.com'),(291,'Facebook','http://www.facebook.com.br'),(291,'Twitter','http://www.twitter.com.br'),(291,'Google Plus','http://www.plus.google.com'),(292,'Facebook','http://www.facebook.com.br'),(292,'Twitter','http://www.twitter.com.br'),(292,'Google Plus','http://www.plus.google.com'),(293,'Facebook','http://www.facebook.com.br'),(293,'Twitter','http://www.twitter.com.br'),(293,'Google Plus','http://www.plus.google.com'),(294,'Facebook','http://www.facebook.com.br'),(294,'Twitter','http://www.twitter.com.br'),(294,'Google Plus','http://www.plus.google.com'),(295,'Facebook','http://www.facebook.com.br'),(295,'Twitter','http://www.twitter.com.br'),(295,'Google Plus','http://www.plus.google.com'),(296,'Facebook','http://www.facebook.com.br'),(296,'Twitter','http://www.twitter.com.br'),(296,'Google Plus','http://www.plus.google.com'),(297,'Facebook','http://www.facebook.com.br'),(297,'Twitter','http://www.twitter.com.br'),(297,'Google Plus','http://www.plus.google.com'),(298,'Facebook','http://www.facebook.com.br'),(298,'Twitter','http://www.twitter.com.br'),(298,'Google Plus','http://www.plus.google.com'),(299,'Facebook','http://www.facebook.com.br'),(299,'Twitter','http://www.twitter.com.br'),(299,'Google Plus','http://www.plus.google.com'),(300,'Facebook','http://www.facebook.com.br'),(300,'Twitter','http://www.twitter.com.br'),(300,'Google Plus','http://www.plus.google.com');
/*!40000 ALTER TABLE `Author_Medias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Blog`
--

DROP TABLE IF EXISTS `Blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Blog` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `citation` longtext,
  `content` longtext,
  `publishDate` date DEFAULT NULL,
  `resume` longtext,
  `title` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlujhnurrvb9fmwf3qq86gfkv5` (`author_id`),
  CONSTRAINT `FKlujhnurrvb9fmwf3qq86gfkv5` FOREIGN KEY (`author_id`) REFERENCES `Author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Blog`
--

LOCK TABLES `Blog` WRITE;
/*!40000 ALTER TABLE `Blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `Blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Blog_Pictures`
--

DROP TABLE IF EXISTS `Blog_Pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Blog_Pictures` (
  `id` bigint(20) NOT NULL,
  `pictures` varchar(255) DEFAULT NULL,
  KEY `FKm59bxq3txmh98brcfc0cn9hxj` (`id`),
  CONSTRAINT `FKm59bxq3txmh98brcfc0cn9hxj` FOREIGN KEY (`id`) REFERENCES `Blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Blog_Pictures`
--

LOCK TABLES `Blog_Pictures` WRITE;
/*!40000 ALTER TABLE `Blog_Pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `Blog_Pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Blog_Tags`
--

DROP TABLE IF EXISTS `Blog_Tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Blog_Tags` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  KEY `FKa546jdiyweuc2b3x7jrkp7x0i` (`id`),
  CONSTRAINT `FKa546jdiyweuc2b3x7jrkp7x0i` FOREIGN KEY (`id`) REFERENCES `Blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Blog_Tags`
--

LOCK TABLES `Blog_Tags` WRITE;
/*!40000 ALTER TABLE `Blog_Tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `Blog_Tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Candidate`
--

DROP TABLE IF EXISTS `Candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Candidate` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `mobilePhone` bigint(20) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `estate` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipCode` bigint(20) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `birthDate` date NOT NULL,
  `cpf` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t7pfl9jl23c9lxqr2e8rkx8a1` (`user_id`),
  UNIQUE KEY `UK_lhi15ch3oqog5puykrc4cjkoa` (`cpf`),
  CONSTRAINT `FKfvyoonmjdmrw1kjrmw4q8p91v` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Candidate`
--

LOCK TABLES `Candidate` WRITE;
/*!40000 ALTER TABLE `Candidate` DISABLE KEYS */;
/*!40000 ALTER TABLE `Candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `text` longtext NOT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrlbquj2fexk4krvmaiqkqwcrc` (`blog_id`),
  CONSTRAINT `FKrlbquj2fexk4krvmaiqkqwcrc` FOREIGN KEY (`blog_id`) REFERENCES `Blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Company`
--

DROP TABLE IF EXISTS `Company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Company` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `mobilePhone` bigint(20) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `estate` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipCode` bigint(20) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `cnpj` bigint(20) NOT NULL,
  `description` longtext,
  `segment` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dwsbtmyawoypq36gsj09yu8gj` (`user_id`),
  UNIQUE KEY `UK_33w1pwyluy8ady8vroyqa208a` (`cnpj`),
  CONSTRAINT `FK6kq0oojxrh45l5c94ohcrpg20` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Company`
--

LOCK TABLES `Company` WRITE;
/*!40000 ALTER TABLE `Company` DISABLE KEYS */;
INSERT INTO `Company` (`id`, `createdAt`, `updatedAt`, `uuid`, `version`, `mobilePhone`, `city`, `estate`, `neighborhood`, `number`, `street`, `zipCode`, `name`, `cnpj`, `description`, `segment`, `user_id`) VALUES (101,'2018-08-03 15:10:37',NULL,'3788852e-a8d1-45d2-93e0-2495eeb7c8ad',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 51',9223372036854775756,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 51',51),(102,'2018-08-03 15:10:38',NULL,'fd49afb6-2ee2-431e-8703-0b539e9125bf',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 52',9223372036854775755,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 52',52),(103,'2018-08-03 15:10:38',NULL,'8fe41845-ca0d-4361-ae5d-8358c7996bc1',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 53',9223372036854775754,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 53',53),(104,'2018-08-03 15:10:38',NULL,'b65167cc-3512-4a0a-bb54-fc36944a5e14',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 54',9223372036854775753,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 54',54),(105,'2018-08-03 15:10:38',NULL,'23f50dfe-8a6b-40d9-bde7-be0c134485d3',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 55',9223372036854775752,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 55',55),(106,'2018-08-03 15:10:38',NULL,'dda8827b-2ff4-4326-8fa6-5615a285d043',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 56',9223372036854775751,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 56',56),(107,'2018-08-03 15:10:38',NULL,'93266e49-db7f-48e9-9050-bf405df7fdb2',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 57',9223372036854775750,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 57',57),(108,'2018-08-03 15:10:38',NULL,'ff84a447-f3b2-4e6a-a067-fb49e1a2168d',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 58',9223372036854775749,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 58',58),(109,'2018-08-03 15:10:38',NULL,'10559d1e-9cba-4593-adff-9b23d0453d84',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 59',9223372036854775748,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 59',59),(110,'2018-08-03 15:10:38',NULL,'eaed3efb-c7ec-4414-bbe4-bd08356a6ae7',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 60',9223372036854775747,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 60',60),(111,'2018-08-03 15:10:38',NULL,'f1750a59-3cd7-426c-9116-26f0f998589e',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 61',9223372036854775746,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 61',61),(112,'2018-08-03 15:10:38',NULL,'9b8528cf-95cc-4a84-9185-e3a43540c4aa',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 62',9223372036854775745,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 62',62),(113,'2018-08-03 15:10:39',NULL,'98876a55-ee8f-4ca0-8314-89904148115c',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 63',9223372036854775744,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 63',63),(114,'2018-08-03 15:10:39',NULL,'3c0eb6e5-acab-4867-9c47-e82fe56d3395',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 64',9223372036854775743,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 64',64),(115,'2018-08-03 15:10:39',NULL,'61709e31-0304-4ee1-82a8-dfad9f1c8165',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 65',9223372036854775742,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 65',65),(116,'2018-08-03 15:10:39',NULL,'a9e4a62e-3119-48b8-8081-fc4aa4b1777e',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 66',9223372036854775741,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 66',66),(117,'2018-08-03 15:10:39',NULL,'e5d452fb-a767-4205-a7f5-b32b43195f49',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 67',9223372036854775740,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 67',67),(118,'2018-08-03 15:10:39',NULL,'a096fb8f-86d9-4d97-b003-c153ba6b93a7',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 68',9223372036854775739,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 68',68),(119,'2018-08-03 15:10:39',NULL,'69f33325-d53a-42d7-a463-be0f4c90c1c3',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 69',9223372036854775738,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 69',69),(120,'2018-08-03 15:10:39',NULL,'2308bdae-290e-4cac-a642-e614cd0524cf',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 70',9223372036854775737,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 70',70),(121,'2018-08-03 15:10:39',NULL,'7680db83-a3d8-499a-a690-b6cb3453713c',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 71',9223372036854775736,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 71',71),(122,'2018-08-03 15:10:39',NULL,'50762ae9-01c6-49d2-a122-30d0dc7650b5',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 72',9223372036854775735,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 72',72),(123,'2018-08-03 15:10:39',NULL,'4b2ed245-61b3-4d48-a05d-97d5317c3fa7',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 73',9223372036854775734,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 73',73),(124,'2018-08-03 15:10:39',NULL,'66e62602-0b86-483e-8597-7a5d4c8dd204',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 74',9223372036854775733,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 74',74),(125,'2018-08-03 15:10:40',NULL,'ee2fcae3-13cb-4c70-a0d2-7173c44d8f80',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 75',9223372036854775732,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 75',75),(126,'2018-08-03 15:10:40',NULL,'4e20dd30-79df-400c-9519-505b55e56c49',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 76',9223372036854775731,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 76',76),(127,'2018-08-03 15:10:40',NULL,'1def8cb5-e580-46ce-b4af-5a1e94044f50',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 77',9223372036854775730,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 77',77),(128,'2018-08-03 15:10:40',NULL,'99828c1b-9afe-41b3-a6ec-2a689ef309d5',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 78',9223372036854775729,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 78',78),(129,'2018-08-03 15:10:40',NULL,'57fb5ac6-0847-4b47-bf11-b3fd013dface',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 79',9223372036854775728,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 79',79),(130,'2018-08-03 15:10:40',NULL,'f07ff299-8c33-4488-82f9-d42ace655b8f',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 80',9223372036854775727,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 80',80),(131,'2018-08-03 15:10:40',NULL,'5d5d5439-6f63-45b5-9c0b-f651447af3c0',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 81',9223372036854775726,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 81',81),(132,'2018-08-03 15:10:40',NULL,'d22b7fd4-4934-4f25-8f21-7fe586e45e0d',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 82',9223372036854775725,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 82',82),(133,'2018-08-03 15:10:40',NULL,'7a18045a-1cbb-4d0a-bda5-8490529f78bb',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 83',9223372036854775724,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 83',83),(134,'2018-08-03 15:10:40',NULL,'f6ce0602-8443-4ed6-b1a6-78fe396a9bf0',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 84',9223372036854775723,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 84',84),(135,'2018-08-03 15:10:40',NULL,'3393faaf-a872-4590-ac13-8125830a60d4',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 85',9223372036854775722,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 85',85),(136,'2018-08-03 15:10:41',NULL,'f71e28ed-7cd8-4e46-b3a7-70edffb66bf1',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 86',9223372036854775721,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 86',86),(137,'2018-08-03 15:10:41',NULL,'dd00e2f8-1c9e-4952-a113-8c7a5d824776',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 87',9223372036854775720,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 87',87),(138,'2018-08-03 15:10:41',NULL,'68e3b829-eb1b-430a-88b0-68ba3957b291',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 88',9223372036854775719,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 88',88),(139,'2018-08-03 15:10:41',NULL,'42892694-a2bf-49a4-852f-b2c07446cbb6',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 89',9223372036854775718,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 89',89),(140,'2018-08-03 15:10:41',NULL,'9df4b925-d5b0-4bc2-b19e-012f0238c650',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 90',9223372036854775717,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 90',90),(141,'2018-08-03 15:10:41',NULL,'cc2f7dff-020a-4dea-9191-6306bd8a989d',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 91',9223372036854775716,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 91',91),(142,'2018-08-03 15:10:41',NULL,'dd334bc8-2745-48ef-9a9f-44870c7c5a3e',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 92',9223372036854775715,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 92',92),(143,'2018-08-03 15:10:41',NULL,'ac100400-dcfd-4e61-9907-77131a7757f4',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 93',9223372036854775714,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 93',93),(144,'2018-08-03 15:10:41',NULL,'d5424d01-cce6-4fce-bdb7-2a64b73b6335',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 94',9223372036854775713,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 94',94),(145,'2018-08-03 15:10:41',NULL,'7cc65dc7-8eef-4f32-92be-ef72d12cafde',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 95',9223372036854775712,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 95',95),(146,'2018-08-03 15:10:41',NULL,'de1bcc5c-4b49-4692-aa92-b2804105fcd8',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 96',9223372036854775711,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 96',96),(147,'2018-08-03 15:10:41',NULL,'14ba8909-af5a-4aa9-9ef1-9900ea50bc0e',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 97',9223372036854775710,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 97',97),(148,'2018-08-03 15:10:42',NULL,'ca87dd58-6815-4c23-aee0-63ce85ea103a',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 98',9223372036854775709,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 98',98),(149,'2018-08-03 15:10:42',NULL,'39779841-caac-4cfd-836c-d31f07d38ae4',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 99',9223372036854775708,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 99',99),(150,'2018-08-03 15:10:42',NULL,'da118ee3-3027-4916-bf03-e0ff1f215856',0,123456,'São José dos Campos','SP','Bairro','212','Rua',45632145,'Empresa \'Mockup\' N# 100',9223372036854775707,'Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui Descrição Aqui ','Segmento N# 100',100);
/*!40000 ALTER TABLE `Company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JAAS_Role`
--

DROP TABLE IF EXISTS `JAAS_Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JAAS_Role` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JAAS_Role`
--

LOCK TABLES `JAAS_Role` WRITE;
/*!40000 ALTER TABLE `JAAS_Role` DISABLE KEYS */;
INSERT INTO `JAAS_Role` (`name`) VALUES ('Admin'),('Guest');
/*!40000 ALTER TABLE `JAAS_Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JAAS_Roles`
--

DROP TABLE IF EXISTS `JAAS_Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JAAS_Roles` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`role_name`),
  KEY `FK6d5kklxeuueu761hn9s7lyavr` (`role_name`),
  CONSTRAINT `FK6d5kklxeuueu761hn9s7lyavr` FOREIGN KEY (`role_name`) REFERENCES `JAAS_Role` (`name`),
  CONSTRAINT `FK6syr53wcgfrb6pxtwk61diuet` FOREIGN KEY (`id`) REFERENCES `JAAS_User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JAAS_Roles`
--

LOCK TABLES `JAAS_Roles` WRITE;
/*!40000 ALTER TABLE `JAAS_Roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `JAAS_Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JAAS_User`
--

DROP TABLE IF EXISTS `JAAS_User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JAAS_User` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JAAS_User`
--

LOCK TABLES `JAAS_User` WRITE;
/*!40000 ALTER TABLE `JAAS_User` DISABLE KEYS */;
/*!40000 ALTER TABLE `JAAS_User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Job`
--

DROP TABLE IF EXISTS `Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Job` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `benefits` longtext NOT NULL,
  `description` longtext NOT NULL,
  `jobCategory` varchar(255) DEFAULT NULL,
  `jobType` varchar(255) DEFAULT NULL,
  `maxPayment` decimal(19,2) DEFAULT NULL,
  `minPayment` decimal(19,2) DEFAULT NULL,
  `requirement` longtext NOT NULL,
  `title` varchar(255) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmo8sc3h669ub3n4svx8dhlpy6` (`company_id`),
  CONSTRAINT `FKmo8sc3h669ub3n4svx8dhlpy6` FOREIGN KEY (`company_id`) REFERENCES `Company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Job`
--

LOCK TABLES `Job` WRITE;
/*!40000 ALTER TABLE `Job` DISABLE KEYS */;
INSERT INTO `Job` (`id`, `createdAt`, `updatedAt`, `uuid`, `version`, `active`, `benefits`, `description`, `jobCategory`, `jobType`, `maxPayment`, `minPayment`, `requirement`, `title`, `company_id`) VALUES (151,'2018-08-03 15:10:42',NULL,'b74973f7-5771-4812-a145-c81e9b81f2cf',0,'\0','Benefícios da Vaga 1','Descrição da Vaga 1','OPERATOR','FULLTIME',21.00,11.00,'Requerimentos da Vaga 1','Vaga \'Mockup\' N# 1',101),(152,'2018-08-03 15:10:42',NULL,'52cfd4dc-07fc-44cd-9d7e-ec77950fb276',0,'\0','Benefícios da Vaga 2','Descrição da Vaga 2','OPERATOR','TEMPORARY',121.00,111.00,'Requerimentos da Vaga 2','Vaga \'Mockup\' N# 2',102),(153,'2018-08-03 15:10:42',NULL,'57bac72b-6313-42cd-8d06-2e54dd2755dc',0,'\0','Benefícios da Vaga 3','Descrição da Vaga 3','OPERATOR','FULLTIME',221.00,211.00,'Requerimentos da Vaga 3','Vaga \'Mockup\' N# 3',103),(154,'2018-08-03 15:10:42',NULL,'f1b8a11f-edf9-46b0-bea6-174ad8c3635d',0,'\0','Benefícios da Vaga 4','Descrição da Vaga 4','OPERATOR','TEMPORARY',321.00,311.00,'Requerimentos da Vaga 4','Vaga \'Mockup\' N# 4',104),(155,'2018-08-03 15:10:43',NULL,'337216dc-404e-4083-a08b-308ca009cc7e',0,'\0','Benefícios da Vaga 5','Descrição da Vaga 5','OPERATOR','FULLTIME',421.00,411.00,'Requerimentos da Vaga 5','Vaga \'Mockup\' N# 5',105),(156,'2018-08-03 15:10:43',NULL,'98a8fa31-94de-49e3-8988-16548ac7c11e',0,'\0','Benefícios da Vaga 6','Descrição da Vaga 6','OPERATOR','TEMPORARY',521.00,511.00,'Requerimentos da Vaga 6','Vaga \'Mockup\' N# 6',106),(157,'2018-08-03 15:10:43',NULL,'151a38d2-15b8-4472-a665-00bd129c08c3',0,'\0','Benefícios da Vaga 7','Descrição da Vaga 7','OPERATOR','FULLTIME',621.00,611.00,'Requerimentos da Vaga 7','Vaga \'Mockup\' N# 7',107),(158,'2018-08-03 15:10:43',NULL,'a5a46a42-2d79-4fd7-bcc0-93ac55a3c998',0,'\0','Benefícios da Vaga 8','Descrição da Vaga 8','OPERATOR','TEMPORARY',721.00,711.00,'Requerimentos da Vaga 8','Vaga \'Mockup\' N# 8',108),(159,'2018-08-03 15:10:43',NULL,'78674bb7-402b-4ea5-8541-1a5503265ed6',0,'\0','Benefícios da Vaga 9','Descrição da Vaga 9','OPERATOR','FULLTIME',821.00,811.00,'Requerimentos da Vaga 9','Vaga \'Mockup\' N# 9',109),(160,'2018-08-03 15:10:43',NULL,'9527eaf4-a5c1-40c3-b345-8675f8081b61',0,'\0','Benefícios da Vaga 10','Descrição da Vaga 10','OPERATOR','TEMPORARY',921.00,911.00,'Requerimentos da Vaga 10','Vaga \'Mockup\' N# 10',110),(161,'2018-08-03 15:10:43',NULL,'38e4b5ba-8522-43ab-ae26-3c6700d7a4e0',0,'\0','Benefícios da Vaga 11','Descrição da Vaga 11','OPERATOR','FULLTIME',1021.00,1011.00,'Requerimentos da Vaga 11','Vaga \'Mockup\' N# 11',111),(162,'2018-08-03 15:10:43',NULL,'16e0bc5d-b155-44a4-9d23-d33757d7a06b',0,'\0','Benefícios da Vaga 12','Descrição da Vaga 12','OPERATOR','TEMPORARY',1121.00,1111.00,'Requerimentos da Vaga 12','Vaga \'Mockup\' N# 12',112),(163,'2018-08-03 15:10:43',NULL,'cfb3f14f-1486-40bf-a8de-3e8a5f2efa5a',0,'\0','Benefícios da Vaga 13','Descrição da Vaga 13','OPERATOR','FULLTIME',1221.00,1211.00,'Requerimentos da Vaga 13','Vaga \'Mockup\' N# 13',113),(164,'2018-08-03 15:10:43',NULL,'8307dfb2-932c-4ad7-b955-32ae0e122fae',0,'\0','Benefícios da Vaga 14','Descrição da Vaga 14','OPERATOR','TEMPORARY',1321.00,1311.00,'Requerimentos da Vaga 14','Vaga \'Mockup\' N# 14',114),(165,'2018-08-03 15:10:43',NULL,'847d4d1a-dd2d-47b8-acdc-1fa928707255',0,'\0','Benefícios da Vaga 15','Descrição da Vaga 15','OPERATOR','FULLTIME',1421.00,1411.00,'Requerimentos da Vaga 15','Vaga \'Mockup\' N# 15',115),(166,'2018-08-03 15:10:44',NULL,'211b3284-d007-4f37-948c-554556fe15aa',0,'\0','Benefícios da Vaga 16','Descrição da Vaga 16','OPERATOR','TEMPORARY',1521.00,1511.00,'Requerimentos da Vaga 16','Vaga \'Mockup\' N# 16',116),(167,'2018-08-03 15:10:44',NULL,'6154b2f9-d630-4892-9f07-c1858a8ae108',0,'\0','Benefícios da Vaga 17','Descrição da Vaga 17','OPERATOR','FULLTIME',1621.00,1611.00,'Requerimentos da Vaga 17','Vaga \'Mockup\' N# 17',117),(168,'2018-08-03 15:10:44',NULL,'086537ad-2433-4d4d-973a-d9afa77d25f0',0,'\0','Benefícios da Vaga 18','Descrição da Vaga 18','OPERATOR','TEMPORARY',1721.00,1711.00,'Requerimentos da Vaga 18','Vaga \'Mockup\' N# 18',118),(169,'2018-08-03 15:10:44',NULL,'f0c31b79-4cd6-4ac8-8658-b1a5633ec663',0,'\0','Benefícios da Vaga 19','Descrição da Vaga 19','OPERATOR','FULLTIME',1821.00,1811.00,'Requerimentos da Vaga 19','Vaga \'Mockup\' N# 19',119),(170,'2018-08-03 15:10:44',NULL,'10fbf104-dad8-43f8-955b-d076e673a942',0,'\0','Benefícios da Vaga 20','Descrição da Vaga 20','OPERATOR','TEMPORARY',1921.00,1911.00,'Requerimentos da Vaga 20','Vaga \'Mockup\' N# 20',120),(171,'2018-08-03 15:10:44',NULL,'536bf2dc-4e08-4625-b8bf-443449e30c75',0,'\0','Benefícios da Vaga 21','Descrição da Vaga 21','OPERATOR','FULLTIME',2021.00,2011.00,'Requerimentos da Vaga 21','Vaga \'Mockup\' N# 21',121),(172,'2018-08-03 15:10:44',NULL,'d59d4cea-675f-4d01-95b8-91a6c2a015c0',0,'\0','Benefícios da Vaga 22','Descrição da Vaga 22','OPERATOR','TEMPORARY',2121.00,2111.00,'Requerimentos da Vaga 22','Vaga \'Mockup\' N# 22',122),(173,'2018-08-03 15:10:44',NULL,'d8bbc7b7-63f7-4e1e-b8ba-15522c61db21',0,'\0','Benefícios da Vaga 23','Descrição da Vaga 23','OPERATOR','FULLTIME',2221.00,2211.00,'Requerimentos da Vaga 23','Vaga \'Mockup\' N# 23',123),(174,'2018-08-03 15:10:44',NULL,'2a1494b0-14ad-4e04-b2b7-e8d7cc418bfc',0,'\0','Benefícios da Vaga 24','Descrição da Vaga 24','OPERATOR','TEMPORARY',2321.00,2311.00,'Requerimentos da Vaga 24','Vaga \'Mockup\' N# 24',124),(175,'2018-08-03 15:10:44',NULL,'9e3f6d24-7a1a-4b00-97ab-61ead770d968',0,'\0','Benefícios da Vaga 25','Descrição da Vaga 25','OPERATOR','FULLTIME',2421.00,2411.00,'Requerimentos da Vaga 25','Vaga \'Mockup\' N# 25',125),(176,'2018-08-03 15:10:44',NULL,'4e889ce8-55da-4e6f-a102-a44cde55f709',0,'\0','Benefícios da Vaga 26','Descrição da Vaga 26','OPERATOR','TEMPORARY',2521.00,2511.00,'Requerimentos da Vaga 26','Vaga \'Mockup\' N# 26',126),(177,'2018-08-03 15:10:45',NULL,'1922c5d3-e0bf-45c0-9ad3-048c2cfdfc27',0,'\0','Benefícios da Vaga 27','Descrição da Vaga 27','OPERATOR','FULLTIME',2621.00,2611.00,'Requerimentos da Vaga 27','Vaga \'Mockup\' N# 27',127),(178,'2018-08-03 15:10:45',NULL,'ff494881-8e7b-4883-8792-36e67482162a',0,'\0','Benefícios da Vaga 28','Descrição da Vaga 28','OPERATOR','TEMPORARY',2721.00,2711.00,'Requerimentos da Vaga 28','Vaga \'Mockup\' N# 28',128),(179,'2018-08-03 15:10:45',NULL,'bf2f76c6-acc8-4010-9eb2-19cb81c9ee35',0,'\0','Benefícios da Vaga 29','Descrição da Vaga 29','OPERATOR','FULLTIME',2821.00,2811.00,'Requerimentos da Vaga 29','Vaga \'Mockup\' N# 29',129),(180,'2018-08-03 15:10:45',NULL,'7ca15a2a-510c-4731-b5d6-3c76030f3cdd',0,'\0','Benefícios da Vaga 30','Descrição da Vaga 30','OPERATOR','TEMPORARY',2921.00,2911.00,'Requerimentos da Vaga 30','Vaga \'Mockup\' N# 30',130),(181,'2018-08-03 15:10:45',NULL,'f4a7b74a-d3c7-4b69-b2c1-16ab5e7fe8f8',0,'\0','Benefícios da Vaga 31','Descrição da Vaga 31','OPERATOR','FULLTIME',3021.00,3011.00,'Requerimentos da Vaga 31','Vaga \'Mockup\' N# 31',131),(182,'2018-08-03 15:10:45',NULL,'c673ba01-ad4d-49b1-a70a-6094eb7f444a',0,'\0','Benefícios da Vaga 32','Descrição da Vaga 32','OPERATOR','TEMPORARY',3121.00,3111.00,'Requerimentos da Vaga 32','Vaga \'Mockup\' N# 32',132),(183,'2018-08-03 15:10:45',NULL,'823ed636-3572-4584-aecb-c3e32e1bbe7a',0,'\0','Benefícios da Vaga 33','Descrição da Vaga 33','OPERATOR','FULLTIME',3221.00,3211.00,'Requerimentos da Vaga 33','Vaga \'Mockup\' N# 33',133),(184,'2018-08-03 15:10:45',NULL,'d6c5e701-1a36-408f-ba83-d359b205cc47',0,'\0','Benefícios da Vaga 34','Descrição da Vaga 34','OPERATOR','TEMPORARY',3321.00,3311.00,'Requerimentos da Vaga 34','Vaga \'Mockup\' N# 34',134),(185,'2018-08-03 15:10:45',NULL,'3790c1df-0767-4cc0-818f-b028f98807c6',0,'\0','Benefícios da Vaga 35','Descrição da Vaga 35','OPERATOR','FULLTIME',3421.00,3411.00,'Requerimentos da Vaga 35','Vaga \'Mockup\' N# 35',135),(186,'2018-08-03 15:10:45',NULL,'3e9b2d1a-d4fa-4947-b7dd-4d7de0a01086',0,'\0','Benefícios da Vaga 36','Descrição da Vaga 36','OPERATOR','TEMPORARY',3521.00,3511.00,'Requerimentos da Vaga 36','Vaga \'Mockup\' N# 36',136),(187,'2018-08-03 15:10:45',NULL,'a424f0e8-1b49-420a-9dea-ac90d2edbe48',0,'\0','Benefícios da Vaga 37','Descrição da Vaga 37','OPERATOR','FULLTIME',3621.00,3611.00,'Requerimentos da Vaga 37','Vaga \'Mockup\' N# 37',137),(188,'2018-08-03 15:10:46',NULL,'306a12ac-fc9b-4445-81ea-e1bb756c150f',0,'\0','Benefícios da Vaga 38','Descrição da Vaga 38','OPERATOR','TEMPORARY',3721.00,3711.00,'Requerimentos da Vaga 38','Vaga \'Mockup\' N# 38',138),(189,'2018-08-03 15:10:46',NULL,'a1c0c3ec-fb61-4613-a0ec-cb19d12a8334',0,'\0','Benefícios da Vaga 39','Descrição da Vaga 39','OPERATOR','FULLTIME',3821.00,3811.00,'Requerimentos da Vaga 39','Vaga \'Mockup\' N# 39',139),(190,'2018-08-03 15:10:46',NULL,'46b08604-fad2-40f3-9bb2-9feeb55392c8',0,'\0','Benefícios da Vaga 40','Descrição da Vaga 40','OPERATOR','TEMPORARY',3921.00,3911.00,'Requerimentos da Vaga 40','Vaga \'Mockup\' N# 40',140),(191,'2018-08-03 15:10:46',NULL,'24030688-a274-4f98-aed2-d0b1cda8b776',0,'\0','Benefícios da Vaga 41','Descrição da Vaga 41','OPERATOR','FULLTIME',4021.00,4011.00,'Requerimentos da Vaga 41','Vaga \'Mockup\' N# 41',141),(192,'2018-08-03 15:10:46',NULL,'f8ba8c38-4501-47df-8962-0aded30b0440',0,'\0','Benefícios da Vaga 42','Descrição da Vaga 42','OPERATOR','TEMPORARY',4121.00,4111.00,'Requerimentos da Vaga 42','Vaga \'Mockup\' N# 42',142),(193,'2018-08-03 15:10:46',NULL,'9cae86d2-dcfe-4625-af9e-20d230e1f69d',0,'\0','Benefícios da Vaga 43','Descrição da Vaga 43','OPERATOR','FULLTIME',4221.00,4211.00,'Requerimentos da Vaga 43','Vaga \'Mockup\' N# 43',143),(194,'2018-08-03 15:10:46',NULL,'5b0b98b0-98f2-44d6-8b51-0fbd67a0ff86',0,'\0','Benefícios da Vaga 44','Descrição da Vaga 44','OPERATOR','TEMPORARY',4321.00,4311.00,'Requerimentos da Vaga 44','Vaga \'Mockup\' N# 44',144),(195,'2018-08-03 15:10:46',NULL,'30dc245a-8c41-4162-bf6f-3cdafa3c534c',0,'\0','Benefícios da Vaga 45','Descrição da Vaga 45','OPERATOR','FULLTIME',4421.00,4411.00,'Requerimentos da Vaga 45','Vaga \'Mockup\' N# 45',145),(196,'2018-08-03 15:10:46',NULL,'dc2ab3df-3ca4-4c77-9efc-208d84fd0a12',0,'\0','Benefícios da Vaga 46','Descrição da Vaga 46','OPERATOR','TEMPORARY',4521.00,4511.00,'Requerimentos da Vaga 46','Vaga \'Mockup\' N# 46',146),(197,'2018-08-03 15:10:46',NULL,'1271c3df-afa9-4ca1-ac43-6a1468a7b938',0,'\0','Benefícios da Vaga 47','Descrição da Vaga 47','OPERATOR','FULLTIME',4621.00,4611.00,'Requerimentos da Vaga 47','Vaga \'Mockup\' N# 47',147),(198,'2018-08-03 15:10:46',NULL,'662b2a4d-ee79-46df-b49a-64099723d4b0',0,'\0','Benefícios da Vaga 48','Descrição da Vaga 48','OPERATOR','TEMPORARY',4721.00,4711.00,'Requerimentos da Vaga 48','Vaga \'Mockup\' N# 48',148),(199,'2018-08-03 15:10:47',NULL,'807cdded-dae4-4072-be2a-67332b4e3b6f',0,'\0','Benefícios da Vaga 49','Descrição da Vaga 49','OPERATOR','FULLTIME',4821.00,4811.00,'Requerimentos da Vaga 49','Vaga \'Mockup\' N# 49',149),(200,'2018-08-03 15:10:47',NULL,'1a68ac2e-3202-4c3b-bcaa-83da8c7fde46',0,'\0','Benefícios da Vaga 50','Descrição da Vaga 50','OPERATOR','TEMPORARY',4921.00,4911.00,'Requerimentos da Vaga 50','Vaga \'Mockup\' N# 50',150);
/*!40000 ALTER TABLE `Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Member`
--

DROP TABLE IF EXISTS `Member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Member` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `occupation` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `shortText` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Member`
--

LOCK TABLES `Member` WRITE;
/*!40000 ALTER TABLE `Member` DISABLE KEYS */;
INSERT INTO `Member` (`id`, `createdAt`, `updatedAt`, `uuid`, `version`, `name`, `occupation`, `picture`, `shortText`) VALUES (331,'2018-08-03 15:10:57',NULL,'d95adc9c-ec28-48de-b671-dd8d683555ad',0,'FELIPE RODRIGUES MICHETTI','Fundador e Desenvolvedor','http://localhost/resources/images/members/felipe_140_140.jpg','Porque pagar por um conteúdo que você não tem certeza de sua verdade?');
/*!40000 ALTER TABLE `Member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Member_Medias`
--

DROP TABLE IF EXISTS `Member_Medias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Member_Medias` (
  `id` bigint(20) NOT NULL,
  `media` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  KEY `FKn5gwan53bkyqsp12v6l2xdp9q` (`id`),
  CONSTRAINT `FKn5gwan53bkyqsp12v6l2xdp9q` FOREIGN KEY (`id`) REFERENCES `Member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Member_Medias`
--

LOCK TABLES `Member_Medias` WRITE;
/*!40000 ALTER TABLE `Member_Medias` DISABLE KEYS */;
INSERT INTO `Member_Medias` (`id`, `media`, `url`) VALUES (331,'GitHub','https://github.com/frmichetti'),(331,'Linkedin','https://br.linkedin.com/pub/felipe-rodrigues-michetti/105/61/511');
/*!40000 ALTER TABLE `Member_Medias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resume`
--

DROP TABLE IF EXISTS `Resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Resume` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `content` longtext,
  `objective` varchar(255) DEFAULT NULL,
  `candidate_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q09lwlo5w6gem9lgdv2ttawd0` (`candidate_id`),
  CONSTRAINT `FKjmfhcmih6nw05pqco1480d0xf` FOREIGN KEY (`candidate_id`) REFERENCES `Candidate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resume`
--

LOCK TABLES `Resume` WRITE;
/*!40000 ALTER TABLE `Resume` DISABLE KEYS */;
/*!40000 ALTER TABLE `Resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resume_Educations`
--

DROP TABLE IF EXISTS `Resume_Educations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Resume_Educations` (
  `id` bigint(20) NOT NULL,
  `description` longtext,
  `endDate` date DEFAULT NULL,
  `qualification` longtext,
  `schoolName` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  KEY `FKedy1t2cnv7x3bk0w54o4lhf8y` (`id`),
  CONSTRAINT `FKedy1t2cnv7x3bk0w54o4lhf8y` FOREIGN KEY (`id`) REFERENCES `Resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resume_Educations`
--

LOCK TABLES `Resume_Educations` WRITE;
/*!40000 ALTER TABLE `Resume_Educations` DISABLE KEYS */;
/*!40000 ALTER TABLE `Resume_Educations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resume_Experiences`
--

DROP TABLE IF EXISTS `Resume_Experiences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Resume_Experiences` (
  `id` bigint(20) NOT NULL,
  `description` longtext,
  `employerName` varchar(255) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `jobTitle` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  KEY `FKatt2ujrahqii6kf212qatw9cg` (`id`),
  CONSTRAINT `FKatt2ujrahqii6kf212qatw9cg` FOREIGN KEY (`id`) REFERENCES `Resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resume_Experiences`
--

LOCK TABLES `Resume_Experiences` WRITE;
/*!40000 ALTER TABLE `Resume_Experiences` DISABLE KEYS */;
/*!40000 ALTER TABLE `Resume_Experiences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resume_Skills`
--

DROP TABLE IF EXISTS `Resume_Skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Resume_Skills` (
  `id` bigint(20) NOT NULL,
  `skillName` varchar(255) DEFAULT NULL,
  KEY `FKq4tcmyhtrs8mti3l7yrawpy73` (`id`),
  CONSTRAINT `FKq4tcmyhtrs8mti3l7yrawpy73` FOREIGN KEY (`id`) REFERENCES `Resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resume_Skills`
--

LOCK TABLES `Resume_Skills` WRITE;
/*!40000 ALTER TABLE `Resume_Skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `Resume_Skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Selective_Process`
--

DROP TABLE IF EXISTS `Selective_Process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Selective_Process` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `disabledAt` date DEFAULT NULL,
  `expire` date DEFAULT NULL,
  `maxCandidates` int(11) NOT NULL,
  `start` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `job_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2m8rh3jw7ok0uijik53xvv4od` (`job_id`),
  CONSTRAINT `FK2m8rh3jw7ok0uijik53xvv4od` FOREIGN KEY (`job_id`) REFERENCES `Job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Selective_Process`
--

LOCK TABLES `Selective_Process` WRITE;
/*!40000 ALTER TABLE `Selective_Process` DISABLE KEYS */;
/*!40000 ALTER TABLE `Selective_Process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Selective_Process_Candidates`
--

DROP TABLE IF EXISTS `Selective_Process_Candidates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Selective_Process_Candidates` (
  `sp_id` bigint(20) NOT NULL,
  `candidate_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sp_id`,`candidate_id`),
  UNIQUE KEY `UK_6rk75uffsj94tv6x1ksumqwoi` (`candidate_id`),
  CONSTRAINT `FKjlacjnrx56rewq6apew50rhmn` FOREIGN KEY (`sp_id`) REFERENCES `Selective_Process` (`id`),
  CONSTRAINT `FKr5pglmqrjhglc4hsvm1ji60ji` FOREIGN KEY (`candidate_id`) REFERENCES `Candidate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Selective_Process_Candidates`
--

LOCK TABLES `Selective_Process_Candidates` WRITE;
/*!40000 ALTER TABLE `Selective_Process_Candidates` DISABLE KEYS */;
/*!40000 ALTER TABLE `Selective_Process_Candidates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subscriber`
--

DROP TABLE IF EXISTS `Subscriber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Subscriber` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subscriber`
--

LOCK TABLES `Subscriber` WRITE;
/*!40000 ALTER TABLE `Subscriber` DISABLE KEYS */;
/*!40000 ALTER TABLE `Subscriber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Testimonial`
--

DROP TABLE IF EXISTS `Testimonial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Testimonial` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `picture` varchar(255) NOT NULL,
  `signature` varchar(255) NOT NULL,
  `text` longtext NOT NULL,
  `author_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKasf8y6eb53fox38v7ntbtkx41` (`author_id`),
  CONSTRAINT `FKasf8y6eb53fox38v7ntbtkx41` FOREIGN KEY (`author_id`) REFERENCES `Author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Testimonial`
--

LOCK TABLES `Testimonial` WRITE;
/*!40000 ALTER TABLE `Testimonial` DISABLE KEYS */;
INSERT INTO `Testimonial` (`id`, `createdAt`, `updatedAt`, `uuid`, `version`, `picture`, `signature`, `text`, `author_id`) VALUES (301,'2018-08-03 15:10:55',NULL,'6dbf2bbd-f6a7-49d6-a7d3-96a8c7ba3993',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',201),(302,'2018-08-03 15:10:55',NULL,'f0e9ff09-074b-42c1-9d7b-b23f04489ec4',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',202),(303,'2018-08-03 15:10:55',NULL,'8a1304bb-0199-4b16-b16b-405fce619d41',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',203),(304,'2018-08-03 15:10:55',NULL,'d4b4c914-7b3e-421f-a48d-248749127585',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',204),(305,'2018-08-03 15:10:55',NULL,'ff8e254b-304e-4d4b-a7d1-4e819148566f',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',205),(306,'2018-08-03 15:10:55',NULL,'90575aac-e0ad-4c3c-93cc-275d00542ef8',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',206),(307,'2018-08-03 15:10:55',NULL,'5753471d-007a-4c28-9912-deb1cff1a419',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',207),(308,'2018-08-03 15:10:55',NULL,'6072cc23-637e-4b6e-8ea6-17059c7a31d0',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',208),(309,'2018-08-03 15:10:55',NULL,'7bbf0d29-fa5a-4665-ac2b-ff3e02cabd2c',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',209),(310,'2018-08-03 15:10:55',NULL,'d14b502d-69fd-4dff-92f0-f8b8ee422e9a',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',210),(311,'2018-08-03 15:10:55',NULL,'b93d1664-e5a2-4f40-a1e0-d236791a6879',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',211),(312,'2018-08-03 15:10:55',NULL,'26b448d4-e893-4be4-b47c-f89bfbd0bec2',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',212),(313,'2018-08-03 15:10:56',NULL,'6fe2817a-db53-4c69-9c67-33357348bce5',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',213),(314,'2018-08-03 15:10:56',NULL,'60085672-b560-4f36-82ad-db7a1af1e80a',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',214),(315,'2018-08-03 15:10:56',NULL,'c787f604-b8ec-4c15-a66a-fc03d7c3dc22',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',215),(316,'2018-08-03 15:10:56',NULL,'7aeca3b3-d76c-4476-b020-3b412121b0da',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',216),(317,'2018-08-03 15:10:56',NULL,'86b43104-1d97-4e91-b982-237983edbac4',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',217),(318,'2018-08-03 15:10:56',NULL,'531eb040-64d1-4fef-b400-f0649fd829c0',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',218),(319,'2018-08-03 15:10:56',NULL,'f925f144-2fc4-4ae2-97f2-a75848e798fd',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',219),(320,'2018-08-03 15:10:56',NULL,'a8eae52e-f290-4b3a-8a6f-aca8d72a1f8c',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',220),(321,'2018-08-03 15:10:56',NULL,'fd77fc90-b62d-4871-b20d-6f61350b4994',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',221),(322,'2018-08-03 15:10:56',NULL,'7fab72d1-43ca-4a67-80d5-37608500ace3',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',222),(323,'2018-08-03 15:10:56',NULL,'e4b9ca08-dffc-4318-b7ff-adf12b8da98d',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',223),(324,'2018-08-03 15:10:56',NULL,'a5ef9fcf-1d0a-46b7-ba58-865e900f7696',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',224),(325,'2018-08-03 15:10:57',NULL,'55d8bd0e-0d9b-4b7a-adcf-7757b89ad922',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',225),(326,'2018-08-03 15:10:57',NULL,'f7ccb69c-75a9-4f46-98fd-ff8a961491dc',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',226),(327,'2018-08-03 15:10:57',NULL,'68494199-801d-4cda-953b-49b2727da347',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',227),(328,'2018-08-03 15:10:57',NULL,'81d61a43-9476-4d89-af00-f5a027e9a04f',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',228),(329,'2018-08-03 15:10:57',NULL,'195f918e-9907-427f-81d3-6694c03e96cb',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',229),(330,'2018-08-03 15:10:57',NULL,'a720973a-504a-4283-bccf-5c5b7a24f325',0,'http://localhost/resources/placeholder/140x140.jpg','Assinatura Aqui','Conteúdo Aqui',230);
/*!40000 ALTER TABLE `Testimonial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firebaseMessageToken` varchar(255) NOT NULL,
  `firebaseUUID` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` (`id`, `createdAt`, `updatedAt`, `uuid`, `version`, `active`, `email`, `firebaseMessageToken`, `firebaseUUID`) VALUES (1,'2018-08-03 15:10:29',NULL,'d2e7d760-f40d-432f-9a11-d9a5b315443d',0,'\0','mockupusernumber1@test.com','03078445-2a2c-4558-a9ee-07505732b335','5a3129a4-4c31-4496-8448-b09890e96541'),(2,'2018-08-03 15:10:29',NULL,'02a5ecfc-77e2-43c1-b70c-a85e5e41c132',0,'\0','mockupusernumber2@test.com','5ac6491b-7c46-4493-8875-44963b3dc493','d42b273d-ae76-4635-b964-1124b0dcd243'),(3,'2018-08-03 15:10:29',NULL,'273a24bd-8790-4a96-84c8-b5b02dc3a469',0,'\0','mockupusernumber3@test.com','d8b69306-59dd-4bf3-8c48-98296b9f170a','bc4889bf-f9df-4e92-a7bd-5ffedbd7f584'),(4,'2018-08-03 15:10:30',NULL,'b6092c7d-1256-4c4d-9ddb-2ee6cbe9012f',0,'\0','mockupusernumber4@test.com','64427553-d0c7-44ea-a66a-93c35ca9ce36','0d093b8d-df62-4057-8803-8a3a2226440d'),(5,'2018-08-03 15:10:30',NULL,'7a1fdb8e-3426-4b21-994f-7398190160d3',0,'\0','mockupusernumber5@test.com','3a45fab1-5ed2-4bf9-9c54-8e3760299ed7','869623dd-8739-49c7-b903-253a84f583c8'),(6,'2018-08-03 15:10:30',NULL,'cf92c135-f4e3-4703-b71e-30be2e87da11',0,'\0','mockupusernumber6@test.com','9b71b842-a477-4b44-b98e-a2a354e8c962','25fcd070-c417-4787-93d1-d3cb0a0fc1db'),(7,'2018-08-03 15:10:30',NULL,'adba2eb7-2671-424f-a342-7a24a70b47bf',0,'\0','mockupusernumber7@test.com','37b94555-7a68-4fa4-9031-33827eaf296e','e02328b3-148f-47dd-afa4-09f9713270b6'),(8,'2018-08-03 15:10:30',NULL,'848881bc-7307-442c-bda7-0a57acbb61f2',0,'\0','mockupusernumber8@test.com','41741424-b51b-4bb3-90ab-864a6ce53902','152288bf-e277-4a5b-9622-37a96e396412'),(9,'2018-08-03 15:10:30',NULL,'a90d9272-9d5b-42ae-bd66-8b1484ae5971',0,'\0','mockupusernumber9@test.com','e4bf5f41-c3c5-4f0d-a9ef-4d856c186d7e','8d8d93e6-ac81-47c6-98ae-c80abaf309aa'),(10,'2018-08-03 15:10:30',NULL,'19c905ae-2d72-4ed3-9fa4-963d339b36a8',0,'\0','mockupusernumber10@test.com','2a8fb457-3677-47c8-a856-8654ed3b4a99','d47e5b33-27f9-4c53-9db0-b0177389f04d'),(11,'2018-08-03 15:10:30',NULL,'2a7d549a-b5e3-4374-aa60-429fe536e4b1',0,'\0','mockupusernumber11@test.com','f8f279b8-5e75-4c1c-b4ad-9ac79898cbe3','5dfcd2e4-a717-40f1-b3d7-c7e6426c2093'),(12,'2018-08-03 15:10:30',NULL,'07c19f83-571f-46cf-8db0-8a09ab439c0f',0,'\0','mockupusernumber12@test.com','01846f9a-6922-4146-9765-5bfe005ecc7a','76ee4087-4816-40b1-994c-0af44b435c43'),(13,'2018-08-03 15:10:30',NULL,'d81b0ac2-6fdd-4ef4-a98c-41f7bae781f7',0,'\0','mockupusernumber13@test.com','43e9abc4-30e6-41e4-8f00-45ebe123c372','f8b788e3-6152-42c5-b356-8e8b7624f1e6'),(14,'2018-08-03 15:10:30',NULL,'94ed3026-72eb-477c-bfde-b3169a21ff8a',0,'\0','mockupusernumber14@test.com','8f6ff597-4bb7-4f2e-900b-420d47bbae78','433fccf0-469f-4212-9e5f-b0cba3fbb1ed'),(15,'2018-08-03 15:10:30',NULL,'079e34f6-e8cb-478d-97f8-92f159c9158c',0,'\0','mockupusernumber15@test.com','bcb1583c-7d8a-4958-ba21-e66d84a74d45','17ff6539-6304-498c-96bd-57a9a4f8ab2e'),(16,'2018-08-03 15:10:31',NULL,'483ed935-d9db-4ed5-b016-1c760281b46a',0,'\0','mockupusernumber16@test.com','bb7653cc-b045-4d05-ad2c-7d9bb6170aa1','d3bd33a4-725f-457a-912a-ef5101ed817e'),(17,'2018-08-03 15:10:31',NULL,'756ffb7a-e4b9-4d9c-8653-d108884f9147',0,'\0','mockupusernumber17@test.com','f463ce3a-b896-4722-a180-c6b266365a43','98edb862-de5f-4fc9-b7f1-7dce22c3658a'),(18,'2018-08-03 15:10:31',NULL,'ff45f476-f38d-489c-bbd5-611d42bb8777',0,'\0','mockupusernumber18@test.com','2df78ba8-b033-4171-b16c-cea0847be85e','fa819884-4c0e-4ae5-8e3f-ba70d226c026'),(19,'2018-08-03 15:10:31',NULL,'62d87d03-689f-418d-b660-2ea139409f92',0,'\0','mockupusernumber19@test.com','e8376716-4059-431f-9ff5-74324b74fef3','131e1788-c2a4-45b0-9b33-f6f1e04a5f74'),(20,'2018-08-03 15:10:31',NULL,'8626527f-b1ec-4c47-bcec-03a4fe0b48f3',0,'\0','mockupusernumber20@test.com','333fbd6b-f553-4efc-8058-afc4e6d0a205','b9e76783-1ca8-451e-9802-001e22138089'),(21,'2018-08-03 15:10:31',NULL,'626f99a4-01e5-4e87-b774-086e58817470',0,'\0','mockupusernumber21@test.com','03f56acc-9008-4e4b-afb0-99e8a48ac6ac','0f00c42d-1823-4bda-8e3a-38887cdba4a8'),(22,'2018-08-03 15:10:31',NULL,'5c0ae94c-67fc-4afe-8c01-e5bd2907f005',0,'\0','mockupusernumber22@test.com','d9994236-65b9-43cf-b45a-541665248ed2','37741fc9-76ac-49ad-a130-683ad81bff11'),(23,'2018-08-03 15:10:31',NULL,'bc8942f3-885b-41a7-b28d-9c74504d67e6',0,'\0','mockupusernumber23@test.com','880ba4d1-59ba-4f93-b56b-b9d8b36fa9eb','1a4a9d09-3424-41c3-9da8-933fa4659b29'),(24,'2018-08-03 15:10:31',NULL,'4d62b808-1103-4763-a46f-25c7a18860ed',0,'\0','mockupusernumber24@test.com','ce2d090c-5eed-4a2e-b4eb-d83a81c8f2ac','8ea4d816-650b-4faf-ae2a-edfb2f0a14e5'),(25,'2018-08-03 15:10:31',NULL,'b43cb82c-fbe4-41de-b440-c3406b3ad730',0,'\0','mockupusernumber25@test.com','8f581ad9-1fcc-4c5a-aeef-792c1d2cc29c','d9a2498b-2ac7-47b5-a085-3ca37b1ec0c4'),(26,'2018-08-03 15:10:31',NULL,'7ac85d48-5477-438b-ae61-e81ad5594e97',0,'\0','mockupusernumber26@test.com','84688049-6626-4e3b-b2c4-9e396c858f12','f9f2e688-c58a-496f-97c3-2135bac6d686'),(27,'2018-08-03 15:10:31',NULL,'dd9a3883-bf2f-4572-800b-662bb1cbecb9',0,'\0','mockupusernumber27@test.com','9e071c8a-335f-41de-a202-301c51da6bed','00fd641c-d5b0-46e4-aaf1-b9062473852e'),(28,'2018-08-03 15:10:31',NULL,'a58ea55f-4f9a-4d61-93d7-523ae836f6ad',0,'\0','mockupusernumber28@test.com','fefa039c-a04c-46e3-bafb-849c4911a23f','76ff6736-3099-4fcb-a5c7-aacb955aa18b'),(29,'2018-08-03 15:10:32',NULL,'016bfaf0-7d33-4b35-96e3-8889224764df',0,'\0','mockupusernumber29@test.com','6c77e591-692f-469c-bfee-1b9888b72cdf','a899c875-8f68-44e8-b65f-c57576c5c2cf'),(30,'2018-08-03 15:10:32',NULL,'22e793e7-3f92-4943-9db0-be8b99ace2e1',0,'\0','mockupusernumber30@test.com','192fbb0e-4076-43d3-89d2-be21a49fb7bd','99155b7c-a18f-4ad5-8877-b53216aba416'),(31,'2018-08-03 15:10:32',NULL,'90f47c89-62ca-41cc-ad5b-c7e4c405de1a',0,'\0','mockupusernumber31@test.com','f34d0735-0d5f-4492-b927-ddfd67eea763','202eebc7-00c7-4832-8ad5-18ec1ba0ceef'),(32,'2018-08-03 15:10:32',NULL,'37919739-927b-474f-92bf-563003443d2a',0,'\0','mockupusernumber32@test.com','af4c3b67-1158-44f9-a5ce-fa09da3c5f94','c8756543-4afc-450c-b1a0-e47967833631'),(33,'2018-08-03 15:10:32',NULL,'24fd9623-7fbc-4f9e-8377-31e70133d201',0,'\0','mockupusernumber33@test.com','dd713427-a63f-40f2-bc05-2a9270dbb016','ee9dcbbd-b163-4385-b4a2-1b0834e7a2fe'),(34,'2018-08-03 15:10:32',NULL,'a400ad1e-7d17-47c9-aa1d-de2598953115',0,'\0','mockupusernumber34@test.com','4be1e640-b045-418f-83f1-fbc7fff26924','4f229ac7-4311-42f0-826f-e96cd90c1b9b'),(35,'2018-08-03 15:10:32',NULL,'1ddaf792-6936-4d0d-92af-41f3ad27f67e',0,'\0','mockupusernumber35@test.com','d46f454f-b514-4d0e-9fec-6ff9715aea63','89e8bc9a-d7b8-4ca5-aa72-e5eb71472f57'),(36,'2018-08-03 15:10:32',NULL,'e3242ddb-4a0c-40ba-b2e3-c778d29e6cb4',0,'\0','mockupusernumber36@test.com','368a0ec7-7695-4d02-af90-c3275b7e035d','97a988f4-7951-42be-9699-983e2e896fd7'),(37,'2018-08-03 15:10:32',NULL,'61e611da-8aa5-485f-a1d1-3edc92300244',0,'\0','mockupusernumber37@test.com','ae61da47-c792-4c34-9a8d-e3aa7e84b68a','324fab7a-47a7-40de-b7a2-2979a51816e1'),(38,'2018-08-03 15:10:32',NULL,'d9926bf4-9c28-40a2-bcbb-4cdebce35435',0,'\0','mockupusernumber38@test.com','365f809d-2da2-4781-a630-d873298ab420','a2e72eba-d1b9-462c-ae49-9b6c699292b4'),(39,'2018-08-03 15:10:32',NULL,'60581278-0a85-4a05-acbf-3fe084999c34',0,'\0','mockupusernumber39@test.com','dcb3e0f5-ff7e-4770-bba6-10a6a119ce0c','061cd919-4334-4d0a-9d6f-8634b90ce465'),(40,'2018-08-03 15:10:32',NULL,'f1421e36-bfe9-4e57-bc5d-c869fdd806dc',0,'\0','mockupusernumber40@test.com','868db08d-5c48-4e21-8ee0-ff5e62132903','ac5f8878-7fe4-42a6-ae93-cc4bef554188'),(41,'2018-08-03 15:10:32',NULL,'0de65ca6-1468-4627-94b6-4115855f38d5',0,'\0','mockupusernumber41@test.com','e4d0bb35-7a78-4be8-8468-78a952455d6d','e6e07870-9cd7-4c79-bfd7-ca3ff4a95c07'),(42,'2018-08-03 15:10:32',NULL,'c42cd52a-a982-44d8-be10-bb620f240d26',0,'\0','mockupusernumber42@test.com','feecee25-a765-4acb-8eae-0910bbcce9ff','37ccdf5a-f77e-4ca9-9c1b-8377aae27355'),(43,'2018-08-03 15:10:33',NULL,'7c88d3ab-36ea-48c8-9356-2cd2ea3d0913',0,'\0','mockupusernumber43@test.com','04ab02f4-d469-4359-a4cd-2a19d2b80949','69703250-697f-433a-b15f-0329efc74e9d'),(44,'2018-08-03 15:10:33',NULL,'b4764f33-cf2b-468b-bba2-c67d50f87a37',0,'\0','mockupusernumber44@test.com','712fca4e-568d-4e2c-a65c-5e8514893c9b','b78116b2-87ef-471c-b27a-47082c875440'),(45,'2018-08-03 15:10:33',NULL,'35d81d3f-5c50-4ee5-a80b-7e09b58e2d0d',0,'\0','mockupusernumber45@test.com','e5f651b7-4ed9-4368-90e3-9849d3e0d98e','b6b33fec-604b-4621-9c5e-b3f729239bc7'),(46,'2018-08-03 15:10:33',NULL,'eee560a2-a434-4426-8506-d75ca5c81ef2',0,'\0','mockupusernumber46@test.com','fe7d5db5-8d4e-4a64-b7ee-c158ddf74a47','88d34850-1692-48d5-977c-26a5de8d88b4'),(47,'2018-08-03 15:10:33',NULL,'5532143d-503f-434a-ab51-123612ebf241',0,'\0','mockupusernumber47@test.com','9d4bda67-11b8-4d6e-abe5-f0dba92907b5','cc9e3abf-d02a-4019-abd3-7e84bdbeb27f'),(48,'2018-08-03 15:10:33',NULL,'613132b3-1938-4fda-8452-6eebdd68fcb2',0,'\0','mockupusernumber48@test.com','2e2f0c8a-5987-40af-b640-c1c77e19ed2c','64029679-3ba7-4616-8ccb-56f6124bc014'),(49,'2018-08-03 15:10:33',NULL,'b354b383-c8c6-49a1-8793-b6e3adbd472f',0,'\0','mockupusernumber49@test.com','cfdcfac8-b297-4ad7-a4ab-38ce8d02f6e0','d0971494-8d76-46df-888d-7478f2a372dd'),(50,'2018-08-03 15:10:33',NULL,'40a9f82f-8a10-4ec4-8595-baed8755c116',0,'\0','mockupusernumber50@test.com','b9262a6d-720a-40d0-b39b-dd6d51f590c4','7de468ae-b87d-4b2f-9688-fa0bd6b98ed5'),(51,'2018-08-03 15:10:33',NULL,'eef61f21-4b21-4a26-9a44-cf0274000c3f',0,'\0','mockupusernumber51@test.com','c9e45e87-c85f-4948-bfbb-21617f80527a','ef90cfcf-bdc6-4e01-aec9-6bee9f679625'),(52,'2018-08-03 15:10:33',NULL,'34bb304d-b023-462c-894c-84c4204bf4d2',0,'\0','mockupusernumber52@test.com','5de9f4e1-1e5c-4e88-a536-8f8b01650c3d','15649f7d-7268-43c6-8bc3-63098418ef73'),(53,'2018-08-03 15:10:33',NULL,'f2ca801f-1081-4e3a-b0af-610a2e78023d',0,'\0','mockupusernumber53@test.com','0f8d9228-5f28-45f9-8e6b-c89adc4f95c7','b5a382f2-cbce-4a85-85b3-087cbd94141b'),(54,'2018-08-03 15:10:33',NULL,'22933cb3-4864-4d2c-8e3b-5635b2b6a6bf',0,'\0','mockupusernumber54@test.com','dd2622a1-0fee-4642-b116-ab34c9ab2151','db7bc18d-31f0-4148-882c-d8da0291eef0'),(55,'2018-08-03 15:10:33',NULL,'000d6207-04f4-4073-8880-a9ccecdf4abc',0,'\0','mockupusernumber55@test.com','a45a4158-3caf-4d69-860b-ffb10bf1711a','85c90f90-e380-4c6d-adbd-677dd63ac1b2'),(56,'2018-08-03 15:10:33',NULL,'47bbf482-ccdf-4ebb-a4ac-29ce6763a2c2',0,'\0','mockupusernumber56@test.com','278b03e7-c85d-4a61-82f7-c89039e356ce','9c1db434-e083-4ba7-acd1-289c239a32fe'),(57,'2018-08-03 15:10:34',NULL,'cc99839e-f399-4c26-a75f-e448b773d7ea',0,'\0','mockupusernumber57@test.com','5dec60c7-3c79-438c-b23f-8d5aab0c80eb','0d4eb2e9-d3a5-43b5-9fe2-9ac7c6da78c3'),(58,'2018-08-03 15:10:34',NULL,'d60f7d72-87db-4a2f-9454-196ebefc4ee8',0,'\0','mockupusernumber58@test.com','86da0cf9-a3a9-4ac1-b2bc-19f61c7574ae','25127bc8-7c1e-4033-90f0-6133569ee2df'),(59,'2018-08-03 15:10:34',NULL,'5ce9cb22-2662-4cec-b74b-a4b93909dfe6',0,'\0','mockupusernumber59@test.com','da42e0a3-b4eb-4a7f-97d5-1883799f962c','c1f5fe63-105a-42f2-97df-1228ee45a2a9'),(60,'2018-08-03 15:10:34',NULL,'289b2b1b-04bb-4309-a659-2f0149fe35e7',0,'\0','mockupusernumber60@test.com','42a1aa8e-f264-481e-8d59-4366d4dc4613','decb5fa4-2b3f-42b2-b75a-0b7fedae9651'),(61,'2018-08-03 15:10:34',NULL,'18a1809e-a5a5-4602-9bd7-afea02a5a9f2',0,'\0','mockupusernumber61@test.com','809b8bf3-deaf-4787-8c29-4d6fd158be3b','061a74fb-7c03-48ab-b843-3a82c5cc8eae'),(62,'2018-08-03 15:10:34',NULL,'82d821bc-b792-4d14-ba79-dd6ce808cc12',0,'\0','mockupusernumber62@test.com','bef2f0c3-c7fb-4e1a-8016-d65e16116816','222f4c4a-0a26-4a6a-8929-5c58aeb9b358'),(63,'2018-08-03 15:10:34',NULL,'4f4c4494-524f-47ec-8dc8-60d0ae78cb0b',0,'\0','mockupusernumber63@test.com','0ba92ffc-0d7a-4df5-ba00-9971cf7a9ba3','07e6aa7a-acb0-441b-9eb2-4c89d67e4306'),(64,'2018-08-03 15:10:34',NULL,'604f10f8-86b7-4ff0-94ff-a2d1da2a07eb',0,'\0','mockupusernumber64@test.com','79a746ec-60c3-454c-8add-ae26b46ddfc1','348cc22a-c56b-4b6e-944a-7efd5858d24c'),(65,'2018-08-03 15:10:34',NULL,'dac6a4e0-7e18-42db-bbb1-bb366688ef0a',0,'\0','mockupusernumber65@test.com','b8f323b9-d5be-43af-9742-f8572ac2f716','67a27cee-62f9-4048-8932-6201db5ec2ae'),(66,'2018-08-03 15:10:34',NULL,'b9336439-7340-4153-a64c-90cc6e1c6952',0,'\0','mockupusernumber66@test.com','a69ca1f5-6912-414c-9786-f4de7322f333','daf0e9be-ae6e-4ed5-ab23-b7aa1d674f76'),(67,'2018-08-03 15:10:34',NULL,'44cffb89-4f5a-4a5e-bda5-87664f136324',0,'\0','mockupusernumber67@test.com','b4d5b735-a2f5-4d45-9f17-dbb9aa8d80d4','c5d2ba74-3e0f-46be-a79a-d6b1424997d0'),(68,'2018-08-03 15:10:34',NULL,'9939776b-98c5-4679-847d-9d14bfd21a1d',0,'\0','mockupusernumber68@test.com','976deab0-cb75-4d27-a65a-ad4ebf0ea8b9','a139e3c5-3188-439c-8d71-fa8d086a8b95'),(69,'2018-08-03 15:10:34',NULL,'36d87758-7756-400a-a394-77e381162e46',0,'\0','mockupusernumber69@test.com','a1e33779-be3a-4cc9-94ec-0a6874b3bfb8','71ef11cf-60e1-43e2-9332-8efd39b6c314'),(70,'2018-08-03 15:10:35',NULL,'92677e5c-3c3d-4b8e-92cc-731630cd5466',0,'\0','mockupusernumber70@test.com','42efe69c-9e68-46ac-bf83-3f0ce1a3d5b7','1ceca5b6-7ade-4cad-9ad3-359dce44395e'),(71,'2018-08-03 15:10:35',NULL,'5efb2c20-b73d-47d9-9200-b22f0a74b006',0,'\0','mockupusernumber71@test.com','88e06987-1f7a-42b0-b0c1-6b749db6ca95','99a6a41d-13a0-4e13-9a91-d391b4f1fb07'),(72,'2018-08-03 15:10:35',NULL,'963937fa-be46-498d-bece-5160f876955e',0,'\0','mockupusernumber72@test.com','4f5cbede-e9dd-406a-b863-33262f64303b','b35714ef-6b80-4f93-8304-9b4673bbedf5'),(73,'2018-08-03 15:10:35',NULL,'54fee8b5-dd26-42f0-9f0f-26c0e084b5be',0,'\0','mockupusernumber73@test.com','b29e6b17-2b61-4038-998d-fb05025c79fc','a7cc8675-4685-46c8-896d-d282408eaad1'),(74,'2018-08-03 15:10:35',NULL,'ea184347-b039-45aa-a1fc-da2bb0477a01',0,'\0','mockupusernumber74@test.com','4d59e82d-8db5-4e28-8f22-2aab32cc5433','9ed93d29-7bf5-4cae-ac25-83beb2cd8e6b'),(75,'2018-08-03 15:10:35',NULL,'919e03b7-0963-4f79-9389-922d4211d202',0,'\0','mockupusernumber75@test.com','c7ea2f29-9ace-4294-9c94-b9fe9cd33c13','a1c3155b-5e51-402e-b0e3-27ebd8229015'),(76,'2018-08-03 15:10:35',NULL,'89752855-298d-4476-97b1-4dd229f59a2a',0,'\0','mockupusernumber76@test.com','8bdccf5e-ab10-4bb0-97c0-24f3280f274d','958891f2-643f-429a-a491-2edd7abda79e'),(77,'2018-08-03 15:10:35',NULL,'87ca1ecb-8232-40aa-9ed4-e938fe08dd42',0,'\0','mockupusernumber77@test.com','19d540cd-f48a-4754-ac72-ff9d8988e588','d5715254-ed60-45aa-b12e-dc2126d51339'),(78,'2018-08-03 15:10:35',NULL,'0229eca5-8f21-421f-83b6-7b90800e85b8',0,'\0','mockupusernumber78@test.com','bd2d99cc-99a4-4252-b565-33d226055a25','b45d3317-3fdb-4abf-b2fb-ecbfe76b13fb'),(79,'2018-08-03 15:10:35',NULL,'4f5fde45-55c2-46cc-9d60-489231213644',0,'\0','mockupusernumber79@test.com','d8c28f5f-ff73-48c2-9521-54ec248415b0','7ef902c2-6feb-4cc7-b3cf-cb8d431ad20d'),(80,'2018-08-03 15:10:35',NULL,'e073b587-78d7-497a-8d22-0eabebad8169',0,'\0','mockupusernumber80@test.com','05ae5464-99c6-47fb-acbf-6e266ea86232','bda4d098-62f5-4799-87b8-a17cf232d70f'),(81,'2018-08-03 15:10:35',NULL,'60c41ec2-f4fe-4a9c-a756-df484b07f414',0,'\0','mockupusernumber81@test.com','db67bab1-70a0-45af-8b5c-1be4daf00ff8','247e14d0-4aca-4aaf-9384-4ba9dde879e8'),(82,'2018-08-03 15:10:35',NULL,'7866aa43-9ee8-468e-9ade-ce5676009240',0,'\0','mockupusernumber82@test.com','2452c141-f104-4e63-b061-d003381c4be6','b2eb3a2e-aa1b-4f01-93f2-e64dd83756b6'),(83,'2018-08-03 15:10:35',NULL,'6baa8ad4-4f12-4274-af6a-2e1cf7d1ea9a',0,'\0','mockupusernumber83@test.com','e6fe9dde-041c-4e89-a5fc-bb3e3b698749','03755045-204f-4fef-a1e2-e143f65e3281'),(84,'2018-08-03 15:10:36',NULL,'54f8b17a-cd21-48c1-9241-f7e987ecd68c',0,'\0','mockupusernumber84@test.com','412a38a0-e26a-48f4-9a7b-cf77e4f5fc1f','db6b7221-902e-4c5b-b003-11c4bd2f34ff'),(85,'2018-08-03 15:10:36',NULL,'3162e74c-c7b4-4315-89b6-186e93bb398b',0,'\0','mockupusernumber85@test.com','2e5d0ae5-8d3e-4594-bdd6-1a9abe681525','6b7c3209-f4e3-4a6c-a779-894c3c25fec5'),(86,'2018-08-03 15:10:36',NULL,'d30130c7-f8d5-44ad-af1b-4ae9d2b0c4dc',0,'\0','mockupusernumber86@test.com','d423a89b-6c2b-4c55-8d56-e7e387b40458','ae7bd8aa-c7c7-46af-b049-650ad223ec3d'),(87,'2018-08-03 15:10:36',NULL,'82750da2-7e91-471b-bc08-2fa272b6851f',0,'\0','mockupusernumber87@test.com','145a61c6-bf47-4ddb-8093-bf235dea070d','94c13b4f-03c9-41e3-a3a3-4c79894ed3d7'),(88,'2018-08-03 15:10:36',NULL,'7246b904-d4fa-4225-88b3-42641fd64b4e',0,'\0','mockupusernumber88@test.com','f31f96c3-5c8a-45b3-957e-f17e27d02982','97d596a8-0839-444c-a2df-b42e75440940'),(89,'2018-08-03 15:10:36',NULL,'b13051a1-88f3-4a4c-8c91-797593887c33',0,'\0','mockupusernumber89@test.com','734c604d-de03-49f9-a5a2-4a2c2eb11839','43b8c262-73ee-4416-aa5e-ed65dadc9b4d'),(90,'2018-08-03 15:10:36',NULL,'67318ca1-34ef-4ac8-add9-adf3dacdd86c',0,'\0','mockupusernumber90@test.com','26f4179a-153e-4f83-be6a-366e4d1334fd','728a20fb-84ad-4e8d-ad31-1b15c81b0950'),(91,'2018-08-03 15:10:36',NULL,'fcfbae2e-1144-4d04-aed7-6cbd634d056d',0,'\0','mockupusernumber91@test.com','3679133a-f278-4b18-8e86-b955caea68ba','2f1dca47-9fdf-4ebd-8fff-8b172cd22b87'),(92,'2018-08-03 15:10:36',NULL,'aeb87e90-0312-4476-b285-66fc2cbc07a1',0,'\0','mockupusernumber92@test.com','c8454f4c-db4e-4fe9-ba0a-5fc50d5d7031','6e0a398f-9301-4fd3-9b85-dc562399567c'),(93,'2018-08-03 15:10:36',NULL,'3aefd3ee-674b-4fac-8647-6f44805ab7cf',0,'\0','mockupusernumber93@test.com','333a327c-9352-4c90-b517-492660260780','4c7ba7b9-e816-4fab-b478-8e50dc286aff'),(94,'2018-08-03 15:10:36',NULL,'36d8bfeb-7553-486e-bda5-d271b4356a90',0,'\0','mockupusernumber94@test.com','df81becd-70f0-424d-9add-d0608f5fb701','6a5e805b-ca59-4890-9100-1bce306f5274'),(95,'2018-08-03 15:10:36',NULL,'931edf15-a0aa-42c4-994f-c38d98911412',0,'\0','mockupusernumber95@test.com','d52e701a-d2bd-4362-af8a-9c68716e7c5c','bf23ecd9-fc87-434c-bcac-3114516e8164'),(96,'2018-08-03 15:10:36',NULL,'516e8c56-4604-47ff-bfd6-460bc27c1716',0,'\0','mockupusernumber96@test.com','6fb5411f-ddfe-46e4-a16a-156661240b6c','ad927d6f-dab3-4fde-996c-9b0a6c6b3d2a'),(97,'2018-08-03 15:10:36',NULL,'19d5d676-dbaf-4221-9367-0bbb7ab9a71c',0,'\0','mockupusernumber97@test.com','4fe8e8a7-7341-433b-89ff-3efb9534e948','a73a6cee-b7f3-45be-8c5b-15e1d480f51b'),(98,'2018-08-03 15:10:37',NULL,'6c3067e7-45c8-45ea-957b-da566462882d',0,'\0','mockupusernumber98@test.com','7962edc2-4bf4-4541-8081-2255e653a17b','8227e509-2b17-43c1-a92a-2cfe28c803bb'),(99,'2018-08-03 15:10:37',NULL,'c0b5d575-5134-4426-8b61-ee699a90df10',0,'\0','mockupusernumber99@test.com','0bc12fc6-790c-4952-8732-f26aa0fae235','4b105fb4-4fcb-47f6-87c3-d71b1457e0e8'),(100,'2018-08-03 15:10:37',NULL,'9faa048a-c9f1-428f-b3e7-21e4af84609d',0,'\0','mockupusernumber100@test.com','903bc063-c60f-4aa4-9100-3be1ac6bfc64','9841506a-0721-4ddc-bea9-94004bcc2822');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES (333),(333),(333),(333),(333),(333),(333),(333),(333),(333),(333),(333),(333);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-03 12:14:22
