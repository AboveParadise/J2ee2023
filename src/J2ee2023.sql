-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: javaee
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `page` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `publish_house` varchar(255) DEFAULT NULL,
  `publish_time` datetime(6) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'盐野七生','XKR000001','《希腊人的故事》',300,61,'光明日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(2,'陈寿','CS20200728','《三国志》',200,21,'光明日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(3,'罗贯中','SGYY20200728','《三国演义》',200,22,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(4,'吴承恩','XYJ20200728','《西游记》',600,23,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(5,'曹雪芹','HLM20200728','《红楼梦》',800,23,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(6,'司马迁','SJ20200728','《史记》',400,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(7,'施耐庵','SHZ20200728','《水浒传》',400,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(8,'郭敬明','XSD20200728','《小时代/刺金时代》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(9,'佚名','XSD20200728','《山海经》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(10,'金庸','YTTL20200728','《倚天屠龙记》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(11,'金庸','YTTL20200729','《倚天屠龙记2》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(12,'金庸','YTTL20200730','《倚天屠龙记3》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(13,'金庸','YTTL20200731','《倚天屠龙记4》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(14,'金庸','YTTL20200732','《倚天屠龙记5》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(15,'金庸','YTTL20200733','《倚天屠龙记6》',200,33,'人民日报出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(16,'金庸','TLBB20200733','《天龙八部》',200,34,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(17,'金庸','TLBB20200734','《天龙八部2》',200,34,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(18,'金庸','TLBB20200735','《天龙八部3》',200,34,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(19,'金庸','TLBB20200736','《天龙八部4》',200,34,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(20,'金庸','TLBB20200737','《天龙八部5》',200,35,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(21,'刘同','DBS20200737','《当悲伤逆流成河》',200,35,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(22,'九把刀','NXN20200737','《那些年我们一起追过的女孩》',200,35,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(23,'鲁迅','KRRJ20200737','《狂人日记》',200,35,'光线传媒出版社','2020-07-15 20:20:06.523000',100,'文化、科学、教育、体育'),(24,'鲁迅','NH20200737','《呐喊》',200,35,'光线传媒出版社','2020-07-15 20:20:06.523000',99,'文化、科学、教育、体育'),(25,'安妮','JA20200737','《简爱》',200,35,'光线传媒出版社','2020-07-15 20:20:06.523000',99,'文化、科学、教育、体育');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `profile_pic` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `identity` int DEFAULT NULL,
  `is_admin` int DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `balance` int DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'SH','prof','2002-10-10','189452@163.com',1,1,'administer','123',5,'15984632177','admin'),(2,'BJDY','prof1','1998-11-11','sdf5858@163.com',1,1,'student','123',5,'14785692253','stu');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-05 20:31:42
