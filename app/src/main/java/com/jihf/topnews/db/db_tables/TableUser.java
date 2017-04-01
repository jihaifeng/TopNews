package com.jihf.topnews.db.db_tables;

import android.database.sqlite.SQLiteDatabase;
import com.jihf.topnews.db.db_set.BaseTable;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-01 11:46
 * Mail：jihaifeng@raiyi.com
 */
public class TableUser extends BaseTable {
  public static final String TABLE_NAME = "user";

  @Override public void createTable(SQLiteDatabase db) {
    String sqlCreate =
        "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME,USERPHONE);";
    db.execSQL(sqlCreate);
  }

  @Override public void dropTable(SQLiteDatabase db) {
    String sqlDrop = "DROP TABLE IF EXISTS" + TABLE_NAME;
    db.execSQL(sqlDrop);
  }
}
