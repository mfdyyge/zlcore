package com.zl.core.jdbc.DataSource.spring;


import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName:   Druid_Factory
 * @Description: druid-数据库连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-06-01 下午2:04:36
 */
public class DsFactorySpringAop
{
	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource
	 */
	private DataSource[] dataSource;
	private String[] mappingResources;

	/**
	 * 	<property name="DsFactoryProperties">
	 * 	<props>
	 * 		<prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>
	 * 	</props>
	 * 	</property>
	 */
	private Properties DsFactoryProperties;
	private Class<?>[] annotatedClasses;
	private String[] annotatedPackages;

	/**
	 * <property name="packagesToScan">
	 *     <list>
	 *         <value>ws.pojo</value><value>ws.wthz</value>
	 *     </list>
	 * </property>
	 */
	private String[] packagesToScan;
/*
	private SessionFactory sessionFactory;
*/


/**********************************************************************************************************************/
	public DsFactorySpringAop() {	}

	public void setDataSource(DataSource... dataSource) {
		this.dataSource = dataSource;
	}
	public DataSource[] getDataSource() {		return dataSource;	}

	public String[] getMappingResources() {		return mappingResources;	}
	public void setMappingResources(String[] mappingResources) {		this.mappingResources = mappingResources;	}



	public Properties getDsFactoryProperties()
	{
		if (this.DsFactoryProperties == null) {
			this.DsFactoryProperties = new Properties();
		}

		return this.DsFactoryProperties;
	}

	public void setDsFactoryProperties(Properties dsFactoryProperties) {
		DsFactoryProperties = dsFactoryProperties;
	}


	public void setAnnotatedClasses(Class... annotatedClasses) {
		this.annotatedClasses = annotatedClasses;
	}
	public Class<?>[] getAnnotatedClasses() {		return annotatedClasses;	}


	public void setAnnotatedPackages(String... annotatedPackages) {
		this.annotatedPackages = annotatedPackages;
	}
	public String[] getAnnotatedPackages() {		return annotatedPackages;	}

	public void setPackagesToScan(String... packagesToScan) {
		this.packagesToScan = packagesToScan;
	}
	public String[] getPackagesToScan() {		return packagesToScan;	}

	public boolean isSingleton() {
		return true;
	}
}