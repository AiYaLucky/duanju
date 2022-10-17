# 创建用户表
DROP TABLE IF EXISTS user;
CREATE TABLE `user`
(
    `uid`          varchar(64) NOT NULL COMMENT 'uid',
    `nickname`     varchar(64) NOT NULL DEFAULT '' COMMENT '昵称',
    `account`      varchar(64) NOT NULL DEFAULT '0' COMMENT '账号',
    `password`     varchar(64) NOT NULL DEFAULT '0' COMMENT '密码',
    `phone`        int(11)     NOT NULL DEFAULT '0' COMMENT '手机',
    `address`      varchar(128)         DEFAULT '' COMMENT '地址',
    `level`        int(11)              DEFAULT 0 COMMENT '等级',
    `exp`          bigint(20)           DEFAULT 0 COMMENT '经验',
    `viplevel`     int(11)              DEFAULT 0 COMMENT 'VIP等级',
    `vipexp`       int(11)              DEFAULT 0 COMMENT 'VIP经验',
    `gold`         bigint(20)           DEFAULT 0 COMMENT '金币',
    `silver`       bigint(20)           DEFAULT 0 COMMENT '银币',
    `copper`       bigint(20)           DEFAULT 0 COMMENT '铜币',
    `sign`         varchar(128)         DEFAULT '' COMMENT '签名',
    `voice`        int(11)              DEFAULT 1 COMMENT '声音开关',
    `music`        int(11)              DEFAULT 1 COMMENT '音乐开关',
    `registerTime` bigint(20)           DEFAULT '0' COMMENT '注册时间',
    `lastlogin`    bigint(20)           DEFAULT '0' COMMENT '最后一次登陆时间',
    `loginday`     int(11)              DEFAULT '0' COMMENT '累计登陆天数',
    `platform`     varchar(20)          DEFAULT '' COMMENT '渠道标识',
    `ip`           varchar(30)          DEFAULT '' COMMENT '注册IP',
    `country`      varchar(64)          DEFAULT '' COMMENT '注册国家',
    PRIMARY KEY (`uid`),
    UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
