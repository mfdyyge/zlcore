#zlcore
根据Apche Commons.Dbutils 封装的一些方法
加入链接池-目前支持四种[ HikariCp |druid |TomcatJdbc |c3p0 ]采用线程安全的Connection,提高并发及稳定性;

import com.zl.jdbc.DataSource.DataSouceFactory;
DataSouceFactory
		DataSouceFactory__HikariCp
		DataSouceFactory__Druid
		DataSouceFactory_TomcatJdbc
		DataSouceFactory_C3p0

