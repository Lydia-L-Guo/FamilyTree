/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : cfamilycontact

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2022-04-03 10:43:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc
-- ----------------------------
DROP TABLE IF EXISTS `doc`;
CREATE TABLE `doc` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc
-- ----------------------------

-- ----------------------------
-- Table structure for genealogy
-- ----------------------------
DROP TABLE IF EXISTS `genealogy`;
CREATE TABLE `genealogy` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `hall_name` varchar(255) DEFAULT NULL,
  `tag_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(0) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `cate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of genealogy
-- ----------------------------
INSERT INTO `genealogy` VALUES ('1', '刘氏族谱', '1', '虎头堂', null, '江苏苏州寒山', 'Lily', '2022-03-30 00:00:00', null, null, '0', '族谱', null);
INSERT INTO `genealogy` VALUES ('2', 'liulei族谱', '', '', '', '', 'liulei', '2022-04-02 00:00:00', '', '2022-04-02 00:00:00', '', '', '');
INSERT INTO `genealogy` VALUES ('3', 'liulei族谱', '', '', '', '', 'liulei', '2022-04-02 00:00:00', '', '2022-04-02 00:00:00', '', '', '');
INSERT INTO `genealogy` VALUES ('4', 'liulei族谱', '', '', '', '', 'liulei', '2022-04-02 00:00:00', '', '2022-04-02 00:00:00', '', '', '');

-- ----------------------------
-- Table structure for individual
-- ----------------------------
DROP TABLE IF EXISTS `individual`;
CREATE TABLE `individual` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `genealogy_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `ad_birth` varchar(11) DEFAULT NULL,
  `ad_death` varchar(11) DEFAULT NULL,
  `spouse` varchar(255) DEFAULT NULL,
  `father_id` varchar(255) DEFAULT NULL,
  `mother_id` varchar(255) DEFAULT NULL,
  `generation` int(11) DEFAULT NULL,
  `ranks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `prefix_name` varchar(255) DEFAULT NULL,
  `title_name` varchar(255) DEFAULT NULL,
  `common_name` varchar(255) DEFAULT NULL,
  `line_name` varchar(255) DEFAULT NULL,
  `ce_birth` varchar(255) DEFAULT NULL,
  `ce_death` varchar(255) DEFAULT NULL,
  `alive_flag` varchar(255) DEFAULT NULL,
  `show_flag` varchar(255) DEFAULT NULL,
  `biography` varchar(255) DEFAULT NULL,
  `epitaph` varchar(255) DEFAULT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `death_place` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_by` varchar(0) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of individual
-- ----------------------------
INSERT INTO `individual` VALUES ('1', '1', '刘', '天', '男', null, null, '4#9', '2', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `individual` VALUES ('2', '1', '刘', '地', '男', null, null, null, '3', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `individual` VALUES ('3', '1', '刘', '玄', '男', null, null, null, '6', null, '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `individual` VALUES ('5', '1', '张', '黄', '女', null, null, '1', '', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `individual` VALUES ('6', '1', '刘', '宇', '男', null, null, null, '8', '', '-2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `individual` VALUES ('7', '1', '刘', '宙', '男', null, null, null, '10', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `individual` VALUES ('8', '1', '刘', '洪', '男', '1899年3月15日', '1939年3月15日', null, null, null, '-3', '老大', '图', null, '', '额', null, null, 'null', null, '“初从文，三年不中；后习武，校场发一矢，中考官，乱棒逐之出；遂学医，有所成。自撰一良方，服之，卒', '“初从文，三年不中；后习武，校场发一矢，中考官，乱棒逐之出；遂学医，有所成。自撰一良方，服之，卒', '内蒙', '新疆', null, null, null, null, null);
INSERT INTO `individual` VALUES ('9', '1', '吴', '荒', '女', '1939年3月15日', '1999年3月15日', null, null, null, '1', '', '', null, '层次', null, null, null, '1', null, 'bdhd', '', '', '', null, null, null, null, null);
INSERT INTO `individual` VALUES ('10', '1', '刘', '日', '男', null, null, null, '6', null, '-1', '', '', null, '', null, null, null, '1', null, 'going', '', '', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('11', '1', '刘', '月', '女', null, null, null, null, '9', '2', '', '凯', null, '界面', '', null, null, '0', null, '', '', '河北张家口', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('17', '1', '赵', '盈', '女', null, null, null, null, '11', '3', '老小', '破', null, '你好', '', null, null, '1', null, '公共', '所以', '河北张家口', '丛林', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('18', '1', '木', '仄', '女', null, null, null, '8', '23', '-2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `individual` VALUES ('19', '1', '赵', '辰', '男', null, null, '', '', '20', '2', '老大', '组长', null, '', '公共', null, null, '0', null, '', '', '天津', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('20', '1', '刘', '宿', '女', null, null, '', '7', '', '1', '老大', '四', null, '', '告', null, null, '0', null, '', '', '北京市昌平区', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('21', '1', '刘', '列', '男', null, null, '', '', '5', '2', '老大', '告', null, '', '高', null, null, '0', null, '', '', '北极熊', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('22', '1', '陈', '张', '男', null, null, '17', '', '', '3', '', '', null, '', '', null, null, '0', null, '', '', '北京市昌平区', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('23', '1', '米', '寒', '女', '1856年3月', '1899年5月', null, '', '', '-3', '', '', null, '', '', null, null, '1', null, '', '', '', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('31', '2', null, null, null, null, null, null, null, null, '1', null, null, null, 'liulei', null, null, null, null, null, null, null, null, null, null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('33', '3', null, null, null, null, null, null, null, null, '1', null, null, null, 'liulei', null, null, null, null, null, null, null, null, null, null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('34', '1', '刘', '来', '男', '', '', '', '22', '', '4', '', '五', null, '', '刘', null, null, '0', null, '', '', '北京市昌平区五', '', null, '0', null, '0', null);
INSERT INTO `individual` VALUES ('35', '4', null, null, null, null, null, null, null, null, '1', null, null, null, 'liulei', null, null, null, null, null, null, null, null, null, null, '0', null, '0', null);

-- ----------------------------
-- Table structure for userlist
-- ----------------------------
DROP TABLE IF EXISTS `userlist`;
CREATE TABLE `userlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `inId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlist
-- ----------------------------
INSERT INTO `userlist` VALUES ('1', 'Lily', 'aaaaaa', '1');
INSERT INTO `userlist` VALUES ('10', 'liulei', 'aaaaaa', '7');
