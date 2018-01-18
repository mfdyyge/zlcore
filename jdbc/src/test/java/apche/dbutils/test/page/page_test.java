package apche.dbutils.test.page;

import com.zl.core.jdbc.apche.dbutils.page.Page;
import com.zl.core.jdbc.utilSqlGenerator;
import org.apache.log4j.Logger;
import org.junit.Test;
import apche.dbutils.test.pojo.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 钢背猪☣ on 2017-8-14 0014.
 *
 * @ClassName: page_test
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-14 0014
 */
public class page_test
{
    protected static Logger logger = Logger.getLogger(page_test.class);

    @Test
    public void page_test()
    {

        Page page = new Page();
        page.setPageNum(1);
        page.setPageSize(4);
        Object[] params = new Object[]{1} ;

        System.out.println("apche.dbutils.test.page.getPageEnd() = " + page.getPageEnd());
        System.out.println("apche.dbutils.test.page.getPageBegin() = " + page.getPageBegin());

        List<Product> offerTypes = new ArrayList<Product>();
        String sql = "select * from Product where id > ?";
        List<Object> list = utilSqlGenerator.queryPage_oracle(sql, page, params, Product.class);


        for (int i = 0; i < list.size(); i++)
        {
            Product pojo = new Product();
            pojo = (Product) list.get(i);

            logger.info(" | "+pojo.getId()+" | "+pojo.getCreatedDate());
        }

        System.out.println();
        System.out.println("共"+page.getTotalSize()+"条记录，每页大小"+page.getPageSize()+"，当前第"+page.getPageNum()+"页，查询到 "+list.size()+" 条记录。。。");

    }
}
