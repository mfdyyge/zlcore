package com.zl.core.jdbc.db;

import java.util.Locale;

// Referenced classes of package com.zl.jdbc.db:
//            Table, Database

public abstract class Schema
{

    public Schema()
    {
    }

    public abstract Database getDatabase();

    public abstract String getName();

    public abstract String getDisplayName(Locale locale);

    public abstract int getTableCount();

    public abstract Table getTable(int i);

    public String getTableName(int index)
    {
        return getTable(index).getName();
    }

    public String getTableDisplayName(int index, Locale locale)
    {
        return getTable(index).getDisplayName(locale);
    }
}
