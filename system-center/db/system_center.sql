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

 Date: 24/06/2021 16:38:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `sort` decimal(10, 0) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '#14889A', 'theme', 'color', '主题色', 0, 'admin', '2018-09-23 19:52:54', NULL, NULL, '主题色', 0);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `order_num` int NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '轻尘集团', NULL, 0, 'admin', '2018-09-23 19:35:22', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (2, '牧尘集团', NULL, 1, 'admin', '2018-09-23 19:35:55', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (3, '三国集团', NULL, 2, 'admin', '2018-09-23 19:36:24', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (4, '上海分公司', 2, 0, 'admin', '2018-09-23 19:37:03', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (5, '北京分公司', 1, 1, 'admin', '2018-09-23 19:37:17', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (6, '北京分公司', 2, 1, 'admin', '2018-09-23 19:37:28', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (7, '技术部', 5, 0, 'admin', '2018-09-23 19:38:00', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (8, '技术部', 4, 0, 'admin', '2018-09-23 19:38:10', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (9, '技术部', 6, 0, 'admin', '2018-09-23 19:38:17', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (10, '市场部', 5, 0, 'admin', '2018-09-23 19:38:45', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (11, '市场部', 6, 0, 'admin', '2018-09-23 19:39:01', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (12, '魏国', 3, 0, 'admin', '2018-09-23 19:40:42', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (13, '蜀国', 3, 1, 'admin', '2018-09-23 19:40:54', NULL, NULL, 0);
INSERT INTO `sys_dept` VALUES (14, '吴国', 3, 2, 'admin', '2018-09-23 19:41:04', NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `sort` decimal(10, 0) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, 'male', '男', 'sex', '性别', 0, 'admin', '2018-09-23 19:52:54', NULL, NULL, '性别', 0);
INSERT INTO `sys_dict` VALUES (2, 'female', '女', 'sex', '性别', 1, 'admin', '2018-09-23 19:53:17', NULL, NULL, '性别', 0);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2897 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 4, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:16', NULL, NULL);
INSERT INTO `sys_log` VALUES (2, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 4, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:17', NULL, NULL);
INSERT INTO `sys_log` VALUES (3, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 36, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:18', NULL, NULL);
INSERT INTO `sys_log` VALUES (4, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 4, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', NULL, NULL);
INSERT INTO `sys_log` VALUES (5, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 4, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', NULL, NULL);
INSERT INTO `sys_log` VALUES (6, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 27, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:21', NULL, NULL);
INSERT INTO `sys_log` VALUES (7, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 4, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:22', NULL, NULL);
INSERT INTO `sys_log` VALUES (8, 'admin', NULL, 'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', 4, '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:23', NULL, NULL);
INSERT INTO `sys_log` VALUES (2798, NULL, NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', 361, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2799, NULL, NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', 4, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2800, NULL, NULL, 'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findByUser()', '\"admin\"', 43, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2801, NULL, NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPermissions()', '\"admin\"', 49, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2802, NULL, NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', 221, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2803, NULL, NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()', '\"admin\"', 3, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2804, NULL, NULL, 'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findByUser()', '\"admin\"', 37, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2805, NULL, NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPermissions()', '\"admin\"', 43, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (2806, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysLoginLogServiceImpl.writeLoginLog()', '\"admin\"', 138, '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:43', NULL, NULL);
INSERT INTO `sys_log` VALUES (2807, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findTree()', '\"admin\"', 15, '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:44', NULL, NULL);
INSERT INTO `sys_log` VALUES (2808, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findByUser()', '\"admin\"', 16, '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:44', NULL, NULL);
INSERT INTO `sys_log` VALUES (2809, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPermissions()', '\"admin\"', 22, '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:44', NULL, NULL);
INSERT INTO `sys_log` VALUES (2876, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysLoginLogServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"userName\",\"value\":\"\"}]}', 13, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:10', NULL, NULL);
INSERT INTO `sys_log` VALUES (2877, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', 15, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:13', NULL, NULL);
INSERT INTO `sys_log` VALUES (2878, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findTree()', 'null', 10, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:13', NULL, NULL);
INSERT INTO `sys_log` VALUES (2879, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()', NULL, 3, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', NULL, NULL);
INSERT INTO `sys_log` VALUES (2880, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()', NULL, 2, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', NULL, NULL);
INSERT INTO `sys_log` VALUES (2881, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', 49, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', NULL, NULL);
INSERT INTO `sys_log` VALUES (2882, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()', NULL, 1, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:14', NULL, NULL);
INSERT INTO `sys_log` VALUES (2883, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findTree()', 'null', 3, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:15', NULL, NULL);
INSERT INTO `sys_log` VALUES (2884, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysConfigServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"label\",\"value\":\"\"}]}', 8, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:15', NULL, NULL);
INSERT INTO `sys_log` VALUES (2885, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysLoginLogServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"userName\",\"value\":\"\"}]}', 7, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:16', NULL, NULL);
INSERT INTO `sys_log` VALUES (2886, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()', NULL, 2, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:22', NULL, NULL);
INSERT INTO `sys_log` VALUES (2887, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', 61, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:22', NULL, NULL);
INSERT INTO `sys_log` VALUES (2888, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()', NULL, 1, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:22', NULL, NULL);
INSERT INTO `sys_log` VALUES (2889, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":2,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', 18, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:25', NULL, NULL);
INSERT INTO `sys_log` VALUES (2890, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()', NULL, 2, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:25', NULL, NULL);
INSERT INTO `sys_log` VALUES (2891, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', 43, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:27', NULL, NULL);
INSERT INTO `sys_log` VALUES (2892, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()', NULL, 1, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:27', NULL, NULL);
INSERT INTO `sys_log` VALUES (2893, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.createUserExcelFile()', '{\"pageNum\":1,\"pageSize\":100000,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', 1577, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:48:38', NULL, NULL);
INSERT INTO `sys_log` VALUES (2894, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()', NULL, 1, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:49:24', NULL, NULL);
INSERT INTO `sys_log` VALUES (2895, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()', '{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}', 75, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:49:24', NULL, NULL);
INSERT INTO `sys_log` VALUES (2896, 'admin', NULL, 'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()', NULL, 2, '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:49:24', NULL, NULL);

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2804 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------
INSERT INTO `sys_login_log` VALUES (1, 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:16', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (2, 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:17', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (3, 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:18', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (4, 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (5, 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:20', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (6, 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:21', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (7, 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:22', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (8, 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2018-09-23 19:54:23', 'admin', '2019-01-21 10:15:43');
INSERT INTO `sys_login_log` VALUES (2798, 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:43', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (2799, 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:15:43', 'admin', '2019-01-21 10:16:54');
INSERT INTO `sys_login_log` VALUES (2800, 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:16:54', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (2801, 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2019-01-21 10:16:54', 'admin', '2019-01-22 14:43:09');
INSERT INTO `sys_login_log` VALUES (2802, 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:43:09', NULL, NULL);
INSERT INTO `sys_login_log` VALUES (2803, 'admin', 'online', '0:0:0:0:0:0:0:1', 'admin', '2019-01-22 14:43:09', NULL, NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  `type` int NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件',
  `redirect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重定向',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'welcome', 0, '/dashboard', NULL, 1, NULL, 0, NULL, NULL, NULL, NULL, 0, '/dashboard/welcome/index', NULL);
INSERT INTO `sys_menu` VALUES (2, 'Factory', 0, '/factory', NULL, 0, NULL, 1, NULL, NULL, NULL, NULL, 0, 'LAYOUT', '/factory/gen');
INSERT INTO `sys_menu` VALUES (3, 'Generator', 2, 'gen', NULL, 1, NULL, 1, NULL, NULL, NULL, NULL, 0, '/factory/gen/index', NULL);
INSERT INTO `sys_menu` VALUES (4, 'System', 0, '/system', NULL, 0, NULL, 2, NULL, NULL, NULL, NULL, 0, 'LAYOUT', '/system/account');
INSERT INTO `sys_menu` VALUES (5, 'AccountManagement', 4, 'account', NULL, 1, NULL, 1, NULL, NULL, NULL, NULL, 0, '/system/account/index', NULL);
INSERT INTO `sys_menu` VALUES (6, 'RoleManagement', 4, 'role', NULL, 1, NULL, 2, NULL, NULL, NULL, NULL, 0, '/system/role/index', NULL);
INSERT INTO `sys_menu` VALUES (7, 'MenuManagement', 4, 'menu', NULL, 1, NULL, 3, NULL, NULL, NULL, NULL, 0, '/system/menu/index', NULL);
INSERT INTO `sys_menu` VALUES (8, 'DeptManagement', 4, 'dept', NULL, 1, NULL, 4, NULL, NULL, NULL, NULL, 0, '/system/dept/index', NULL);
INSERT INTO `sys_menu` VALUES (9, 'ChangePassword', 4, 'changePassword', NULL, 1, NULL, 5, NULL, NULL, NULL, NULL, 0, '/system/password/index', NULL);

-- ----------------------------
-- Table structure for sys_menu_meta
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_meta`;
CREATE TABLE `sys_menu_meta`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `menu_id` bigint NULL DEFAULT NULL COMMENT '菜单id',
  `meta_id` bigint NULL DEFAULT NULL COMMENT 'metaId',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu_meta
-- ----------------------------
INSERT INTO `sys_menu_meta` VALUES (1, 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (2, 2, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (3, 3, 3, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (4, 4, 4, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (5, 5, 5, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (6, 6, 6, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (7, 7, 7, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (8, 8, 8, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_meta` VALUES (9, 9, 9, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_meta
-- ----------------------------
DROP TABLE IF EXISTS `sys_meta`;
CREATE TABLE `sys_meta`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `ignore_auth` bit(1) NULL DEFAULT NULL COMMENT '是否忽略权限',
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '可以访问的角色',
  `ignore_keep_alive` bit(1) NULL DEFAULT NULL COMMENT '是否忽略KeepAlive缓存',
  `affix` bit(1) NULL DEFAULT NULL COMMENT '是否固定标签',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标',
  `frame_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内嵌iframe的地址',
  `transition_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '指定该路由切换的动画名',
  `hide_breadcrumb` bit(1) NULL DEFAULT NULL COMMENT '隐藏该路由在面包屑上面的显示',
  `carry_param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true',
  `hide_children_in_menu` bit(1) NULL DEFAULT NULL COMMENT '隐藏所有子菜单',
  `current_active_menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前激活的菜单。用于配置详情页时左侧激活的菜单路径',
  `hide_tab` bit(1) NULL DEFAULT NULL COMMENT '当前路由不再标签页显示',
  `hide_menu` bit(1) NULL DEFAULT NULL COMMENT '当前路由不再菜单显示',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_meta
-- ----------------------------
INSERT INTO `sys_meta` VALUES (1, 'routes.dashboard.welcome', NULL, NULL, NULL, b'1', 'bx:bx-home', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (2, 'routes.factory.factory', NULL, NULL, NULL, NULL, 'bx:bx-cube-alt', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (3, 'routes.factory.generator', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (4, 'routes.system.system.moduleName', NULL, NULL, NULL, NULL, 'ion:settings-outline', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (5, 'routes.system.system.account', NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (6, 'routes.system.system.role', NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (7, 'routes.system.system.menu', NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (8, 'routes.system.system.dept', NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_meta` VALUES (9, 'routes.system.system.password', NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  `status` bit(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '超级管理员', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 19:07:18', 0, NULL);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint NULL DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色机构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (1, 1, 1, 'admin', '2019-01-11 08:30:37', 'admin', '2019-01-11 08:30:25');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint NULL DEFAULT NULL COMMENT '菜单ID',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint NULL DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注\r\n',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '超管', NULL, 'bd1718f058d8a02468134432b8656a86', 'YzcmCZNvbXocrsz9dm8e', 'admin@qq.com', '13612345678', 1, 4, 'admin', '2018-08-14 11:11:11', 'admin', '2018-08-14 11:11:11', 0, '测试');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint NOT NULL,
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modified_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, 1, 'ee02ead2c1e3a113f82accafaf878b69', '2018-12-27 23:08:41', NULL, NULL, 'admin', '2018-12-27 11:08:41');
INSERT INTO `sys_user_token` VALUES (2, 17, '3d32077ccddb6eb2c4302feb93765cd0', '2018-09-24 05:11:17', NULL, NULL, NULL, '2018-09-23 17:11:17');
INSERT INTO `sys_user_token` VALUES (3, 18, 'a939ac41fd309ca785485b4135b8baad', '2018-09-24 05:10:36', NULL, NULL, NULL, '2018-09-23 17:10:36');
INSERT INTO `sys_user_token` VALUES (4, 33, '605dbcfa2277cbca3b2a124974816080', '2018-11-04 21:42:49', NULL, NULL, NULL, '2018-11-04 09:42:49');

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
  `def` bit(1) NULL DEFAULT NULL COMMENT '是否默认数据源',
  `db_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库类型',
  PRIMARY KEY (`id`, `source_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_data_source
-- ----------------------------
INSERT INTO `system_data_source` VALUES (1, 'kuroneko', 'root', 'root', 'jdbc:mysql://localhost:3306/kuroneko?serverTimezone=UTC', 'com.mysql.cj.jdbc.Driver', '2021-05-28 08:11:20', '2021-05-31 09:11:49', b'1', 'mysql');
INSERT INTO `system_data_source` VALUES (2, 'YinLuDWQAS', 'sa', 'Dzh970102', 'jdbc:sqlserver://localhost:1433;DatabaseName=YinLuDWQAS', 'com.microsoft.sqlserver.jdbc.SQLServerDriver', '2021-05-27 10:06:22', '2021-05-31 09:11:43', b'0', 'sqlserver');

SET FOREIGN_KEY_CHECKS = 1;
