/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : aix-admin

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 20/10/2025 01:30:51
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
  `type` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单类型',
  `parent_id` bigint DEFAULT NULL COMMENT '父菜单id',
  `path` varchar(128) COLLATE utf8mb4_general_ci NOT NULL COMMENT '路由地址',
  `component` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件路径',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `deleted` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_by` bigint DEFAULT NULL,
  `modify_by` bigint DEFAULT NULL,
  `redirect` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `meta` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`, `redirect`, `meta`) VALUES (1, 'Dashboard', 'catalog', NULL, '/', 'BasicLayout', 0, 0, '2024-11-18 14:28:46', '2024-11-18 14:28:50', 1, 1, '/analytics', '{\"order\": -1, \"title\": \"page.dashboard.title\"}');
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`, `redirect`, `meta`) VALUES (2, 'Analytics', 'menu', 1, '/analytics', 'views/dashboard/analytics/index', 0, 0, '2024-11-18 14:28:46', '2024-11-18 14:28:50', 1, 1, NULL, '{ \"affixTab\": true, \"title\": \"page.dashboard.analytics\"}');
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`, `redirect`, `meta`) VALUES (3, 'Workspace', 'menu', 1, '/workspace', 'views/dashboard/workspace/index', 0, 0, '2024-11-18 14:28:46', '2024-11-18 14:28:50', 1, 1, '', '{\"title\": \"page.dashboard.workspace\"}');
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`, `redirect`, `meta`) VALUES (4, 'System', 'catalog', NULL, '/system', '', 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, NULL, '{\"title\": \"page.system.title\"}');
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`, `redirect`, `meta`) VALUES (5, 'User', 'menu', 4, '/user', 'views/system/user/index', 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, NULL, '{\"title\": \"page.system.user\"}');
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`, `redirect`, `meta`) VALUES (6, 'Role', 'menu', 4, '/role', 'views/system/role/index', 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, NULL, '{\"title\": \"page.system.role\"}');
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`, `redirect`, `meta`) VALUES (7, 'Menu', 'menu', 4, '/menu', 'views/system/menu/index', 0, 0, '2025-04-17 23:01:51', '2025-04-17 23:01:54', 1, 1, NULL, '{\"title\": \"page.system.menu\"}');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`id`, `code`, `name`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`) VALUES (1, 'admin', '超级管理员', 0, 0, '2024-11-18 14:26:07', '2024-11-18 14:26:10', 1, 1);
INSERT INTO `sys_role` (`id`, `code`, `name`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`) VALUES (2, 'test1', '测试1', 0, 0, '2024-11-18 14:26:07', '2025-10-02 22:39:15', 1, 1);
INSERT INTO `sys_role` (`id`, `code`, `name`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`) VALUES (3, '测试2', 'test2', 0, 1, '2025-10-02 19:43:33', '2025-10-02 19:43:33', 1, 1);
INSERT INTO `sys_role` (`id`, `code`, `name`, `status`, `deleted`, `create_time`, `modify_time`, `create_by`, `modify_by`) VALUES (4, 'test2', '测试2', 0, 1, '2025-10-02 19:44:15', '2025-10-02 19:44:15', 1, 1);
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
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 1);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 3);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `username`, `password`, `nickname`, `email`, `mobile`, `sex`, `avatar`, `status`, `create_time`, `modify_time`, `create_by`, `modify_by`, `deleted`, `token`, `login_time`, `expire_time`, `ipaddr`, `login_location`, `browser`, `os`) VALUES (1, 'admin', '$2a$10$aynU145Ls4BOXbqGbV5Xo.9AZiToK4IHSN9cJ1RTeOPPSkU3zZz9e', '管理员', '111111111@qq.com', '13111111111', 0, NULL, 0, '2025-06-15 23:09:19', '2025-09-30 21:49:32', '1', '1', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` (`id`, `username`, `password`, `nickname`, `email`, `mobile`, `sex`, `avatar`, `status`, `create_time`, `modify_time`, `create_by`, `modify_by`, `deleted`, `token`, `login_time`, `expire_time`, `ipaddr`, `login_location`, `browser`, `os`) VALUES (2, 'test', '$2a$10$zLsJoiXf66Q2HttB44.k/.ZZCkdhapzFfajxm5OoE3V1ejb69IPXy', '测试1', '131111111@qq.com', '13111111111', 0, '', 0, '2025-06-15 14:24:11', '2025-09-30 21:58:14', '1', '1', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` (`id`, `username`, `password`, `nickname`, `email`, `mobile`, `sex`, `avatar`, `status`, `create_time`, `modify_time`, `create_by`, `modify_by`, `deleted`, `token`, `login_time`, `expire_time`, `ipaddr`, `login_location`, `browser`, `os`) VALUES (3, 'test2', NULL, '测试2', '123@qq.com', '1213778976', 0, NULL, 0, '2025-07-29 23:56:55', '2025-07-29 23:56:55', '1', '1', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` (`id`, `username`, `password`, `nickname`, `email`, `mobile`, `sex`, `avatar`, `status`, `create_time`, `modify_time`, `create_by`, `modify_by`, `deleted`, `token`, `login_time`, `expire_time`, `ipaddr`, `login_location`, `browser`, `os`) VALUES (4, 'test3', NULL, '测试3', '123@qq.com', '13241222222', 1, NULL, 0, '2025-07-31 23:42:44', '2025-08-02 19:31:30', '1', '1', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
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
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (2, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
