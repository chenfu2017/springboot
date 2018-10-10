/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.22-log : Database - assistant
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

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `driverid` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `carnumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`driverid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `driver` */

/*Table structure for table `drivermsg` */

DROP TABLE IF EXISTS `drivermsg`;

CREATE TABLE `drivermsg` (
  `driverid` varchar(20) NOT NULL,
  `longtitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `temperature` int(11) DEFAULT NULL,
  `humidity` int(11) DEFAULT NULL,
  `energy` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`driverid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `drivermsg` */

/*Table structure for table `mession` */

DROP TABLE IF EXISTS `mession`;

CREATE TABLE `mession` (
  `policeid` varchar(20) NOT NULL,
  `driverid` varchar(20) NOT NULL,
  `finish` tinyint(1) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`policeid`,`driverid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mession` */

insert  into `mession`(`policeid`,`driverid`,`finish`,`create_time`) values 
('police','driver',0,'2018-10-10 19:24:49');

/*Table structure for table `police` */

DROP TABLE IF EXISTS `police`;

CREATE TABLE `police` (
  `policeid` varchar(20) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `organization` varchar(50) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`policeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `police` */

insert  into `police`(`policeid`,`sex`,`address`,`organization`,`nickname`,`password`) values 
('police',NULL,NULL,NULL,'zz','123456'),
('zhangsan',NULL,NULL,NULL,'qwewqe','123456');

/*Table structure for table `policemsg` */

DROP TABLE IF EXISTS `policemsg`;

CREATE TABLE `policemsg` (
  `policeid` varchar(20) NOT NULL,
  `longtitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`policeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `policemsg` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
