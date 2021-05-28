/*
 Navicat Premium Data Transfer

 Source Server         : mysql_localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : system_center

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 27/05/2021 17:15:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_data_source
-- ----------------------------
DROP TABLE IF EXISTS `system_data_source`;
CREATE TABLE `system_data_source`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `source_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '数据源名称',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库登入名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库登入凭证',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库连接地址',
  `driver` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库连接驱动',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_data_source
-- ----------------------------
INSERT INTO `system_data_source` VALUES (1, 'mysql', 'root', 'root', 'jdbc:mysql://localhost:3306/kuroneko?serverTimezone=UTC', 'com.mysql.cj.jdbc.Driver', NULL, NULL);
INSERT INTO `system_data_source` VALUES (2, 'sqlserver', 'sa', 'Dzh970102', 'jdbc:sqlserver://localhost:1433;DatabaseName=YinLuDWQAS', 'com.microsoft.sqlserver.jdbc.SQLServerDriver', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
