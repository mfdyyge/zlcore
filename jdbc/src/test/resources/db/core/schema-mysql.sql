

--  新建一个数据库模式，指定编码utf-8，否则会出现乱码
CREATE DATABASE activity CHARACTER SET utf8;
--选中此数据库md11utf8：

-- mysql>
USE activity;


-- 流程定义表
CREATE TABLE wf_process (
    id                VARCHAR(100) PRIMARY KEY NOT NULL COMMENT '主键ID',
    NAME              VARCHAR(100) COMMENT '流程名称',
    display_Name      VARCHAR(200) COMMENT '流程显示名称',
    TYPE              VARCHAR(100) COMMENT '流程类型',
    instance_Url      VARCHAR(200) COMMENT '实例url',
    state             TINYINT(1) COMMENT '流程是否可用',
    content           LONGBLOB COMMENT '流程模型定义',
    VERSION           INT(2) COMMENT '版本',
    create_Time       VARCHAR(50) COMMENT '创建时间',
    creator           VARCHAR(50) COMMENT '创建人'
)COMMENT='流程定义表';

-- 流程实例表
CREATE TABLE wf_order (
    id                VARCHAR(100) NOT NULL PRIMARY KEY COMMENT '主键ID',
    parent_Id         VARCHAR(100) COMMENT '父流程ID',
    process_Id        VARCHAR(100) NOT NULL COMMENT '流程定义ID',
    creator           VARCHAR(100) COMMENT '发起人',
    create_Time       VARCHAR(50) NOT NULL COMMENT '发起时间',
    expire_Time       VARCHAR(50) COMMENT '期望完成时间',
    last_Update_Time  VARCHAR(50) COMMENT '上次更新时间',
    last_Updator      VARCHAR(100) COMMENT '上次更新人',
    priority          TINYINT(1) COMMENT '优先级',
    parent_Node_Name  VARCHAR(100) COMMENT '父流程依赖的节点名称',
    order_No          VARCHAR(100) COMMENT '流程实例编号',
    variable          VARCHAR(2000) COMMENT '附属变量json存储',
    VERSION           INT(3) COMMENT '版本'
)COMMENT='流程实例表';

-- 任务表
CREATE TABLE wf_task (
    id                VARCHAR(100) NOT NULL PRIMARY KEY COMMENT '主键ID',
    order_Id          VARCHAR(100) NOT NULL COMMENT '流程实例ID',
    task_Name         VARCHAR(100) NOT NULL COMMENT '任务名称',
    display_Name      VARCHAR(200) NOT NULL COMMENT '任务显示名称',
    task_Type         TINYINT(1) NOT NULL COMMENT '任务类型',
    perform_Type      TINYINT(1) COMMENT '参与类型',
    operator          VARCHAR(100) COMMENT '任务处理人',
    create_Time       VARCHAR(50) COMMENT '任务创建时间',
    finish_Time       VARCHAR(50) COMMENT '任务完成时间',
    expire_Time       VARCHAR(50) COMMENT '任务期望完成时间',
    action_Url        VARCHAR(200) COMMENT '任务处理的url',
    parent_Task_Id    VARCHAR(100) COMMENT '父任务ID',
    variable          VARCHAR(2000) COMMENT '附属变量json存储',
    VERSION           TINYINT(1) COMMENT '版本'
)COMMENT='任务表';

-- 任务参与者表
CREATE TABLE wf_task_actor (
    task_Id           VARCHAR(100) NOT NULL COMMENT '任务ID',
    actor_Id          VARCHAR(100) NOT NULL COMMENT '参与者ID'
)COMMENT='任务参与者表';

-- 历史流程实例表
CREATE TABLE wf_hist_order (
    id                VARCHAR(100) NOT NULL PRIMARY KEY COMMENT '主键ID',
    process_Id        VARCHAR(100) NOT NULL COMMENT '流程定义ID',
    order_State       TINYINT(1) NOT NULL COMMENT '状态',
    creator           VARCHAR(100) COMMENT '发起人',
    create_Time       VARCHAR(50) NOT NULL COMMENT '发起时间',
    end_Time          VARCHAR(50) COMMENT '完成时间',
    expire_Time       VARCHAR(50) COMMENT '期望完成时间',
    priority          TINYINT(1) COMMENT '优先级',
    parent_Id         VARCHAR(100) COMMENT '父流程ID',
    order_No          VARCHAR(100) COMMENT '流程实例编号',
    variable          VARCHAR(2000) COMMENT '附属变量json存储'
)COMMENT='历史流程实例表';

-- 历史任务表
CREATE TABLE wf_hist_task (
    id                VARCHAR(100) NOT NULL PRIMARY KEY COMMENT '主键ID',
    order_Id          VARCHAR(100) NOT NULL COMMENT '流程实例ID',
    task_Name         VARCHAR(100) NOT NULL COMMENT '任务名称',
    display_Name      VARCHAR(200) NOT NULL COMMENT '任务显示名称',
    task_Type         TINYINT(1) NOT NULL COMMENT '任务类型',
    perform_Type      TINYINT(1) COMMENT '参与类型',
    task_State        TINYINT(1) NOT NULL COMMENT '任务状态',
    operator          VARCHAR(100) COMMENT '任务处理人',
    create_Time       VARCHAR(50) NOT NULL COMMENT '任务创建时间',
    finish_Time       VARCHAR(50) COMMENT '任务完成时间',
    expire_Time       VARCHAR(50) COMMENT '任务期望完成时间',
    action_Url        VARCHAR(200) COMMENT '任务处理url',
    parent_Task_Id    VARCHAR(100) COMMENT '父任务ID',
    variable          VARCHAR(2000) COMMENT '附属变量json存储'
)COMMENT='历史任务表';

-- 历史任务参与者表
CREATE TABLE wf_hist_task_actor (
    task_Id           VARCHAR(100) NOT NULL COMMENT '任务ID',
    actor_Id          VARCHAR(100) NOT NULL COMMENT '参与者ID'
)COMMENT='历史任务参与者表';

-- 委托代理表
CREATE TABLE wf_surrogate (
    id                VARCHAR(100) PRIMARY KEY NOT NULL COMMENT '主键ID',
    process_Name       VARCHAR(100) COMMENT '流程名称',
    operator          VARCHAR(100) COMMENT '授权人',
    surrogate         VARCHAR(100) COMMENT '代理人',
    odate             VARCHAR(64) COMMENT '操作时间',
    sdate             VARCHAR(64) COMMENT '开始时间',
    edate             VARCHAR(64) COMMENT '结束时间',
    state             TINYINT(1) COMMENT '状态'
)COMMENT='委托代理表';

CREATE INDEX IDX_SURROGATE_OPERATOR ON wf_surrogate (operator);

-- 抄送实例表
CREATE TABLE wf_cc_order (
    order_Id        VARCHAR(100) COMMENT '流程实例ID',
    actor_Id        VARCHAR(100) COMMENT '参与者ID',
    create_Time     VARCHAR(50) COMMENT '抄送时间',
    finish_Time     VARCHAR(50) COMMENT '完成时间',
    STATUS          TINYINT(1)  COMMENT '状态'
)COMMENT='抄送实例表';
CREATE INDEX IDX_CCORDER_ORDER ON wf_cc_order (order_Id);

-- 对若干字段增加索引
CREATE INDEX IDX_PROCESS_NAME ON wf_process (NAME);
CREATE INDEX IDX_ORDER_PROCESSID ON wf_order (process_Id);
CREATE INDEX IDX_ORDER_NO ON wf_order (order_No);
CREATE INDEX IDX_TASK_ORDER ON wf_task (order_Id);
CREATE INDEX IDX_TASK_TASKNAME ON wf_task (task_Name);
CREATE INDEX IDX_TASK_PARENTTASK ON wf_task (parent_Task_Id);
CREATE INDEX IDX_TASKACTOR_TASK ON wf_task_actor (task_Id);
CREATE INDEX IDX_HIST_ORDER_PROCESSID ON wf_hist_order (process_Id);
CREATE INDEX IDX_HIST_ORDER_NO ON wf_hist_order (order_No);
CREATE INDEX IDX_HIST_TASK_ORDER ON wf_hist_task (order_Id);
CREATE INDEX IDX_HIST_TASK_TASKNAME ON wf_hist_task (task_Name);
CREATE INDEX IDX_HIST_TASK_PARENTTASK ON wf_hist_task (parent_Task_Id);
CREATE INDEX IDX_HIST_TASKACTOR_TASK ON wf_hist_task_actor (task_Id);

-- 增加外键关联约束
ALTER TABLE WF_TASK_ACTOR
    ADD CONSTRAINT FK_TASK_ACTOR_TASKID FOREIGN KEY (TASK_ID)
REFERENCES WF_TASK (ID);
ALTER TABLE WF_TASK
    ADD CONSTRAINT FK_TASK_ORDERID FOREIGN KEY (ORDER_ID)
REFERENCES WF_ORDER (ID);
ALTER TABLE WF_ORDER
    ADD CONSTRAINT FK_ORDER_PARENTID FOREIGN KEY (PARENT_ID)
REFERENCES WF_ORDER (ID);
ALTER TABLE WF_ORDER
    ADD CONSTRAINT FK_ORDER_PROCESSID FOREIGN KEY (PROCESS_ID)
REFERENCES WF_PROCESS (ID);
ALTER TABLE WF_HIST_TASK_ACTOR
    ADD CONSTRAINT FK_HIST_TASKACTOR FOREIGN KEY (TASK_ID)
REFERENCES WF_HIST_TASK (ID);
ALTER TABLE WF_HIST_TASK
    ADD CONSTRAINT FK_HIST_TASK_ORDERID FOREIGN KEY (ORDER_ID)`wf_cc_order``wf_cc_order`
REFERENCES WF_HIST_ORDER (ID);
ALTER TABLE WF_HIST_ORDER
    ADD CONSTRAINT FK_HIST_ORDER_PARENTID FOREIGN KEY (PARENT_ID)
REFERENCES WF_HIST_ORDER (ID);
ALTER TABLE WF_HIST_ORDER
    ADD CONSTRAINT FK_HIST_ORDER_PROCESSID FOREIGN KEY (PROCESS_ID)
REFERENCES WF_PROCESS (ID);