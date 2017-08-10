package queryrunner;

import com.zl.jdbc.DataSource.DsFactory;
import com.zl.jdbc.apche.dbutils.dao.QueryRunnerDao;
import com.zl.jdbc.page.OfferType;
import com.zl.jdbc.page.Page;
import com.zl.jdbc.page.QueryRemote;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 钢背猪☣ on 2017-8-7 0007.
 *
 * @ClassName: queryrunner
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-7 0007
 */
public class Test_DataSourceFactory
{
    @Test
    public void test_Dao()
    {

        String sql = "select * from jpa_persons where id like ? ";
        Object [] params = new Object[]{"%4%"};


        //System.out.println("getDataSource = " + DsFactory.getDataSource());
        Connection connection= DsFactory.getConnection();
        System.out.println("getConnection = " + connection);

        Object result[]=QueryRunnerDao.getFirstRowArray(connection,sql,params);
        System.out.println(Arrays.asList(result));

    }

    @Test
    public void page_test(){

            Page page = new Page();
            page.setPageNum(1);
            page.setPageSize(4);
            Object[] params = new Object[]{1} ;

            List<OfferType> offerTypes = new ArrayList<OfferType>();
            String sql = "select * from offer_type where offer_type > ?";
            List<Object> list = QueryRemote.query(sql, page, params, OfferType.class);

            OfferType offerType = null;
            for (int i = 0; i < list.size(); i++) {
                offerType = new OfferType();
                offerType = (OfferType) list.get(i);
                System.out.println(offerType.toString());
                offerTypes.add(offerType);
            }

            System.out.println();
            System.out.println("共"+page.getTotalSize()+"条记录，每页大小"+page.getPageSize()+"，当前第"+page.getPageNum()+"页，查询到 "+list.size()+" 条记录。。。");

    }
    
    @Test
    public  void  DsFactory()
    {
        System.out.println("DsFactory.getDataSource = " + DsFactory.getDataSource());

        Connection connection=DsFactory.getConnection();

        System.out.println("DsFactory.Connection = " + connection);

        System.out.println("Connection = " + DsFactory.isValid());
        System.out.println("connection = " + DsFactory.isValid(connection));

        System.out.println("connection = " + connection.hashCode());
        System.out.println("DsFactory.getConnection().hashCode() = " + DsFactory.getConnection().hashCode());


        //判断两个Connection 是否相等
        System.out.println("connection =threadLocal.get(Connection) " + connection.equals(DsFactory.getConnection()));
    }
}
