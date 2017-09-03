
create table product (
  id number(11) primary key,
  name varchar2(32 char),
  stocc number(11),
  created_date date,
  status  varchar2(4 char)
);

 -- COMMENT 'ID'
--COMMENT '商品名称'
--COMMENT '商品库存'
--COMMENT '创建时间'
-- COMMENT '上架状态'