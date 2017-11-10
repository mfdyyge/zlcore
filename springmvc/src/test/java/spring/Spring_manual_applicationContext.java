package spring;

import com.zl.core.jdbc.DataSource.DsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * 手动加载spring的配置文件，并启动spring容器
* */
public class Spring_manual_applicationContext
{
    @Test
    public void  spring_context() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();

        DataSource dataSource_act = (DataSource) context.getBean("ds_druid_act");
        DataSource dataSource_hikcricp= (DataSource) context.getBean("dataSourceHikari");
        //System.out.println(dataSource_act);
        System.out.println(dataSource_hikcricp.getConnection().isClosed());

    }

}

