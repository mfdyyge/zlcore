package com.zl.log;

import com.zl.jdbc.DataSource.DsFactory;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;
import org.apache.log4j.jdbc.JDBCAppender;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 钢背猪☣ on 2017-8-31 0031.
 *
 * @ClassName: com.zl.log
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


