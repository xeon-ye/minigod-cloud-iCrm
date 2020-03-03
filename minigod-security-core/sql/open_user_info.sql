
DROP TABLE IF EXISTS `custom_basic`;

CREATE TABLE `custom_basic` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id（自增主键）',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码（可空）',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态 0-停用,1-正常,2-锁定',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_mobile` (`mobile`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本表'


DROP TABLE IF EXISTS `custom_session`;

CREATE TABLE `custom_session` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '会话的id（自增主键）',
  `user_id` int(20) NOT NULL COMMENT '用户ID',
  `device_id` int(11) NOT NULL COMMENT '设备ID',
  `session` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `expire_time` datetime NOT NULL COMMENT 'session过期时间',
  `is_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效(1有效,0无效)',
  `msg` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `session` (`session`),
  KEY `user_id` (`user_id`,`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='会话管理表'

DROP TABLE IF EXISTS `verify_id_card`;

CREATE TABLE `verify_id_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',
  `is_valid` tinyint(1) DEFAULT NULL COMMENT '状态(0:不通过 1:通过)',
  `remark` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `check_count` int(2) DEFAULT '1' COMMENT '验证次数',
  `check_date` datetime DEFAULT NULL COMMENT '验证时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `index_card_verify` (`user_name`,`id_card`),
  KEY `idx_id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='身份证验证信息表'

DROP TABLE IF EXISTS `verify_bank_card`;

CREATE TABLE `verify_bank_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',
  `bank_card` varchar(30) DEFAULT NULL COMMENT '银行卡号',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `is_valid` tinyint(1) DEFAULT NULL COMMENT '状态(0:不通过 1:通过)',
  `remark` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `check_count` int(2) DEFAULT '1' COMMENT '验证次数',
  `check_date` datetime DEFAULT NULL COMMENT '验证时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `index_card_verify` (`user_name`,`id_card`,`bank_card`,`mobile`),
  KEY `idx_id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='银行卡四要素验证信息表'

DROP TABLE IF EXISTS `custom_open_info`;

CREATE TABLE `custom_open_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `status` int(4) DEFAULT '0' COMMENT '0:未提交（默认），1:开户中，2:已取消,3:开户成功，4:开户失败，5:销户',
  `access_way` int(2) DEFAULT NULL COMMENT '开户接入方式: 1:H5开户 2:APP开户',
  `account_type` int(2) DEFAULT NULL COMMENT '账户类型 1：现金账户 2：融资账户',
  `open_way` int(2) DEFAULT NULL COMMENT '开户方式：0:未知，1:线上内地开户，2:线上香港开户，2:线下（开户宝）',
  `account_markets` varchar(20) DEFAULT NULL COMMENT '账户类型：1：港股 2：美股 3：中华通',

  `pending_type` int(4) DEFAULT NULL COMMENT '0:预批中，1:审批中，2:CA认证中,3:柜台开户中',
  `fail_type` int(4) DEFAULT NULL COMMENT '0:其他错误，1:基本数据错误，2:影像数据错误,3:基本或影像数据错误，4:CA数据错误',
  `open_result` varchar(500) DEFAULT NULL COMMENT '开户结果',

  `is_need_push` tinyint(4) DEFAULT '0' COMMENT '是否需要推送',
  `push_err_count` int(2) DEFAULT '0' COMMENT '推送失败次数',
  `remote_id` varchar(20) DEFAULT NULL COMMENT '远程开户系统ID',
  `open_date` datetime DEFAULT NULL COMMENT '开户日期',
  `trade_account` varchar(20) DEFAULT NULL COMMENT '客户号（交易帐号）',
  `is_send` tinyint(4) DEFAULT '0' COMMENT '是否发送消息',

  `info` varchar(4000) DEFAULT NULL COMMENT '开户数据',
  `open_account_pdf_url` varchar(256) DEFAULT NULL COMMENT '开户PDF文件地址',

  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_id` (`user_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8


INSERT INTO `clound_mg_main`.`custom_open_info` (
  `user_id`,
  `email`,
  `phone`,
  `id_card`,
  `status`,
  `access_way`,
  `account_type`,
  `open_way`,
  `account_markets`,
  `pending_type`,
  `fail_type`,
  `open_result`,
  `is_need_push`,
  `push_err_count`,
  `remote_id`,
  `open_date`,
  `trade_account`,
  `is_send`,
  `info`,
  `open_account_pdf_url`
)
VALUES
  (
    589857,
    'jim@zszhizhu.com',
    'phone',
    '430381198010101122',
    3,
    1,
    1,
    1,
    '[1,2,3]',
    null,
    null,
    '',
    0,
    0,
    '2019111210000001',
    '2019-11-13 15:07:02',
    '1000002212',
    1,
    '',
    ''
  );
