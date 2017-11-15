package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;


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
    private DataSource ds_Hikari,ds_druid_act;

    public void setDs_Hikari(DataSource ds_Hikari) {
        this.ds_Hikari = ds_Hikari;

      }

    public void setDs_druid_act(DataSource ds_druid_act) {
        this.ds_druid_act = ds_druid_act;

    }

    @Test
    public void getListTest() throws SQLException {
        System.out.println("ds_Hikari = " + ds_Hikari.getConnection());
    }
}

