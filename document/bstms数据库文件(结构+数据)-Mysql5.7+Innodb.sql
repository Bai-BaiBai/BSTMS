/*
 Navicat MySQL Data Transfer

 Source Server         : MYSQL57_3307
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3307
 Source Schema         : bstms

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 01/07/2019 16:30:09
 
 从Navicat For Mysql软件导出
 数据库版本Mysqk5.7
 引擎全部为Innodb
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill_info
-- ----------------------------
DROP TABLE IF EXISTS `bill_info`;
CREATE TABLE `bill_info`  (
  `bill_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '账单id',
  `card_id_from` bigint(18) NULL DEFAULT NULL COMMENT '交易发起方',
  `card_id_to` bigint(18) NULL DEFAULT NULL COMMENT '交易接受方',
  `affair_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易类型',
  `trade_time` datetime(0) NOT NULL COMMENT '交易时间',
  `trade_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易地点',
  `trade_balance` double(10, 2) NOT NULL COMMENT '交易金额',
  PRIMARY KEY (`bill_id`) USING BTREE,
  INDEX `card_id_from`(`card_id_from`) USING BTREE,
  INDEX `card_id_to`(`card_id_to`) USING BTREE,
  CONSTRAINT `bill_info_ibfk_1` FOREIGN KEY (`card_id_from`) REFERENCES `card_info` (`card_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bill_info_ibfk_2` FOREIGN KEY (`card_id_to`) REFERENCES `card_info` (`card_id`) ON DELETE CASCADE ON UPDATE CASCADE
) 
ENGINE = InnoDB 
AUTO_INCREMENT = 123456817 
CHARACTER SET = utf8 
COLLATE = utf8_general_ci 
ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill_info
-- ----------------------------
INSERT INTO `bill_info` VALUES (123456789, NULL, 123456789012345678, '存款', '2019-06-25 15:45:56', '手机客户端', 100.00);
INSERT INTO `bill_info` VALUES (123456791, 123456789012345678, 223456789012345678, '转账', '2019-06-26 06:36:34', '手机客户端', 400.00);
INSERT INTO `bill_info` VALUES (123456792, 123456789012345678, 223456789012345678, '转账', '2019-06-26 14:48:27', '营业厅', 400.00);
INSERT INTO `bill_info` VALUES (123456793, 123456789012345678, NULL, '存款', '2019-06-26 15:43:54', '营业厅', 1000.00);
INSERT INTO `bill_info` VALUES (123456794, 123456789012345678, NULL, '取款', '2019-06-26 15:44:15', '营业厅', 600.00);
INSERT INTO `bill_info` VALUES (123456795, 223456789012345678, 123456789012345678, '转账', '2019-06-26 15:45:23', '营业厅', 1000.00);
INSERT INTO `bill_info` VALUES (123456796, 123456789012345678, NULL, '存款', '2019-06-26 19:42:43', '营业厅', 600.00);
INSERT INTO `bill_info` VALUES (123456797, 123456789012345678, NULL, '取款', '2019-06-26 19:43:08', '营业厅', 1600.00);
INSERT INTO `bill_info` VALUES (123456798, 123456789012345678, 223456789012345678, '转账', '2019-06-26 19:44:11', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456799, 223456789012345679, NULL, '存款', '2019-06-26 20:11:27', '手机客户端', 1000.00);
INSERT INTO `bill_info` VALUES (123456800, 123456789012345678, NULL, '存款', '2019-06-27 07:49:28', '手机客户端', 1000.00);
INSERT INTO `bill_info` VALUES (123456801, 123456789012345678, NULL, '取款', '2019-06-27 07:50:39', '营业厅', 688.14);
INSERT INTO `bill_info` VALUES (123456802, 123456789012345678, NULL, '存款', '2019-06-29 09:01:01', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456803, 123456789012345678, NULL, '存款', '2019-06-29 09:24:33', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456804, 123456789012345678, NULL, '存款', '2019-06-29 09:28:02', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456805, 123456789012345678, NULL, '取款', '2019-06-29 10:08:32', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456806, 123456789012345678, NULL, '取款', '2019-06-29 10:12:17', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456807, 123456789012345678, 223456789012345678, '转账', '2019-06-29 11:39:36', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456808, 123456789012345678, NULL, '存款', '2019-06-29 14:20:00', '营业厅', 1000.00);
INSERT INTO `bill_info` VALUES (123456809, 123456789012345678, NULL, '取款', '2019-06-29 14:20:13', '营业厅', 100.00);
INSERT INTO `bill_info` VALUES (123456810, 123456789012345678, NULL, '取款', '2019-06-29 14:20:55', '营业厅', 638.00);
INSERT INTO `bill_info` VALUES (123456811, 123456789012345678, NULL, '取款', '2019-07-01 15:25:41', '营业厅', 50.00);
INSERT INTO `bill_info` VALUES (123456812, 123456789012345678, 223456789012345678, '转账', '2019-07-01 15:43:07', '营业厅', 20.00);
INSERT INTO `bill_info` VALUES (123456813, 123456789012345678, NULL, '存款', '2019-07-01 15:46:55', '营业厅', 1000.00);
INSERT INTO `bill_info` VALUES (123456814, 123456789012345678, NULL, '取款', '2019-07-01 15:49:50', '营业厅', 688.14);
INSERT INTO `bill_info` VALUES (123456815, 123456789012345678, NULL, '存款', '2019-07-01 15:50:32', '营业厅', 1000.00);
INSERT INTO `bill_info` VALUES (123456816, 123456789012345678, NULL, '取款', '2019-07-01 15:50:54', '营业厅', 688.14);

-- ----------------------------
-- Table structure for business_info
-- ----------------------------
DROP TABLE IF EXISTS `business_info`;
CREATE TABLE `business_info`  (
  `business_id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `business_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务类型',
  `business_date` datetime(0) NOT NULL COMMENT '业务有效日期',
  `business_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务描述',
  PRIMARY KEY (`business_id`) USING BTREE
) 
ENGINE = InnoDB 
AUTO_INCREMENT = 1005 
CHARACTER SET = utf8 
COLLATE = utf8_general_ci 
ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business_info
-- ----------------------------
INSERT INTO `business_info` VALUES (1001, '金融理财产品1号', '2019-06-26 00:00:00', '这是金融理财产品1号');
INSERT INTO `business_info` VALUES (1002, '金融理财产品2号', '2019-06-26 20:29:56', '这是金融理财产品2号');
INSERT INTO `business_info` VALUES (1003, '金融理财产品3号', '2019-06-26 20:30:11', '这是金融理财产品3号');
INSERT INTO `business_info` VALUES (1004, '金融理财产品4号', '2019-06-26 20:30:32', '这是金融理财产品4号');

-- ----------------------------
-- Table structure for card_info
-- ----------------------------
DROP TABLE IF EXISTS `card_info`;
CREATE TABLE `card_info`  (
  `card_id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '银行18位卡号',
  `id_numbers` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的身份证号',
  `password` int(6) NOT NULL COMMENT '6位密码',
  `card_type` int(2) NOT NULL COMMENT '1借记卡或2信用卡',
  `account_balance` double(20, 2) NULL DEFAULT 0.00 COMMENT '账户余额',
  `overdraft_balance` double(20, 2) NULL DEFAULT 0.00 COMMENT '信用卡的透支额度',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '有效期',
  `exchange_rate_id` int(8) NOT NULL DEFAULT 1001 COMMENT '引自汇率表，标识货币类型',
  PRIMARY KEY (`card_id`) USING BTREE,
  INDEX `id_numbers`(`id_numbers`) USING BTREE,
  INDEX `exchange_rate_id`(`exchange_rate_id`) USING BTREE,
  CONSTRAINT `card_info_ibfk_1` FOREIGN KEY (`id_numbers`) REFERENCES `user_info` (`id_numbers`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `card_info_ibfk_2` FOREIGN KEY (`exchange_rate_id`) REFERENCES `exchange_rate_info` (`exchange_rate_id`) ON DELETE CASCADE ON UPDATE CASCADE
) 
ENGINE = InnoDB 
AUTO_INCREMENT = 223456789012345699 
CHARACTER SET = utf8 
COLLATE = utf8_general_ci 
ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of card_info
-- ----------------------------
INSERT INTO `card_info` VALUES (123456789012345678, '123456789012345678', 123456, 1, 1627.58, 0.00, '2099-06-25 14:09:50', 1001);
INSERT INTO `card_info` VALUES (223456789012345678, '223456789012345678', 123456, 2, 520.00, 1000.00, '2019-06-25 14:16:22', 1001);
INSERT INTO `card_info` VALUES (223456789012345679, '123456789012345678', 123456, 1, 1000.00, 0.00, '2019-06-26 20:09:15', 1001);
INSERT INTO `card_info` VALUES (223456789012345698, '123456789012345678', 111111, 1, 0.00, 0.00, '2019-07-01 16:01:24', 1001);

-- ----------------------------
-- Table structure for exchange_rate_info
-- ----------------------------
DROP TABLE IF EXISTS `exchange_rate_info`;
CREATE TABLE `exchange_rate_info`  (
  `exchange_rate_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '汇率id',
  `currency_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货币类型',
  `exchange_rate` double(8, 4) NULL DEFAULT NULL COMMENT '汇率值：值=货币/人民币',
  PRIMARY KEY (`exchange_rate_id`) USING BTREE
) 
ENGINE = InnoDB 
AUTO_INCREMENT = 1007 
CHARACTER SET = utf8 
COLLATE = utf8_general_ci 
ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exchange_rate_info
-- ----------------------------
INSERT INTO `exchange_rate_info` VALUES (1001, '人民币', 1.0000);
INSERT INTO `exchange_rate_info` VALUES (1002, '美元', 6.8814);
INSERT INTO `exchange_rate_info` VALUES (1003, '英镑', 8.7126);
INSERT INTO `exchange_rate_info` VALUES (1004, '欧元', 7.8126);
INSERT INTO `exchange_rate_info` VALUES (1005, '日元', 0.0638);
INSERT INTO `exchange_rate_info` VALUES (1006, '法郎', 7.0328);

-- ----------------------------
-- Table structure for interest_rate_info
-- ----------------------------
DROP TABLE IF EXISTS `interest_rate_info`;
CREATE TABLE `interest_rate_info`  (
  `interest_rate_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '利率id',
  `interest_rate_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '利率类型',
  `interest_rate` double(8, 4) NOT NULL,
  PRIMARY KEY (`interest_rate_id`) USING BTREE
) 
ENGINE = InnoDB 
AUTO_INCREMENT = 1004 
CHARACTER SET = utf8 
COLLATE = utf8_general_ci 
ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interest_rate_info
-- ----------------------------
INSERT INTO `interest_rate_info` VALUES (1001, '一年', 3.0000);
INSERT INTO `interest_rate_info` VALUES (1002, '二年', 3.5000);
INSERT INTO `interest_rate_info` VALUES (1003, '三年', 4.0000);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id_numbers` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_numbers`) USING BTREE
) 
ENGINE = InnoDB 
CHARACTER SET = utf8
COLLATE = utf8_general_ci 
ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('123456789012345678', '张三', '10086', '1号');
INSERT INTO `user_info` VALUES ('223456789012345678', '李四', '10087', '2号');

SET FOREIGN_KEY_CHECKS = 1;
