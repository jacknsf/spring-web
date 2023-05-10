CREATE DATABASE `mybatis`;
USE `mybatis`;

CREATE TABLE `user`(
	`id` INT(20) NOT NULL,
	`name` VARCHAR(30) DEFAULT NULL,
	`pwd` VARCHAR(30) DEFAULT NULL,
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `user`(`id`,`name`,`pwd`) VALUES
(1,'Taksis','123456'),
(2,'Amel','abcdef'),
(3,'Silvanst','987654');