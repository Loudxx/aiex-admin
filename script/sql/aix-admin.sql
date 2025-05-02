/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : aix-admin

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/05/2025 10:26:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单标识',
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单类型',
  `sort` int DEFAULT NULL COMMENT '排序',
  `parent_id` bigint DEFAULT NULL COMMENT '父菜单id',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '组件路径',
  `icon` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图标',
  `status` tinyint NOT NULL COMMENT '状态',
  `deleted` tinyint(1) NOT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` bigint DEFAULT NULL COMMENT '创建人',
  `modify_by` bigint DEFAULT NULL COMMENT '修改人',
  `meta` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `component` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `redirect` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, 'Dashboard', 'dashboard', '0', 1, 0, '/', NULL, 0, 0, '2024-11-18 14:28:46', '2024-11-18 14:28:50', 1, 1, '{\"order\": -1, \"title\": \"page.dashboard.title\"}', 'BasicLayout', '/analytics');
INSERT INTO `sys_menu` VALUES (2, 'Analytics', 'analytics', '0', 1, 1, '/analytics', NULL, 0, 0, '2024-11-18 14:28:46', '2024-11-18 14:28:50', 1, 1, '{ \"affixTab\": true, \"title\": \"page.dashboard.analytics\"}', 'views/dashboard/analytics/index', NULL);
INSERT INTO `sys_menu` VALUES (3, 'Workspace', 'workspace', '0', 1, 1, '/workspace', NULL, 0, 0, '2024-11-18 14:28:46', '2024-11-18 14:28:50', 1, 1, '{\"title\": \"page.dashboard.workspace\"}', 'views/dashboard/workspace/index', '');
INSERT INTO `sys_menu` VALUES (4, 'System', 'system', '0', 2, 0, '/system', NULL, 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, '{\"title\": \"page.system.title\"}', '', NULL);
INSERT INTO `sys_menu` VALUES (5, 'User', 'user', '0', 2, 4, '/user', NULL, 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, '{\"title\": \"page.system.user\"}', 'views/system/user/list', NULL);
INSERT INTO `sys_menu` VALUES (6, 'Role', 'role', '0', 2, 4, '/role', NULL, 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, '{\"title\": \"page.system.role\"}', 'views/system/role/list', NULL);
INSERT INTO `sys_menu` VALUES (7, 'Menu', 'menu', '0', 2, 4, '/menu', NULL, 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, '{\"title\": \"page.system.menu\"}', 'views/system/menu/list', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色编码',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `create_by` bigint DEFAULT NULL COMMENT '创建人',
  `modify_by` bigint DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, 'admin', '超级管理员', 0, 0, '2024-11-18 14:26:07', '2024-11-18 14:26:10', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `email` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `token` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '令牌',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `ipaddr` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ip地址',
  `login_location` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录地址',
  `browser` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器',
  `os` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作系统',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$tlA11dMU54OEp3qDKicgm.aMKYVJ2h7dFvWnq8ImtpOoSZDNlYuZ2', '管理员', NULL, NULL, 0, NULL, 0, '2024-10-07 20:53:47', '2024-10-07 20:53:51', '1', '1', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
