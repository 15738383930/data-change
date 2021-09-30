/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : data-change

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2021-09-30 13:55:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stars_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `stars_dictionary`;
CREATE TABLE `stars_dictionary` (
  `stars_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `stars_code` varchar(255) DEFAULT NULL COMMENT '字段代码',
  `stars_value` varchar(255) DEFAULT NULL COMMENT '字段值',
  `stars_name` varchar(255) DEFAULT NULL COMMENT '字段名',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父节点ID',
  PRIMARY KEY (`stars_id`)
) ENGINE=InnoDB AUTO_INCREMENT=603 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='**字典表';

-- ----------------------------
-- Records of stars_dictionary
-- ----------------------------
INSERT INTO `stars_dictionary` VALUES ('594', null, '女朋友', 'starsGirlfriend', '0');
INSERT INTO `stars_dictionary` VALUES ('595', '1', '安静', 'type', '594');
INSERT INTO `stars_dictionary` VALUES ('596', '2', '火辣', 'type', '594');
INSERT INTO `stars_dictionary` VALUES ('597', '3', '清爽', 'type', '594');
INSERT INTO `stars_dictionary` VALUES ('598', '1', '牛奶', 'favoriteFood', '594');
INSERT INTO `stars_dictionary` VALUES ('599', '2', '香蕉', 'favoriteFood', '594');
INSERT INTO `stars_dictionary` VALUES ('600', '3', '香肠', 'favoriteFood', '594');
INSERT INTO `stars_dictionary` VALUES ('601', '4', '黄瓜', 'favoriteFood', '594');
INSERT INTO `stars_dictionary` VALUES ('602', '5', '火锅', 'favoriteFood', '594');
