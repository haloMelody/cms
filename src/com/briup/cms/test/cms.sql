# Host: localhost  (Version 5.1.40-community)
# Date: 2016-05-12 20:55:43
# Generator: MySQL-Front 5.3  (Build 5.26)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tbl_category"
#

CREATE TABLE `tbl_category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tbl_category"
#


#
# Structure for table "tbl_article"
#

CREATE TABLE `tbl_article` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `publisurDate` datetime DEFAULT NULL,
  `clickTimes` int(11) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE98595751BE9EB4C` (`category_id`),
  CONSTRAINT `FKE98595751BE9EB4C` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tbl_article"
#

