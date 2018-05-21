-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE customer;

-- 切换到customer数据库
use customer;

-- 建表
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据
INSERT INTO customer(name,gender,phone,email,description)
  VALUES ('小明','男','13723232333','小明@126.com','我是小明'),
          ('小红','女','15689897568','小红@126.com','我是小红'),
          ('张飞','男','15826547965','张飞@126.com','我是张飞'),
          ('关羽','男','13621214896','关羽@126.com','我是关羽'),
          ('刘备','男','12345678910','刘备@126.com','我是刘备');
