package utils;

import com.zl.core.jdbc.Oracle;
import org.junit.Test;

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
    public void Oracle_getTable()
    {
        //Oracle.getDataBaseInfo();
        Oracle oracle=new Oracle();

       // List<Table> tables = oracle.getTables();
        //oracle.getTables();
        //oracle.getTable("act","");
        oracle.getTable("zy");
/*
        List<String> tableToSelect = new ArrayList<String>();

                for (Table table : tables)
                {
                    //tableToSelect.add(table.getTableName());
                    System.out.println("table = " + table.toString());
                }*/
    }
}
