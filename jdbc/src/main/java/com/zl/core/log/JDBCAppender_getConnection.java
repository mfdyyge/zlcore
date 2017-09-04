package com.zl.core.log;

import com.zl.core.jdbc.DataSource.DsFactory;
import org.apache.log4j.jdbc.JDBCAppender;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 钢背猪☣ on 2017-8-31 0031.
 * 注意:这里需要引入[com.zl.zlcore.orcl]
 * 编译错误的时候:先注释这个类,在编译JDBC
 * @ClassName: com.zl.core.log
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-31 0031
 */
public class JDBCAppender_getConnection extends JDBCAppender
{

    @Override
    protected Connection getConnection() throws SQLException
    {
        Connection connection=new DsFactory("dblog").getConnection();

        return connection;

    }

}


