#用户表
CREATE TABLE t_user (
	id VARCHAR ( 50 ) NOT NULL,
	user_name VARCHAR ( 100 ) DEFAULT NULL COMMENT '用户名',
	PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT CHARSET = utf8;

#事件表
CREATE TABLE t_event (
	id int (11) NOT NULL AUTO_INCREMENT,
	type VARCHAR(30) DEFAULT NULL COMMENT '事件类型',
    process VARCHAR(30) DEFAULT NULL COMMENT '表示事件进行到了哪个环节',
	content text COMMENT '事件包含的内容',
	create_time datetime DEFAULT NULL,
	update_time datetime DEFAULT NULL,
	PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT CHARSET = utf8;

#积分表
CREATE TABLE t_point (
	id VARCHAR (50) NOT NULL,
	user_id VARCHAR(50) DEFAULT NULL COMMENT '关联的用户id',
    amount int(11) DEFAULT NULL COMMENT '积分金额',
	PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT CHARSET = utf8;

#事件表
CREATE TABLE t_event (
	id int (11) NOT NULL AUTO_INCREMENT,
	type VARCHAR(30) DEFAULT NULL COMMENT '事件类型',
    process VARCHAR(30) DEFAULT NULL COMMENT '表示事件进行到了哪个环节',
	content text COMMENT '事件包含的内容',
	create_time datetime DEFAULT NULL,
	update_time datetime DEFAULT NULL,
	PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT CHARSET = utf8;