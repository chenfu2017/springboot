/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.23 : Database - assistant
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`assistant` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `assistant`;

/*Table structure for table `coordinate` */

DROP TABLE IF EXISTS `coordinate`;

CREATE TABLE `coordinate` (
  `id` varchar(20) NOT NULL,
  `longtitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `coordinate` */

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `driverid` varchar(20) NOT NULL,
  `temperature` int(11) DEFAULT NULL,
  `humidity` int(11) DEFAULT NULL,
  `energy` int(11) DEFAULT NULL,
  PRIMARY KEY (`driverid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `driver` */

/*Table structure for table `mession` */

DROP TABLE IF EXISTS `mession`;

CREATE TABLE `mession` (
  `policeid` varchar(20) NOT NULL,
  `driverid` varchar(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`policeid`,`driverid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mession` */

/*Table structure for table `police` */

DROP TABLE IF EXISTS `police`;

CREATE TABLE `police` (
  `policeid` varchar(20) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`policeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `police` */

insert  into `police`(`policeid`,`nickname`,`password`) values 
('driver','zz','123456'),
('zhangsan','qwewqe','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
