/*
Navicat MySQL Data Transfer

Source Server         : 123456
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : gxyl

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-02 16:58:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attach`
-- ----------------------------
DROP TABLE IF EXISTS `attach`;
CREATE TABLE `attach` (
  `attachAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `newsAutoid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `fileName` varchar(50) DEFAULT NULL,
  `filePath` varchar(50) DEFAULT NULL,
  `fileSize` int(11) DEFAULT NULL,
  PRIMARY KEY (`attachAutoid`),
  KEY `fk_news_id` (`newsAutoid`) USING BTREE,
  CONSTRAINT `attach_ibfk_1` FOREIGN KEY (`newsAutoid`) REFERENCES `news` (`newsAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attach
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `cateName` varchar(50) DEFAULT NULL,
  `cateContent` text,
  `bigpic` varchar(100) DEFAULT NULL,
  `parentID` int(11) DEFAULT NULL,
  `sortIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`categoryAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '化工原理', '这是简介', '/uploads/image/15112017191987.jpg', '0', '1');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `commentsAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `personAutoid` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`commentsAutoid`),
  KEY `fk_comments_person_id` (`personAutoid`) USING BTREE,
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`personAutoid`) REFERENCES `person` (`personAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('3', '阿斯蒂芬', 'v重新注册v撒旦', '2', '2016-05-03 09:31:31');
INSERT INTO `comments` VALUES ('4', '阿斯蒂芬', '阿斯蒂芬', '1', '2016-05-03 09:16:36');
INSERT INTO `comments` VALUES ('5', '阿安慰', 'dadsa', '1', '2016-05-27 11:24:57');
INSERT INTO `comments` VALUES ('6', '大大大', '多撒多撒', '1', '2016-04-27 00:00:00');
INSERT INTO `comments` VALUES ('7', 'dsadsa', 'dsadsa', '1', '2016-05-27 00:00:00');
INSERT INTO `comments` VALUES ('8', 'sdasa ', 'dsadsad', '1', '2016-08-25 14:18:19');
INSERT INTO `comments` VALUES ('9', 'dsadsadsa', 'dsadsa', '1', '2016-05-26 00:00:00');
INSERT INTO `comments` VALUES ('10', 'dsadsadsa', 'dsadsadsafff', '1', '2016-05-17 19:40:40');
INSERT INTO `comments` VALUES ('11', 'gg', 'gg', '1', '2016-05-30 12:59:12');

-- ----------------------------
-- Table structure for `flow`
-- ----------------------------
DROP TABLE IF EXISTS `flow`;
CREATE TABLE `flow` (
  `flowAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `fcAutoid` int(11) DEFAULT NULL,
  `flowName` varchar(50) DEFAULT NULL,
  `state` varchar(20) DEFAULT '已启用',
  `flowType` varchar(20) DEFAULT NULL,
  `itemID` varchar(20) DEFAULT NULL,
  `content` longtext,
  `imageUrl` varchar(100) DEFAULT NULL,
  `companyID` varchar(20) DEFAULT NULL,
  `docName` varchar(50) DEFAULT NULL,
  `docPath` varchar(50) DEFAULT NULL,
  `fileName` varchar(50) DEFAULT NULL,
  `filePath` varchar(50) DEFAULT NULL,
  `fileSize` int(11) DEFAULT NULL,
  `sortIndex` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `personAutoid` int(11) DEFAULT NULL,
  `del` varchar(10) DEFAULT 'false',
  PRIMARY KEY (`flowAutoid`),
  KEY `fk_flow_flowcls_id` (`fcAutoid`) USING BTREE,
  KEY `fk_flow_person_id` (`personAutoid`) USING BTREE,
  CONSTRAINT `flow_ibfk_1` FOREIGN KEY (`fcAutoid`) REFERENCES `flowcls` (`fcAutoid`),
  CONSTRAINT `flow_ibfk_2` FOREIGN KEY (`personAutoid`) REFERENCES `person` (`personAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow
-- ----------------------------
INSERT INTO `flow` VALUES ('1', null, '二氧化钛压缩机', '已启用', 'soft', null, null, '/images/co2.png', '欧倍尔', '阿斯顿', null, null, null, null, '1', '2015-11-21 10:09:05', '1', 'true');
INSERT INTO `flow` VALUES ('6', null, '紫外-可见吸收光谱仪', '已启用', 'soft', null, 'UV-vis', '/images/co2.png', 'NONE', 'java题2.doc', '/uploads/file/15112117473211.doc', '紫外-可见吸收光谱仪.exe', '/uploads/file/15112117471483.exe', '19114', '2', '2015-11-21 17:47:38', '1', 'true');
INSERT INTO `flow` VALUES ('7', null, '紫外定性分析', '已启用', 'flash', null, '<p>\r\n	<span style=\"font-size:14px;\">fsafdsd</span><span style=\"font-size:14px;\">asdf</span><span style=\"font-size:14px;\">asdf</span><span style=\"font-size:14px;\">asdf</span><span style=\"font-size:14px;\">2314</span><span style=\"font-size:14px;\">234</span>\r\n</p>', '/images/co2.png', null, null, null, '紫外定性分析.swf', '/uploads/file/16060713521716.swf', '48', '3', '2015-11-23 09:31:30', '1', 'true');
INSERT INTO `flow` VALUES ('8', null, '有机化学实验', '已启用', 'soft', null, '<h1>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\"><strong>一、实验目的</strong></span> \r\n</h1>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.学习直管摩擦阻力</span><span style=\"line-height:2;color:#333333;font-size:14px;\">,直管摩擦系数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">的测定方法。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.掌握直管摩擦系数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">与雷诺数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">和相对粗糙度之间的关系及其变化规律。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.掌握局部摩擦阻力</span><span style=\"line-height:2;color:#333333;font-size:14px;\">,局部阻力系数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">的测定方法。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.学习压强差的几种测量方法和提高其测量精确度的一些技巧。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.熟悉离心泵的操作方法。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 6.掌握离心泵特性曲线和管路特性曲线的测定方法、表示方法、加深对离心泵性能的了解。</span> \r\n</p>\r\n<h1>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\"><strong>二、实验内容</strong></span> \r\n</h1>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.测定实验管路内流体流动的阻力和直管摩擦系数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.测定实验管路内流体流动的直管摩擦系数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">与雷诺数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">和相对粗糙度之间的关系曲线。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.测定管路部件局部摩擦阻力</span><span style=\"line-height:2;color:#333333;font-size:14px;\">和局部阻力系数</span><span style=\"line-height:2;color:#333333;font-size:14px;\">。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.熟悉离心泵的结构与操作方法。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.测定某型号离心泵在一定转速下的特性曲线。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 6.测定流量调节阀某一开度下管路特性曲线。</span> \r\n</p>\r\n<p>\r\n	<span style=\"line-height:2;color:#333333;font-size:14px;\">&nbsp;</span> \r\n</p>', '/images/co2.png', 'NONE', '本甲酸的制备虚拟仿真软件操作手册.pdf', '/uploads/file/15120813200738.pdf', 'ChemLab.exe', '/uploads/file/15120813195484.exe', '12254', '4', '2015-12-08 13:20:23', '1', 'true');
INSERT INTO `flow` VALUES ('9', null, '连栋温控大棚', '已启用', 'video', null, '', '/images/co2.png', null, null, null, '气相色谱(7890A)视频.flv', '/uploads/file/16060714455862.flv', '23970', '5', '2016-05-17 09:35:50', '1', 'true');
INSERT INTO `flow` VALUES ('10', null, '脱硫塔', '已启用', 'unity3d', null, '', '/images/co2.png', null, null, null, 'TuoLiuTa.unity3d', '/uploads/file/16060714481366.unity3d', '46305', '6', '2016-06-07 14:48:24', '1', 'true');
INSERT INTO `flow` VALUES ('11', null, '氨-水吸收实验', '已启用', 'soft', null, '通过氨-水的吸收实验测定填料吸收塔的总体积传质系数和吸收效率', '/images/co2.png', 'lky', '氨-水吸收实验.pdf', '/uploads/file/16062715030717.pdf', '氨水吸收.exe', '/uploads/file/16062715025431.exe', '8967', '7', '2016-06-27 15:03:20', '1', 'true');
INSERT INTO `flow` VALUES ('12', null, '实验七干燥实验', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510324433.png', null, null, null, '7实验七干燥实验2015.swf', '/uploads/file/16090510321836.swf', '327', '8', '2016-09-05 10:32:48', '1', 'true');
INSERT INTO `flow` VALUES ('13', null, '实验六精馏实验', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510331741.png', null, null, null, '6实验六精馏实验2015.swf', '/uploads/file/16090510330016.swf', '523', '9', '2016-09-05 10:33:20', '1', 'true');
INSERT INTO `flow` VALUES ('14', null, '实验五吸收实验', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510345558.png', null, null, null, '5实验五吸收实验2015.swf', '/uploads/file/16090510343753.swf', '869', '10', '2016-09-05 10:34:57', '1', 'true');
INSERT INTO `flow` VALUES ('15', null, '实验四传热实验', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510354516.png', null, null, null, '4实验四传热实验2015.swf', '/uploads/file/16090510352984.swf', '442', '11', '2016-09-05 10:35:49', '1', 'true');
INSERT INTO `flow` VALUES ('16', null, '实验三过滤实验', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510361779.png', null, null, null, '3实验三过滤实验2015.swf', '/uploads/file/16090510360284.swf', '1143', '12', '2016-09-05 10:36:20', '1', 'true');
INSERT INTO `flow` VALUES ('17', null, '实验二离心泵实验', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510365066.png', null, null, null, '2实验二离心泵实验2015.swf', '/uploads/file/16090510363627.swf', '1189', '13', '2016-09-05 10:36:54', '1', 'true');
INSERT INTO `flow` VALUES ('18', null, '实验一阻力实验', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510372175.png', null, null, null, '1实验一阻力实验2015.swf', '/uploads/file/16090510370572.swf', '1487', '14', '2016-09-05 10:37:23', '1', 'true');
INSERT INTO `flow` VALUES ('19', null, '化工原理实验（理论部分）', '已启用', 'flash', null, '', '/uploads/attach/image/20160905/16090510375698.png', null, null, null, '化工原理实验（理论部分）2015.swf', '/uploads/file/16090510373648.swf', '2544', '15', '2016-09-05 10:38:00', '1', 'true');
INSERT INTO `flow` VALUES ('20', null, '煤制甲醇', '已启用', 'soft', null, '煤制甲醇单元', '/images/co2.png', '北京欧倍尔软件', '煤制甲醇单元仿真培训操作说明.pdf', '/uploads/file/16090616074622.pdf', 'V2-2-1402-9.exe', '/uploads/file/16090615373919.exe', '813087', '16', '2016-09-06 16:09:52', '1', 'true');

-- ----------------------------
-- Table structure for `flowcls`
-- ----------------------------
DROP TABLE IF EXISTS `flowcls`;
CREATE TABLE `flowcls` (
  `fcAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `fcName` varchar(50) DEFAULT NULL,
  `content` varchar(20) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `sortIndex` int(11) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fcAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flowcls
-- ----------------------------
INSERT INTO `flowcls` VALUES ('1', '化工原理', '对方8', '/uploads/attach/image/20160519/16051916040065.jpg', '1', '');
INSERT INTO `flowcls` VALUES ('2', '化工实训', '', '/images/co2.png', '2', '');

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `friendAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`friendAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('5', '清华大学', 'http://www.tsinghua.edu.cn/publish/newthu/index.html');
INSERT INTO `friend` VALUES ('6', '北京大学', 'http://www.pku.edu.cn/');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `flowAutoid` int(11) DEFAULT NULL,
  `itemName` varchar(50) DEFAULT NULL,
  `subID` int(11) DEFAULT NULL,
  `content` longtext,
  `keywords` varchar(1000) DEFAULT NULL,
  `imageUrl` varchar(50) DEFAULT NULL,
  `sortIndex` int(11) DEFAULT NULL,
  `del` varchar(10) DEFAULT '',
  PRIMARY KEY (`itemAutoid`),
  KEY `fk_item_flow_id` (`flowAutoid`) USING BTREE,
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`flowAutoid`) REFERENCES `flow` (`flowAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('7', '6', '苯酚的定性分析2', '0', null, null, null, '1', 'true');
INSERT INTO `item` VALUES ('8', '6', '苯酚含量的定量分析2', '1', null, null, null, '2', 'true');
INSERT INTO `item` VALUES ('9', '8', '苯甲酸的制备', '0', null, null, null, '3', 'true');
INSERT INTO `item` VALUES ('10', '8', '乙酸乙酯的制备', '1', null, null, null, '4', 'true');
INSERT INTO `item` VALUES ('11', '11', '填料塔流体力学实验（干塔）', '0', null, null, null, '5', 'true');
INSERT INTO `item` VALUES ('12', '11', '填料塔流体力学实验（湿塔）', '1', null, null, null, '6', 'true');
INSERT INTO `item` VALUES ('13', '11', '填料塔总体积传质系数测定实验', '2', null, null, null, '7', 'true');
INSERT INTO `item` VALUES ('14', '20', '正常开车', '0', null, null, null, '8', 'true');
INSERT INTO `item` VALUES ('15', '20', '正常停车', '1', null, null, null, '9', 'true');
INSERT INTO `item` VALUES ('16', '20', '透平坏', '2', null, null, null, '10', 'true');
INSERT INTO `item` VALUES ('17', '20', '压缩机坏', '3', null, null, null, '11', 'true');
INSERT INTO `item` VALUES ('18', '20', '分离罐液位高报警', '4', null, null, null, '12', 'true');
INSERT INTO `item` VALUES ('19', '20', '汽包液位低报警', '5', null, null, null, '13', 'true');
INSERT INTO `item` VALUES ('20', '20', '分离罐液位高或反应器温度高联锁', '6', null, null, null, '14', 'true');
INSERT INTO `item` VALUES ('21', '20', '汽包液位低联锁', '7', null, null, null, '15', 'true');
INSERT INTO `item` VALUES ('22', '20', '预塔回流泵故障', '8', null, null, null, '16', 'true');
INSERT INTO `item` VALUES ('23', '20', '出料自动阀泄露', '9', null, null, null, '17', 'true');
INSERT INTO `item` VALUES ('24', '20', '醇回收塔塔顶压力控制阀堵塞', '10', null, null, null, '18', 'true');
INSERT INTO `item` VALUES ('25', '20', '醇回收塔塔顶压力控制阀泄露', '11', null, null, null, '19', 'true');
INSERT INTO `item` VALUES ('26', '20', '粗醇中间罐液位控制阀泄露', '12', null, null, null, '20', 'true');
INSERT INTO `item` VALUES ('27', '20', '预精馏塔塔顶温度偏高', '13', null, null, null, '21', 'true');
INSERT INTO `item` VALUES ('28', '20', 'T103塔底部温度低', '14', null, null, null, '22', 'true');
INSERT INTO `item` VALUES ('29', '20', 'T103进料阀堵塞', '15', null, null, null, '23', 'true');
INSERT INTO `item` VALUES ('30', '20', '预精馏塔塔顶出换热器温度过高', '16', null, null, null, '24', 'true');
INSERT INTO `item` VALUES ('31', '20', '加压精馏塔塔顶回流泵出口阀泄漏', '17', null, null, null, '25', 'true');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `iconUrl` varchar(50) DEFAULT NULL,
  `navigateUrl` varchar(100) DEFAULT NULL,
  `webUrl` varchar(100) DEFAULT NULL,
  `isWeb` int(11) DEFAULT NULL,
  `parentID` int(11) DEFAULT NULL,
  `model` varchar(20) DEFAULT NULL,
  `sortIndex` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '菜单', null, 'admin/menu/menu.do?page=1', 'qq', null, '0', 'menumanage', '1');
INSERT INTO `menu` VALUES ('2', '用户管理', null, 'admin/person/person.do?page=1&personType=', '', null, '0', 'usermanage', '2');
INSERT INTO `menu` VALUES ('3', '中心概况', null, 'admin/news/index.do?page=1', '/school/center/info.do', '1', '0', 'center', '3');
INSERT INTO `menu` VALUES ('4', '师资队伍', null, 'admin/news/index.do?page=1', '/school/center/info.do', '1', '0', 'teacher', '4');
INSERT INTO `menu` VALUES ('5', '管理制度', null, 'admin/news/index.do?page=1', '/school/center/info.do', '1', '0', 'run', '5');
INSERT INTO `menu` VALUES ('6', '实验教学', null, 'admin/news/index.do?page=1', '/school/center/info.do', '1', '0', 'resource', '6');
INSERT INTO `menu` VALUES ('7', '下载专区', null, 'admin/news/index.do?page=1', '/school/center/info.do', '1', '0', 'down', '7');
INSERT INTO `menu` VALUES ('8', '教学成果', null, 'admin/news/index.do?page=1', '/school/center/info.do', '1', '0', 'share', '8');
INSERT INTO `menu` VALUES ('10', '实验室', null, 'admin/news/index.do?page=1', 'center/info.do', '1', '0', 'laboratory', '10');
INSERT INTO `menu` VALUES ('11', '虚拟仿真实验平台', null, 'admin/news/index.do?page=1', '/ncdxlearn', '1', '0', 'visplat', '11');
INSERT INTO `menu` VALUES ('12', '校园风光', null, 'admin/news/index.do?page=1', '', null, '0', 'school', '12');
INSERT INTO `menu` VALUES ('13', '新闻资讯', null, 'admin/news/index.do?page=1', '', null, '0', 'centernews', '13');
INSERT INTO `menu` VALUES ('14', '申报材料', null, 'admin/ware/index.do?page=1', '', null, '0', 'shenbao', '14');
INSERT INTO `menu` VALUES ('15', '中心简介', null, 'admin/news/index.do?page=1', '', null, '0', 'introde', '15');
INSERT INTO `menu` VALUES ('16', '虚拟仿真化工实验', null, 'admin/news/index.do?page=1', '', null, '0', 'experiment', '16');
INSERT INTO `menu` VALUES ('17', '仿真实验教学资源', null, 'admin/flow/index.do?page=1', '', null, '0', 'soft', '17');
INSERT INTO `menu` VALUES ('18', '通知公告', null, 'admin/news/index.do?page=1', '', null, '0', 'notice', '18');
INSERT INTO `menu` VALUES ('19', '成果展示', null, 'admin/news/index.do?page=1', '', null, '0', 'results', '19');
INSERT INTO `menu` VALUES ('20', '相关链接', null, 'admin/friend/friend.do?page=1', '', null, '0', 'links', '20');
INSERT INTO `menu` VALUES ('21', '底部信息', null, 'admin/news/index.do?page=1', '', null, '0', 'bottom', '21');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `newsClsAutoid` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` longtext,
  `image` varchar(100) DEFAULT NULL,
  `sortIndex` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `personAutoid` int(11) DEFAULT NULL,
  `showIndex` int(11) DEFAULT NULL,
  `imageurl` varchar(200) DEFAULT NULL COMMENT '图片链接',
  `videourl` varchar(200) DEFAULT NULL COMMENT '视频连接',
  PRIMARY KEY (`newsAutoid`),
  KEY `fk_newscls_id` (`newsClsAutoid`) USING BTREE,
  KEY `fk_person_id` (`personAutoid`) USING BTREE,
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`newsClsAutoid`) REFERENCES `newscls` (`newsClsAutoid`),
  CONSTRAINT `news_ibfk_2` FOREIGN KEY (`personAutoid`) REFERENCES `person` (`personAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('9', '2', '中心介绍', '<p align=\"center\">\r\n	中心介绍111\r\n</p>', '', '9', '2015-11-26 00:00:00', '1', '1', '', '');
INSERT INTO `news` VALUES ('12', '7', '会议', '<p>\r\n	最后一会\r\n</p>', '/uploads/attach/image/20160905/16090516354554.png', '1', '2015-11-19 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('13', '7', '运动会', '<p>\r\n	还有会\r\n</p>', '/uploads/attach/image/20160905/16090516324659.png', '2', '2016-09-05 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('15', '9', '中心简介', '<p>\r\n	玉林师范学院（Yulin Normal University）位于广西壮族自治区玉林市，是桂东南地区唯一一所广西自治区直属本科院校，是广西4所高等教育综合改革试点高校之一。2016年，入选教育部数据中国“百校工程”合作院校。\r\n</p>', '', '1', '2015-11-19 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('16', '10', '虚拟仿真化工实验', '<p class=\"MsoNormal\">\r\n	&nbsp;<span style=\"color:#000000;line-height:2;font-size:14px;\">虚拟仿真实验教学平台是结合实验教学管理与资源管理与一体的综合平台。教学管理包括实验课程设置、实验预习、实验预约，及在线实验、监控、实验成绩报告上传、统计。资源管理包括实验课程资源的上传、下载、资源使用情况的统计等。</span>\r\n</p>', '', '1', '2015-11-19 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('19', '15', '底部信息', '<p align=\"center\">\r\n	Copyright  &copy; 2015 玉林师范学院 版权所有&nbsp;&nbsp;&nbsp;桂ICP备05001211-4号 All Rights Reserved.\r\n</p>\r\n<p align=\"center\">\r\n	地址：广西壮族自治区玉林市玉州区教育中路299号\r\n</p>\r\n<p align=\"center\">\r\n	&nbsp;\r\n</p>', '', '1', '2015-11-20 00:00:00', '1', '1', null, null);
INSERT INTO `news` VALUES ('22', '7', '大会隆重召开', '<p>\r\n	继续开会\r\n</p>', '/uploads/attach/image/20160905/16090516271216.png', '3', '2016-09-05 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('23', '12', '荣获创新创业大赛奖', '<p align=\"center\" style=\"text-align:left;text-indent:2em;\">\r\n	荣获创新创业大赛奖\r\n</p>', '/uploads/attach/image/20160905/16090517054820.png', '2', '2015-12-08 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('24', '12', '深入企业调研', '<p>\r\n	企业实习3\r\n</p>', '/uploads/attach/image/20160905/16090517003534.png', '3', '2015-12-08 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('25', '12', '【暑期社会实践】', '<p>\r\n	实习获奖2\r\n</p>', '/uploads/attach/image/20160905/16090516585943.png', '4', '2015-12-08 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('26', '12', '实习获奖1', '<p align=\"center\">\r\n	实习获奖1\r\n</p>', '/uploads/attach/image/20160905/16090516551818.png', '5', '2015-12-08 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('27', '14', '华能集团', '', '/uploads/image/15120809580610.png', '1', '2015-12-08 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('28', '14', '北京欧倍尔', '', '/uploads/attach/image/20160519/20160519153247_468.jpg', '2', '2015-12-08 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('29', null, 'ff', 'fd', '', '1', '2016-02-18 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('30', null, 'dfs', 'sdfsdf', '', '1', '2016-02-18 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('31', '7', '开会', '<p>\r\n	&nbsp;\r\n</p>', '/uploads/attach/image/20160905/16090516225019.png', '4', '2016-04-22 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('39', '31', '化工原理实验课件', '<p>\r\n	&nbsp;\r\n</p>', '', '1', '2016-09-05 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('57', '5', '师资结构', '', '', '1', '2016-09-05 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('58', '6', '实验指导教师', '<p>\r\n	<span style=\"color:#000000;line-height:2;font-size:14px;\">实验指导教师</span>&nbsp;\r\n</p>', '', '11', '2016-09-05 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('59', '23', '教学概况', '<p class=\"MsoNormal\">\r\n	<span style=\"color:#000000;line-height:2;font-family:仿宋_GB2312;font-size:14px;\">&nbsp;</span>\r\n</p>', '', '1', '2016-09-05 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('68', '19', '精品课程', '<p class=\"MsoNormal\">\r\n	<span style=\"color:#000000;line-height:2;font-family:仿宋_GB2312;font-size:14px;\">省级精品课程</span>\r\n</p>', '/uploads/attach/image/20170412/17041213213153.png', '1', '2016-09-05 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('75', '30', '立项与获奖', '<p>\r\n	&nbsp;\r\n</p>', '', '1', '2016-09-06 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('81', '3', '中心主任', '', '', '1', '2016-09-09 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('82', '21', '中心成员信息表', '', '', '1', '2016-09-09 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('101', '35', 'adfas', 'hello', '', '1', '2017-04-11 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('103', '11', 'fffff', '', '', '7', '2017-04-12 00:00:00', '1', null, '', '');
INSERT INTO `news` VALUES ('108', '39', '精馏实验3', '', '/uploads/attach/image/20170412/17041214030543.png', '3', '2017-04-12 00:00:00', '1', null, '', null);
INSERT INTO `news` VALUES ('109', '39', '精馏实验4', '', '/uploads/attach/image/20170412/17041214032740.png', '4', '2017-04-12 00:00:00', '1', null, '', null);
INSERT INTO `news` VALUES ('110', '40', '大豆的起源', '', '/uploads/attach/image/20170412/17041219423244.jpg', '1', '2017-04-12 00:00:00', '1', null, '', '/uploads/attach/image/20170413/17041311042682.webm');
INSERT INTO `news` VALUES ('111', '40', '绿豆的起源', '', '/uploads/attach/image/20170412/17041215034242.png', '2', '2017-04-12 00:00:00', '1', null, '', '/uploads/attach/image/20170413/17041311044710.webm');
INSERT INTO `news` VALUES ('112', '40', '蚕豆的起源', '', '/uploads/attach/image/20170412/17041215042059.png', '3', '2017-04-12 00:00:00', '1', null, '', '/uploads/attach/image/20170413/17041311050456.webm');
INSERT INTO `news` VALUES ('113', '41', '实验展示1', '', '/uploads/attach/image/20170412/17041215111764.png', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('114', '41', '实验展示2', '', '/uploads/attach/image/20170412/17041215115634.png', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('115', '41', '实验展示3', '', '/uploads/attach/image/20170412/17041215123056.png', '3', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('116', '41', '实验展示4', '', '/uploads/attach/image/20170412/17041215125346.png', '4', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('117', '41', '实验展示5', '', '/uploads/attach/image/20170412/17041215131337.png', '5', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('118', '42', '精品课程1', '', '/uploads/attach/image/20170412/17041215181030.png', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('119', '42', '精品课程2', '', '/uploads/attach/image/20170412/17041215184066.png', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('120', '42', '精品课程3', '', '/uploads/attach/image/20170412/17041215245680.png', '3', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('121', '43', '二级菜单', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('122', '44', '二级菜单1', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('123', '44', '二级菜单2', '', '', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('124', '45', '二级菜单1', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('125', '45', '二级菜单2', '', '', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('126', '45', '二级菜单3', '', '', '3', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('127', '46', '二级菜单', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('128', '47', '二级菜单1', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('129', '47', '二级菜单2', '', '', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('130', '48', '二级菜单1', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('131', '48', '二级菜单2', '', '', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('132', '48', '二级菜单3', '', '', '3', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('133', '49', '二级菜单', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('134', '50', '二级菜单1', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('135', '50', '二级菜单2', '', '', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('136', '51', '二级菜单1', '', '', '1', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('137', '51', '二级菜单2', '', '', '2', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('138', '51', '二级菜单3', '', '', '3', '2017-04-12 00:00:00', '1', null, 'http://www.baidu.com', null);
INSERT INTO `news` VALUES ('140', '53', '常规冷凝', '', '/uploads/attach/image/20170412/17041218204327.png', '1', '2017-04-12 00:00:00', '1', null, '', '');
INSERT INTO `news` VALUES ('141', '53', '快速冷凝', '', '/uploads/attach/image/20170412/17041219005280.png', '2', '2017-04-12 00:00:00', '1', null, '', '');
INSERT INTO `news` VALUES ('145', '40', '红豆的起源', '', '/uploads/attach/image/20170412/17041218204327.png', '4', '2017-04-13 00:00:00', '1', null, '', '/uploads/attach/image/20170413/17041311051930.webm');
INSERT INTO `news` VALUES ('149', '32', '测试数据', '<p>\r\n	&nbsp;\r\n</p>', '/uploads/attach/image/20170414/17041413525859.jpg', '1', '2017-04-14 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('150', '8', '测试111', '我是测试1', '', '1', '2017-06-02 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('151', '8', '测试222', '<p align=\"center\">\r\n	我是测试2\r\n</p>', '', '2', '2017-06-02 00:00:00', '1', null, null, null);
INSERT INTO `news` VALUES ('152', '11', 'eee', '<p align=\"center\">\r\n	hello world\r\n</p>', '', '8', '2017-06-02 00:00:00', '1', null, null, null);

-- ----------------------------
-- Table structure for `newscls`
-- ----------------------------
DROP TABLE IF EXISTS `newscls`;
CREATE TABLE `newscls` (
  `newsClsAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `clsName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`newsClsAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newscls
-- ----------------------------
INSERT INTO `newscls` VALUES ('2', '中心介绍', 'center');
INSERT INTO `newscls` VALUES ('3', '中心领导', 'center');
INSERT INTO `newscls` VALUES ('5', '师资结构', 'teacher');
INSERT INTO `newscls` VALUES ('6', '实验指导教师', 'teacher');
INSERT INTO `newscls` VALUES ('7', '校园风光', 'school');
INSERT INTO `newscls` VALUES ('8', '新闻资讯', 'centernews');
INSERT INTO `newscls` VALUES ('9', '中心简介', 'introde');
INSERT INTO `newscls` VALUES ('10', '虚拟仿真化工实验', 'experiment');
INSERT INTO `newscls` VALUES ('11', '通知公告', 'notice');
INSERT INTO `newscls` VALUES ('12', '成果展示', 'results');
INSERT INTO `newscls` VALUES ('13', '学校制度', 'run');
INSERT INTO `newscls` VALUES ('14', '合作企业', 'company');
INSERT INTO `newscls` VALUES ('15', '底部信息', 'bottom');
INSERT INTO `newscls` VALUES ('16', '平台介绍', 'visplat');
INSERT INTO `newscls` VALUES ('19', '精品课程', 'share');
INSERT INTO `newscls` VALUES ('20', '教材出版', 'share');
INSERT INTO `newscls` VALUES ('21', '中心成员', 'center');
INSERT INTO `newscls` VALUES ('22', '学院制度', 'run');
INSERT INTO `newscls` VALUES ('23', '教学概况', 'resource');
INSERT INTO `newscls` VALUES ('24', '实验课程', 'resource');
INSERT INTO `newscls` VALUES ('25', '实验大纲', 'resource');
INSERT INTO `newscls` VALUES ('26', '实验安排', 'resource');
INSERT INTO `newscls` VALUES ('27', '实验环境', 'laboratory');
INSERT INTO `newscls` VALUES ('28', '实验设备', 'laboratory');
INSERT INTO `newscls` VALUES ('30', '立项与获奖', 'share');
INSERT INTO `newscls` VALUES ('31', '课件下载', 'down');
INSERT INTO `newscls` VALUES ('32', '文件下载', 'down');
INSERT INTO `newscls` VALUES ('34', '制药实验室', 'laboratory');
INSERT INTO `newscls` VALUES ('35', 'nihao ', 'center');
INSERT INTO `newscls` VALUES ('39', '精馏实验', 'simulatlab');
INSERT INTO `newscls` VALUES ('40', '视频公开课', 'publiclass');
INSERT INTO `newscls` VALUES ('41', '实验展示', 'testshow');
INSERT INTO `newscls` VALUES ('42', '精品课程', 'qualityclass');
INSERT INTO `newscls` VALUES ('43', '中心简介', 'homemenu');
INSERT INTO `newscls` VALUES ('44', '教学与管理队伍', 'homemenu');
INSERT INTO `newscls` VALUES ('45', '教学资源', 'homemenu');
INSERT INTO `newscls` VALUES ('46', '虚拟仿真实验教学平台', 'homemenu');
INSERT INTO `newscls` VALUES ('47', '中心管理体系', 'homemenu');
INSERT INTO `newscls` VALUES ('48', '校企合作概况', 'homemenu');
INSERT INTO `newscls` VALUES ('49', '资源共享', 'homemenu');
INSERT INTO `newscls` VALUES ('50', '平台帮助', 'homemenu');
INSERT INTO `newscls` VALUES ('51', '交流答疑', 'homemenu');
INSERT INTO `newscls` VALUES ('52', '食品实验教学中心', 'homemenu');
INSERT INTO `newscls` VALUES ('53', '冷凝实验', 'simulatlab');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `personAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `personType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`personAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '张三', 'admin', '00D0B6CE0ADA00D70908CC55C343481F', '123', 'admin');
INSERT INTO `person` VALUES ('2', '曹', 'guest', 'E10ADC3949BA59ABBE56E057F20F883E', '123', 'student');
INSERT INTO `person` VALUES ('3', '张三', '1110107024', 'AD8BC830AC0C5A64ACA17201B7DC6D2B', '13718141391', 'student');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `replyAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `commentsAutoid` int(11) DEFAULT NULL,
  `content` text,
  `personAutoid` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`replyAutoid`),
  KEY `fk_comments_id` (`commentsAutoid`) USING BTREE,
  KEY `fk_perosn` (`personAutoid`) USING BTREE,
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`commentsAutoid`) REFERENCES `comments` (`commentsAutoid`),
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`personAutoid`) REFERENCES `person` (`personAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('4', '3', '撒地方', '1', '2016-05-03 09:19:39');
INSERT INTO `reply` VALUES ('5', '5', '阿斯蒂芬', '1', '2016-05-04 09:30:41');
INSERT INTO `reply` VALUES ('6', '10', 'dsadsadsa', '1', '2016-05-18 19:40:40');
INSERT INTO `reply` VALUES ('7', '10', 'dgg', '1', '2016-05-26 14:36:56');
INSERT INTO `reply` VALUES ('8', '11', 'dd', '1', null);
INSERT INTO `reply` VALUES ('9', '11', 'uu', '1', '2016-05-30 13:01:03');

-- ----------------------------
-- Table structure for `soft`
-- ----------------------------
DROP TABLE IF EXISTS `soft`;
CREATE TABLE `soft` (
  `softAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `clsID` int(11) DEFAULT NULL,
  `content` text,
  `softName` varchar(100) DEFAULT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `filePath` varchar(100) DEFAULT NULL,
  `fileSize` int(11) DEFAULT NULL,
  PRIMARY KEY (`softAutoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of soft
-- ----------------------------

-- ----------------------------
-- Table structure for `ware`
-- ----------------------------
DROP TABLE IF EXISTS `ware`;
CREATE TABLE `ware` (
  `wareAutoid` int(11) NOT NULL AUTO_INCREMENT,
  `wareName` varchar(50) DEFAULT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `filePath` varchar(100) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`wareAutoid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ware
-- ----------------------------
INSERT INTO `ware` VALUES ('1', '申报书1', 'Microsoft Word - 2016年湖南省省级虚拟真验教学中心建设（初稿）.swf', '/uploads/ware/16042517475975.swf', 'book');
INSERT INTO `ware` VALUES ('2', '支撑材料', null, null, 'material');
INSERT INTO `ware` VALUES ('3', '视频介绍', '格式工厂16061413325652.mp4', '/uploads/ware/16061509222813.mp4', 'video');
