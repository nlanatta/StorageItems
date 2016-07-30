# StorageItems
Example Spring Hibernate Gradle project

Panel Admin to add, edit, delete and list items
Items:
Name, Description, Image.
DB used Mysql.

/////////////////
CREATE DATABASE IF NOT EXISTS `db_items_storage`;
USE `db_items_storage`;

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(30) NOT NULL,
  `STOCK_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
////////////////

Index page:  /
