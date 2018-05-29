-- MySQL dump 10.10
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.0.18-nt

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` float(8,2) default NULL,
  `author` varchar(100) default NULL,
  `path` varchar(100) default NULL,
  `filename` varchar(100) default NULL,
  `description` varchar(255) default NULL,
  `categoryId` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `category_id_fk` (`categoryId`),
  CONSTRAINT `category_id_fk` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--


/*!40000 ALTER TABLE `book` DISABLE KEYS */;
LOCK TABLES `book` WRITE;
INSERT INTO `book` VALUES ('0c3fad46-2b1a-49b3-bc65-ad45bbbe8fa1','Oracle',15.00,'何铭名','/2/7','4c73f27c-169a-408a-9838-de05bc3a772b.gif','卫生间有没有纸了','1d029f66-e17f-40b9-95c0-7a814c3424f4'),('0c5a1cb5-cbc7-483b-bf31-3f7f779c42f1','EJB中文版',10.00,'黎活明','/4/2','7bdb9e86-1911-4a3c-bd47-794e6b5fe99c.jpg','国内第一本中文EJB','2ee9d7f5-bf0b-4b5a-ae48-ad8612b38338'),('1ab63687-d86e-4859-b003-4b755ff623ae','JavaServerFaces',20.00,'王昭珽','/6/10','b689775f-6342-47e2-a57f-710a440a67fd.jpg','JSF框架入门经典','2ee9d7f5-bf0b-4b5a-ae48-ad8612b38338'),('48a5d142-d487-4fb7-8dff-61eb723b471f','Spring轻量级框架',10.00,'伍净','/4/12','9a85b392-17ff-452e-ba09-ce97719869da.gif','美女作家第一本畅销书','2ee9d7f5-bf0b-4b5a-ae48-ad8612b38338'),('58c60bd9-d805-425c-a62a-ef79aae0429d','JavaWeb深入体验开发',10.00,'张胜利','/9/8','2d357451-7b2e-4607-a2dc-2aaaae1477d9.gif','经典书籍','2ee9d7f5-bf0b-4b5a-ae48-ad8612b38338');
UNLOCK TABLES;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--


/*!40000 ALTER TABLE `category` DISABLE KEYS */;
LOCK TABLES `category` WRITE;
INSERT INTO `category` VALUES ('1d029f66-e17f-40b9-95c0-7a814c3424f4','数据库','Oracle\\mysql\\DBA相关书籍'),('2ee9d7f5-bf0b-4b5a-ae48-ad8612b38338','Java编程类','Java编程、有关框架书籍');
UNLOCK TABLES;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `actived` bit(1) default NULL,
  `code` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--


/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
LOCK TABLES `customer` WRITE;
INSERT INTO `customer` VALUES ('9555297f-7cdd-41d9-a4f4-28fbc42475f3','wj','123','110','湖南张家界','itheima14@163.com','','PVDUIP2W6U25IN3NXHDY3NC4QPZ285JW');
UNLOCK TABLES;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersnum` varchar(100) NOT NULL,
  `totalnum` int(11) default NULL,
  `totalprice` float(10,2) default NULL,
  `status` int(11) default NULL,
  `customerId` varchar(100) default NULL,
  PRIMARY KEY  (`ordersnum`),
  KEY `customer_id_fk` (`customerId`),
  CONSTRAINT `customer_id_fk` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--


/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
LOCK TABLES `orders` WRITE;
INSERT INTO `orders` VALUES ('2014070115453225961772085007',3,40.00,1,'9555297f-7cdd-41d9-a4f4-28fbc42475f3'),('2014070116170427853609553685',1,10.00,0,'9555297f-7cdd-41d9-a4f4-28fbc42475f3');
UNLOCK TABLES;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

--
-- Table structure for table `ordersitem`
--

DROP TABLE IF EXISTS `ordersitem`;
CREATE TABLE `ordersitem` (
  `id` varchar(100) NOT NULL,
  `num` int(11) default NULL,
  `price` float(10,2) default NULL,
  `bookId` varchar(100) default NULL,
  `ordersId` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `book_id_fk` (`bookId`),
  KEY `orders_id_fk` (`ordersId`),
  CONSTRAINT `book_id_fk` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`),
  CONSTRAINT `orders_id_fk` FOREIGN KEY (`ordersId`) REFERENCES `orders` (`ordersnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ordersitem`
--


/*!40000 ALTER TABLE `ordersitem` DISABLE KEYS */;
LOCK TABLES `ordersitem` WRITE;
INSERT INTO `ordersitem` VALUES ('a0231769-0467-42e1-a0d5-efebcf6265c7',2,30.00,'0c3fad46-2b1a-49b3-bc65-ad45bbbe8fa1','2014070115453225961772085007'),('c9706756-d8a2-4e46-854a-4292e6274c5f',1,10.00,'0c5a1cb5-cbc7-483b-bf31-3f7f779c42f1','2014070116170427853609553685'),('d148b203-f3e6-407d-8f88-81f16ccb1bb6',1,10.00,'0c5a1cb5-cbc7-483b-bf31-3f7f779c42f1','2014070115453225961772085007');
UNLOCK TABLES;
/*!40000 ALTER TABLE `ordersitem` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

