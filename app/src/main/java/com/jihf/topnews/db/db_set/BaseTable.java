package com.jihf.topnews.db.db_set;

import android.database.sqlite.SQLiteDatabase;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-01 11:50
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseTable {

  public abstract void createTable(SQLiteDatabase db);

  public abstract void dropTable(SQLiteDatabase db);
}
