package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;


/**
 * 手动加载spring的配置文件，并启动spring容器
* */
public class Spring_manual_applicationContext
{
    @Test
    public void  spring_context()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();

        DataSource dataSource_act = (DataSource) context.getBean("dataSource_act");
        System.out.println(dataSource_act);
    }

}

