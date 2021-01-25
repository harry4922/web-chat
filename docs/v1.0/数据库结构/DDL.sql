#创建数据库
CREATE DATABASE web_chat_db;
#进入数据库
USE web_chat_db;
/*
 * 创建角色表
 * 角色表						tab_role
 * 角色ID						role_id									BIGINT								PRIMARY KEY							AUTO_INCREMENT
 * 角色名称						role_name								VARCHAR(255)
 * 登录权限						is_logonable							BOOLEAN								DEFAULT false
 * 管理者权限					is_admin								BOOLEAN								DEFAILT false
 * 创建群聊权限					is_group_creater						BOOLEAN								DEFAULT false
 */
CREATE TABLE tab_role
(
	role_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "角色ID",
    role_name VARCHAR(255) COMMENT "角色名称",
    is_logonable BOOLEAN DEFAULT false COMMENT "登录权限",
    is_admin BOOLEAN DEFAULT false COMMENT "管理者权限",
    is_group_creater BOOLEAN DEFAULT false COMMENT "创建群聊权限"
)
ENGINE=INNODB DEFAULT CHARSET=UTF8;
/*
 * 创建用户表
 * 用户表						tab_user
 * 用户ID						user_id									BIGINT								PRIMARY KEY				 			AUTO_INCREMENT
 * 用户登录名					user_name								VARCHAR(50)
 * 用户真实姓名					user_real_name							VARCHAR(100)
 * 用户手机号					user_mobel								VARCHAR(255)
 * 用户邮箱						user_mail								VARCHAR(255)
 * 用户密码						user_password							VARCHAR(255)
 * 用户上次登出前最后的版本号	last_version							BIGINT								DEFAULT 1
 * 用户角色ID					role_id									BIGINT								FOREIGN_KEY(fk_user_role)
 */
 CREATE TABLE tab_user
 (
	user_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "用户ID",
    user_name VARCHAR(50) COMMENT "用户登录名",
    user_real_name VARCHAR(100) COMMENT "用户真实姓名",
    user_mobel VARCHAR(255) COMMENT "用户手机号",
    user_mail VARCHAR(255) COMMENT "用户邮箱",
    user_password VARCHAR(255) COMMENT "用户密码",
    last_version BIGINT DEFAULT 1 COMMENT "用户上次登出前最后的版本信息号",
    role_id BIGINT COMMENT "用户角色ID",
    CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES tab_role (role_id)
 )
 ENGINE=INNODB DEFAULT CHARSET=UTF8;
 
 
/*
 * 聊天信息表										tab_chat_info
 * 用户ID											user_id										BIGINT									PRIMARY KEY					FOREIGN_KEY fk_chat_user
 * 对方用户ID										other_user_id								BIGINT									PRIMARY KEY					FOREIGN_KEY fk_chat_other_user
 * 当前信息版本号									version										BIGINT									PRIMARY KEY
 * 聊天内容											chat_content								VARCHAR(255)
 */
CREATE TABLE tab_chat_info1
(
	user_id BIGINT,
	other_user_id BIGINT,
	version BIGINT,
	chat_content VARCHAR(255),
	PRIMARY KEY (user_id , other_user_id , version),
	CONSTRAINT fk_chat_user1 FOREIGN KEY (user_id) REFERENCES tab_user (user_id),
	CONSTRAINT fk_chat_other_user1 FOREIGN KEY (other_user_id) REFERENCES tab_user (user_id)
)
ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE tab_chat_info2
(
	user_id BIGINT,
	other_user_id BIGINT,
	version BIGINT,
	chat_content VARCHAR(255),
	PRIMARY KEY (user_id , other_user_id , version),
	CONSTRAINT fk_chat_user2 FOREIGN KEY (user_id) REFERENCES tab_user (user_id),
	CONSTRAINT fk_chat_other_user2 FOREIGN KEY (other_user_id) REFERENCES tab_user (user_id)
)
ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE tab_chat_info3
(
	user_id BIGINT,
	other_user_id BIGINT,
	version BIGINT,
	chat_content VARCHAR(255),
	PRIMARY KEY (user_id , other_user_id , version),
	CONSTRAINT fk_chat_user3 FOREIGN KEY (user_id) REFERENCES tab_user (user_id),
	CONSTRAINT fk_chat_other_user3 FOREIGN KEY (other_user_id) REFERENCES tab_user (user_id)
)
ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE tab_chat_info4
(
	user_id BIGINT,
	other_user_id BIGINT,
	version BIGINT,
	chat_content VARCHAR(255),
	PRIMARY KEY (user_id , other_user_id , version),
	CONSTRAINT fk_chat_user4 FOREIGN KEY (user_id) REFERENCES tab_user (user_id),
	CONSTRAINT fk_chat_other_user4 FOREIGN KEY (other_user_id) REFERENCES tab_user (user_id)
)
ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE tab_chat_info5
(
	user_id BIGINT,
	other_user_id BIGINT,
	version BIGINT,
	chat_content VARCHAR(255),
	PRIMARY KEY (user_id , other_user_id , version),
	CONSTRAINT fk_chat_user5 FOREIGN KEY (user_id) REFERENCES tab_user (user_id),
	CONSTRAINT fk_chat_other_user5 FOREIGN KEY (other_user_id) REFERENCES tab_user (user_id)
)
ENGINE=INNODB DEFAULT CHARSET=UTF8;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 