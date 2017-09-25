
CREATE TABLE log_icecoldmonitor (
Id int(11) NOT NULL AUTO_INCREMENT,
level varchar(255) NOT NULL DEFAULT '' COMMENT '优先级',
category varchar(255) NOT NULL DEFAULT '' COMMENT '类目',
thread varchar(255) NOT NULL DEFAULT '' COMMENT '进程',
time varchar(30) NOT NULL DEFAULT '' COMMENT '时间',
location varchar(255) NOT NULL DEFAULT '' COMMENT '位置',
note text COMMENT '日志信息',
PRIMARY KEY (Id)
)