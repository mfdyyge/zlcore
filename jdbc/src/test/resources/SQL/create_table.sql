
SELECT * FROM t_workflow_flow where VC_RECORD_ID='311a315da6724e89befbdb62eeb52c1f';

select * from t_workflow_man  where VC_RECORD_ID='311a315da6724e89befbdb62eeb52c1f';
select * from t_workflow_work where VC_RECORD_ID='311a315da6724e89befbdb62eeb52c1f';


--------------------------------------------------------
--  File created - Wednesday-April-30-2014
--------------------------------------------------------
select to_date('2018-7-28 03:12:00','yyyy-mm-dd hh24:mi:ss')-sysdate from dual;
select to_timestamp('2018-7-28 03:12:00','yyyy-mm-dd hh24:mi:ss')-systimestamp from dual;
--------------------------------------------------------
--  DDL for Table CLOB_TAB
--------------------------------------------------------

  CREATE TABLE "CLOB_TAB"
   (	"COLUMN1" VARCHAR2(20 BYTE),
	"COLUMN2" CLOB
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"
 LOB ("COLUMN2") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;

--------------------------------------------------------
--  DDL for Table TEST01
--------------------------------------------------------

  CREATE TABLE "TEST01"
   (	"DEPARTMENT_ID" NUMBER(4,0),
	"DEPARTMENT_NAME" VARCHAR2(30 BYTE),
	"MANAGER_ID" NUMBER(6,0),
	"LOCATION_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST02
--------------------------------------------------------

  CREATE TABLE "TEST02"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
   --------------------------------------------------------
--  DDL for Table TEST02A
--------------------------------------------------------

  CREATE TABLE "TEST02A"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "EXAMPLE" ;

--------------------------------------------------------
--  DDL for Table TEST03
--------------------------------------------------------

  CREATE TABLE "TEST03"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST03A
--------------------------------------------------------

  CREATE TABLE "TEST03A"
   (	"EMPLOYEE_ID"VARCHAR2(22 BYTE),
	"FIRST_NAME" VARCHAR2(22 BYTE),
	"LAST_NAME" VARCHAR2(27 BYTE),
	"EMAIL" VARCHAR2(27 BYTE),
	"PHONE_NUMBER" VARCHAR2(22 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(12 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "EXAMPLE" ;

--------------------------------------------------------
--  DDL for Table TEST04
--------------------------------------------------------

  CREATE TABLE "TEST04"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST05
--------------------------------------------------------

  CREATE TABLE "TEST05"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST05A
--------------------------------------------------------

  CREATE TABLE "TEST05A"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST06
--------------------------------------------------------

  CREATE TABLE "TEST06"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST06A
--------------------------------------------------------

  CREATE TABLE "TEST06A"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST07
--------------------------------------------------------

  CREATE TABLE "TEST07"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST07A
--------------------------------------------------------

  CREATE TABLE "TEST07A"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST07B
--------------------------------------------------------

  CREATE TABLE "TEST07B"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST08
--------------------------------------------------------
--insert records
insert into TEST08(VC2,TS) values('test',to_timestamp(to_char(sysdate,'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS'));
insert into TEST08(VC2,TS) values('test',to_timestamp('2018-07-26 13:12:22','YYYY-MM-DD HH24:MI:SS'));
insert into TEST08(VC2,TS) values('test',to_timestamp('2018-07-27','YYYY-MM-DD'));
insert into TEST08(VC2,TS) values('test',to_timestamp('2018-07-28','YYYY-MM-DD'));
insert into TEST08(VC2,TS) values('test',to_timestamp('2018-07-29','YYYY-MM-DD'));
insert into TEST08(VC2,TS) values('test',to_timestamp('2018-07-30','YYYY-MM-DD'));
insert into TEST08(VC2,TS) values('test',to_timestamp('2018-07-31','YYYY-MM-DD'));

insert into TEST08(VC2,TS) values('test1',to_timestamp(to_char(systimestamp,'YYYY-MM-DD HH24:MI:SS.FF'),'YYYY-MM-DD HH24:MI:SS.FF'));
insert into TEST08(VC2,TS) values('test2',systimestamp);
insert into TEST08(VC2,TS) values('test3',sysdate);


SELECT
to_char(Trunc(Trunc(SYSDATE, 'MONTH') - 1, 'MONTH'), 'YYYY-MM-DD')  as 当月第一天,
to_char(Trunc(SYSDATE, 'MONTH') - 1 / 86400, 'YYYY-MM-DD')	         as 当月最后一天,
to_char(Trunc(SYSDATE, 'MONTH'), 'YYYY-MM-DD') as 后月第一天,
to_char(LAST_DAY(Trunc(SYSDATE, 'MONTH')) + 1 - 1 / 86400, 'YYYY-MM-DD') as 后月最后一天
FROM dual;

select greatest(select ts  from TEST08) from dual;
--query records
select VC2,to_char(TS,'YYYY-MM-DD HH24:MI:SS.FF') as time  from TEST08;
--query records
select  VC2,to_char(TS,'YYYY-MM-DD HH24:MI:SS.FF') as time from TEST08 where  TS >= to_date('2018-07-26','YYYY-MM-DD');
select VC2,to_char(TS,'YYYY-MM-DD HH24:MI:SS.FF')  from TEST08 where to_timestamp('','YYYY-MM-DD HH24:MI:SS');
--------------------------------------------------------------------------------------------------------------------
  CREATE TABLE "TEST08"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS" TIMESTAMP (6) DEFAULT NULL
   ) ;
--------------------------------------------------------
--  DDL for Table TEST08A
--------------------------------------------------------

  CREATE TABLE "TEST08A"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS" TIMESTAMP (6) DEFAULT NULL
   ) ;
--------------------------------------------------------
--  DDL for Table TEST08B
--------------------------------------------------------

  CREATE TABLE "TEST08B"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS" TIMESTAMP (6) DEFAULT NULL
   ) ;
--------------------------------------------------------
--  DDL for Table TEST08C
--------------------------------------------------------

  CREATE TABLE "TEST08C"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS" TIMESTAMP (6) DEFAULT NULL
   ) ;
--------------------------------------------------------
--  DDL for Table TEST09
--------------------------------------------------------

  CREATE TABLE "TEST09"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS_TZ" TIMESTAMP (6) WITH TIME ZONE
   ) ;
--------------------------------------------------------
--  DDL for Table TEST09A
--------------------------------------------------------

  CREATE TABLE "TEST09A"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS_TZ" TIMESTAMP (6) WITH TIME ZONE
   ) ;
--------------------------------------------------------
--  DDL for Table TEST09B
--------------------------------------------------------

  CREATE TABLE "TEST09B"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS_TZ" TIMESTAMP (6) WITH TIME ZONE
   ) ;
--------------------------------------------------------
--  DDL for Table TEST09C
--------------------------------------------------------

  CREATE TABLE "TEST09C"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS_TZ" TIMESTAMP (6) WITH TIME ZONE
   ) ;
--------------------------------------------------------
--  DDL for Table TEST09D
--------------------------------------------------------

  CREATE TABLE "TEST09D"
   (	"VC2" VARCHAR2(60 BYTE),
	"TS_TZ" TIMESTAMP (6) WITH TIME ZONE
   ) ;
--------------------------------------------------------
--  DDL for Table TEST10
--------------------------------------------------------

  CREATE TABLE "TEST10"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST10A
--------------------------------------------------------

  CREATE TABLE "TEST10A"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(38,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST10B
--------------------------------------------------------

  CREATE TABLE "TEST10B"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" NUMBER(8,2),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" LONG,
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TEST10C
--------------------------------------------------------

  CREATE TABLE "TEST10C"
   (	"EMPLOYEE_ID" NUMBER(6,0),
	"FIRST_NAME" VARCHAR2(20 BYTE),
	"LAST_NAME" VARCHAR2(25 BYTE),
	"EMAIL" VARCHAR2(25 BYTE),
	"PHONE_NUMBER" VARCHAR2(20 BYTE),
	"HIRE_DATE" DATE,
	"JOB_ID" VARCHAR2(10 BYTE),
	"SALARY" FLOAT(126),
	"COMMISSION_PCT" NUMBER(2,2),
	"MANAGER_ID" NUMBER(6,0),
	"DEPARTMENT_ID" NUMBER(4,0)
   ) ;

		--------------------------------------------------------
		--  DDL for Table TEST11A
		--------------------------------------------------------

		  CREATE TABLE "TEST11A"
		   (	"EMPLOYEE_ID" NUMBER(6,0),
			"FIRST_NAME" VARCHAR2(20 BYTE),
			"LAST_NAME" VARCHAR2(25 BYTE),
			"EMAIL" VARCHAR2(25 BYTE),
			"PHONE_NUMBER" VARCHAR2(20 BYTE),
			"HIRE_DATE" DATE,
			"JOB_ID" VARCHAR2(10 BYTE),
			"SALARY" NUMBER(8,2),
			"SALARY_COMM" NUMBER GENERATED ALWAYS AS (ROUND(salary*(10/100),2)) VIRTUAL,
			"COMMISSION_PCT" NUMBER(2,2),
			"MANAGER_ID" NUMBER(6,0),
			"DEPARTMENT_ID" NUMBER(4,0)
		   ) ;
		--------------------------------------------------------
		--  DDL for Table TEST11B
		--------------------------------------------------------

		  CREATE TABLE "TEST11B"
		   (	"EMPLOYEE_ID" NUMBER(6,0),
			"FIRST_NAME" VARCHAR2(20 BYTE),
			"LAST_NAME" VARCHAR2(25 BYTE),
			"EMAIL" VARCHAR2(25 BYTE),
			"PHONE_NUMBER" VARCHAR2(20 BYTE),
			"HIRE_DATE" DATE,
			"JOB_ID" VARCHAR2(10 BYTE),
			"SALARY" NUMBER(8,2),
			"SALARY_COMM" NUMBER GENERATED ALWAYS AS (ROUND(salary*(10/100),2)) VIRTUAL,
			"COMMISSION_PCT" NUMBER(2,2),
			"MANAGER_ID" NUMBER(38,0),
			"DEPARTMENT_ID" NUMBER(4,0)
		   ) ;
		--------------------------------------------------------
		--  DDL for Table TEST11C
		--------------------------------------------------------

		  CREATE TABLE "TEST11C"
		   (	"EMPLOYEE_ID" NUMBER(6,0),
			"FIRST_NAME" VARCHAR2(20 BYTE),
			"LAST_NAME" VARCHAR2(25 BYTE),
			"EMAIL" VARCHAR2(25 BYTE),
			"PHONE_NUMBER" VARCHAR2(20 BYTE),
			"HIRE_DATE" DATE,
			"JOB_ID" VARCHAR2(10 BYTE),
			"SALARY" NUMBER(8,2),
			"COMMISSION_PCT" NUMBER(2,2),
			"MANAGER_ID" LONG,
			"DEPARTMENT_ID" NUMBER(4,0)
		   ) ;
		--------------------------------------------------------
		--  DDL for Table TEST11D
		--------------------------------------------------------

		  CREATE TABLE "TEST11D"
		   (	"EMPLOYEE_ID" NUMBER(6,0) NOT NULL,
			"FIRST_NAME" VARCHAR2(20 BYTE),
			"LAST_NAME" VARCHAR2(25 BYTE),
			"EMAIL" VARCHAR2(25 BYTE),
			"PHONE_NUMBER" VARCHAR2(20 BYTE),
			"HIRE_DATE" DATE,
			"JOB_ID" VARCHAR2(10 BYTE),
			"SALARY" FLOAT(126),
			"COMMISSION_PCT" NUMBER(2,2),
			"MANAGER_ID" NUMBER(6,0),
			"DEPARTMENT_ID" NUMBER(4,0)
		   ) ;
--------------------------------------------------------
--  DDL for Table VTEST05
--------------------------------------------------------

  CREATE TABLE "VTEST05"
   (	"ABC" VARCHAR2(20 BYTE),
	"DEF" VARCHAR2(20 BYTE),
	"XXX" VARCHAR2(20 BYTE)
   ) ;
--------------------------------------------------------
--SQL SErver 2005 stage table for the file STAGE_SS2K5_COLMNS.dat
--------------------------------------------------------
CREATE TABLE "S_SS2K5_COLUMNS"
  (
    "DB_NAME_FK"            VARCHAR2(128 CHAR),
    "OBJECT_ID_"            NUMBER(10,0),
    "NAME"                  VARCHAR2(128 CHAR),
    "COLUMN_ID"             NUMBER(10,0),
    "SYSTEM_TYPE_ID"        NUMBER(10,0),
    "USER_TYPE_ID"          NUMBER(10,0),
    "MAX_LENGTH"            NUMBER(10,0),
    "PRECISION"             NUMBER(10,0),
    "SCALE"                 NUMBER(10,0),
    "COLLATION_NAME"        VARCHAR2(128 CHAR),
    "IS_NULLABLE"           NUMBER(10,0),
    "IS_ANSI_PADDED"        NUMBER(10,0),
    "IS_ROWGUIDCOL"         NUMBER(10,0),
    "IS_IDENTITY"           NUMBER(10,0),
    "IS_COMPUTED"           NUMBER(10,0),
    "IS_FILESTREAM"         NUMBER(10,0),
    "IS_REPLICATED"         NUMBER(10,0),
    "IS_NON_SQL_SUBSCRIBED" NUMBER(10,0),
    "IS_MERGE_PUBLISHED"    NUMBER(10,0),
    "IS_DTS_REPLICATED"     NUMBER(10,0),
    "IS_XML_DOCUMENT"       NUMBER(10,0),
    "XML_COLLECTION_ID"     NUMBER(10,0),
    "DEFAULT_OBJECT_ID"     NUMBER(10,0),
    "RULE_OBJECT_ID"        NUMBER(10,0),
    "IS_SPARSE"             NUMBER(10,0),
    "IS_COLUMN_SET"         NUMBER(10,0)
  ) ;

--------------------------------------------------------
--Sybase stage table for the file SYB15_SYSCOLUMNS.data
--------------------------------------------------------
  CREATE TABLE S_SYB15_SYSCOLUMNS
(
    ID          NUMBER(10),
	DB_NUMBER   NUMBER(10),
	COLID       NUMBER(10),
	STATUS      NUMBER(10),
	DB_TYPE     NUMBER(10),
	LENGTH      NUMBER(10),
	OFFSET      NUMBER(10),
	USERTYPE    NUMBER(10),
	CDEFAULT    NUMBER(10),
	DOMAIN      NUMBER(10),
	NAME        VARCHAR2(255),
	PRINTFMT    VARCHAR2(255),
	PREC        NUMBER(10),
	SCALE       NUMBER(10),
	REMOTE_TYPE NUMBER(10),
	REMOTE_NAME VARCHAR2(255),
	XSTATUS     NUMBER(10),
	XTYPE       NUMBER(10),
	XDBID       NUMBER(10),
	ACESSRULE   NUMBER(10),
	STATUS2     NUMBER(10),
  STATUS3     NUMBER(10),
	COMPUTEDCOL NUMBER(10),
	ENCRTYPE    NUMBER(10),
	ENCRLEN     NUMBER(10),
	ENCRKEYID   NUMBER(10),
	ENCRKEYDB   VARCHAR2(100),
	ENCRDATE    VARCHAR2(100),
	LOBCOMP_LVL NUMBER,
	INROWLEN    NUMBER
);
