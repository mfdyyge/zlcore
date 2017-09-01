package page;

import com.zl.core.jdbc.apche.dbutils.domain.Jpa_persons;
import com.zl.core.jdbc.apche.dbutils.page.Page;
import com.zl.core.jdbc.apche.dbutils.page.QueryRemote;
import org.junit.Test;

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

    @Test
    public void page_test()
    {

        Page page = new Page();
        page.setPageNum(1);
        page.setPageSize(4);
        Object[] params = new Object[]{1} ;

        System.out.println("page.getPageEnd() = " + page.getPageEnd());
        System.out.println("page.getPageBegin() = " + page.getPageBegin());

        List<Jpa_persons> offerTypes = new ArrayList<Jpa_persons>();
        String sql = "select * from jpa_persons where id > ?";
        List<Object> list = QueryRemote.query(sql, page, params, Jpa_persons.class);


        for (int i = 0; i < list.size(); i++)
        {
            Jpa_persons jpa_persons = new Jpa_persons();
            jpa_persons = (Jpa_persons) list.get(i);

            System.out.println(" | "+jpa_persons.getId()+" | "+jpa_persons.getAdd_id()+" | "+jpa_persons.getEmail()+" | "+jpa_persons.getLast_name());
        }

        System.out.println();
        System.out.println("共"+page.getTotalSize()+"条记录，每页大小"+page.getPageSize()+"，当前第"+page.getPageNum()+"页，查询到 "+list.size()+" 条记录。。。");

    }
}
