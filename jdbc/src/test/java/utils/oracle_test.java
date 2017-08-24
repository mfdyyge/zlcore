package utils;

import com.zl.jdbc.util.Oracle;
import com.zl.jdbc.vo.Table;
import org.junit.Test;

import java.util.List;

/**
 * Created by 钢背猪☣ on 2017-8-24 0024.
 *
 * @ClassName: utils
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-24 0024
 */
public class oracle_test
{
    @Test
    public void tearDown() throws Exception
    {
        //Oracle.getDataBaseInfo();
        Oracle oracle=new Oracle();

        List<Table> tables = oracle.getTables();
/*
        List<String> tableToSelect = new ArrayList<String>();

                for (Table table : tables)
                {
                    //tableToSelect.add(table.getTableName());
                    System.out.println("table = " + table.toString());
                }*/
    }
}
