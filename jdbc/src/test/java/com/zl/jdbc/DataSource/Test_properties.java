package com.zl.jdbc.DataSource;

import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017-8-2 0002.
 */
public class Test_properties
{
    @Test
    public void testCustomRepositoryMethod() throws SQLException {
        //System.out.println("ConnectionFactory.class.getClassLoader().toString() = " + ConnectionFactory.class.getClassLoader());
        System.out.println("test= " + DataSouceFactory__Druid.getConnection());

    }

    //AdminQueryDao
    @Test
    public void test_AdminDao()
    {
        //AdminQueryDao.queryArray()

    }
}
