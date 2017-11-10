package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * 自动加载:applicationContext.xml
 * Spring框架下的单元测试方法
 * 需要spring-test.jar 引入如下依赖
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class Spring_auto_applicationContext
{

    @Autowired
    private DataSource dataSource_act;

    public void setDataSource_act(DataSource dataSource_act)
    {
        this.dataSource_act = dataSource_act;
    }

    @Test
    public void getListTest(){
        System.out.println("dataSource_act = " + dataSource_act);
    }
}

