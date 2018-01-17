数据库CRUD操作

一、删除表   drop table 表名称

二、修改表

alter   table 表名称 add  列名 数据类型   （add表示添加一列）

alter  table  表名称 drop column 列名称（ column表示列   drop表示删除）

三、删除数据库

drop database 数据库

四、CRUD操作（create 添加数据read读取数据 update 修改数据delete删除数据）

1、添加数据(create)

a:      insert into + nation values（'n002 ','回族 '）--加单引号是转为字符串，英文的

b:    insert into nation values('n003',' ')    只添加一列  后面的是空    给所有的添加可以用

c:    insert into nation(code,) values('n004')  给某一列添加可以用



d:给多列添加     insert into nation(code,name) values('n004','维吾尔族')

e: 专门添加自增长列的    insert into 表名 values('p001','p006')  自增长列不用管，直接写第二列

2、删除数据（delete）

delete from +表名称--删除表中所有内容

delete from +表名称 where ids=5  (删除此行)---where后面跟一个条件



3、修改数据（uodate）

update +表名称 set +列名称=' '      set(设置)---修改所有的内容这一列的

update +表名称 set +列名称='p006 ' where ids=6



update +表名称 set +列名称='p006 ',列名称='p002' where ids=6-----用逗号隔开可以修改多列

整数型（int）的不需要加单引号      0 (false)1(true)

4、查询数据(10种)

a1:简单查询

select * from  表名称   ——查询表中所有数据     *代表所有列

select code,name from 表名称——查询指定列数据

select code,name from 表名称——查指定列的数据

select code as'代号',name as'姓名' from 表名称——给列指定别名

a2:条件查询

select * from 表名 where code=' '   查这一行

select * from 表名 where sex='true' and nation=' '   表示并列，--多条件并的关系

select * from 表名 where sex='true' or nation=' ' --多条件或的关系

a3:范围查询

select * from 表名 where 列名>40 and 列名<50

select * from 表名 where 列名 between 40 and 50  --专用于范围查询

a4:离散查询

select * from 表名 where 列名 in (' ',' ',' ')

select * from 表名 where 列名 not in (' ',' ',' ')  反选，不在里面的

a5:模糊查询

select * from 表名 where 列名 like '%宝马%'——查包含宝马的

select * from 表名 where 列名 like '宝马%'——查以宝马开头的

select * from 表名 where 列名 like '%宝马'——查以宝马结尾的

select * from 表名 where 列名 like '宝马'——查等于宝马的

select * from 表名 where 列名 like '--E'——查第三个是E的

% 代表是任意多个字符

- 下划线 代表是一个字符

a6:排序查询

select * from 表名 order by 列名——默认升序排序

select * from 表名 order by 列名 desc——降序排列

select * from 表名 order by 列名 desc, 列名 asc——多个条件排序   ， 前面是主条件 后面是次要条件

desc 降序  ，asc 升序， order by  排序  根据哪一列排序

a7:分页查询

select top 5 * from 表名——查询前5条数据

select top 5 * from 表名 where code not in (select top 5 code from car)

a8:去重查询（去掉重复的）

select distinct 列名 from

  a9:分组查询

select Brand from 表名 group by Brand having count(*)>2

group by    having ——表示根据一列分组 ，count(*)>2——每一组的数量

a10:聚合函数（统计查询）

select count (*) from 表名——查询所有数据条数（每一列的）

select count (列名主键) from 表名——查询这列的所有数据条数（执行快）

select sum (列名) from 表名——求和

select avg  (列名) from 表名——求平均值

select max (列名) from 表名——求最大值

select min (列名) from 表名——求最小值