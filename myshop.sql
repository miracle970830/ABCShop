/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50737
Source Host           : localhost:3306
Source Database       : myshop

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-09-03 19:32:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_adminuser
-- ----------------------------
DROP TABLE IF EXISTS `tb_adminuser`;
CREATE TABLE `tb_adminuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ausername` varchar(50) NOT NULL,
  `apassword` varchar(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_adminuser
-- ----------------------------
INSERT INTO `tb_adminuser` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `tb_adminuser` VALUES ('2', 'test', '4297f44b13955235245b2497399d7a93');
INSERT INTO `tb_adminuser` VALUES ('3', '123', '202cb962ac59075b964b07152d234b70');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) NOT NULL,
  `goprice` double NOT NULL,
  `grprice` double NOT NULL,
  `gstore` int(11) NOT NULL,
  `gpicture` varchar(200) DEFAULT NULL,
  `goodstype_id` int(11) NOT NULL,
  `iputtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `goodstype_id` (`goodstype_id`) USING BTREE,
  CONSTRAINT `tb_goods_ibfk_1` FOREIGN KEY (`goodstype_id`) REFERENCES `tb_goodstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('4', '海尔冰箱', '2800', '2750', '600', 'http://localhost:8080/views/upload/bc092b82-e070-462b-a291-304bd48c6a0d.png', '1', '2019-04-04 16:32:54');
INSERT INTO `tb_goods` VALUES ('5', 'Java入门', '100', '99', '7777', 'http://localhost:8080/views/upload/ec65e19d-9033-4c5d-be71-19fbc6235344.jpg', '4', '2019-04-09 19:09:49');

-- ----------------------------
-- Table structure for tb_goodstype
-- ----------------------------
DROP TABLE IF EXISTS `tb_goodstype`;
CREATE TABLE `tb_goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_goodstype
-- ----------------------------
INSERT INTO `tb_goodstype` VALUES ('1', '家电');
INSERT INTO `tb_goodstype` VALUES ('2', '手机');
INSERT INTO `tb_goodstype` VALUES ('3', '食品');
INSERT INTO `tb_goodstype` VALUES ('4', '电脑');
INSERT INTO `tb_goodstype` VALUES ('5', '最代码');
