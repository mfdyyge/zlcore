create table COMLOG  (
   ID                   VARCHAR2(32)                    not null,
   SEQCODE              VARCHAR2(8)                     not null,
   COMMDATE             VARCHAR2(10),
   COMMTIME             VARCHAR2(10),
   TRANCODE             VARCHAR2(6),
   TYPE                 CHAR(1),
   BITMAP               VARCHAR2(100),
   CONTENT              VARCHAR2(2000),
   MAPCONTENT           VARCHAR2(2000),
   constraint PK_COMLOG primary key (ID)
);

comment on table COMLOG is
'通讯报文日志流水表';

comment on column COMLOG.ID is
'ID';

comment on column COMLOG.SEQCODE is
'流水号';

comment on column COMLOG.COMMDATE is
'通讯日期';

comment on column COMLOG.COMMTIME is
'通讯时间';

comment on column COMLOG.TRANCODE is
'当期交易号';

comment on column COMLOG.TYPE is
'报文类型（R:来帐；S：往帐）';

comment on column COMLOG.BITMAP is
'位元图内容';

comment on column COMLOG.CONTENT is
'报文内容';

comment on column COMLOG.MAPCONTENT is
'MAP内容';