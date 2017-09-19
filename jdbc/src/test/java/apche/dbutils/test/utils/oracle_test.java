package apche.dbutils.test.utils;

import com.zl.core.jdbc.generator.Oracle;
import com.zl.core.jdbc.generator.Table;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by 钢背猪☣ on 2017-8-24 0024.
 *
 * @ClassName: apche.dbutils.test.utils
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-24 0024
 */
public class oracle_test
{
    protected static Logger logger = Logger.getLogger(oracle_test.class);

    @Test
    public void Oracle_getTable()
    {
        //Oracle.getDataBaseInfo();
        Oracle oracle=new Oracle("dbjpa");

       // List<Table> tables = oracle.getTables();
        //oracle.getTables();
        //oracle.getTable("act","");
        Table table=oracle.getTable("zy");
        logger.info(table);
/*
        List<String> tableToSelect = new ArrayList<String>();

                for (Table table : tables)
                {
                    //tableToSelect.add(table.getTableName());
                    System.out.println("table = " + table.toString());
                }*/
    }
}
