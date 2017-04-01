package com.jihf.topnews.db.db_tables;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.jihf.topnews.db.db_set.BaseTable;
import com.orhanobut.logger.Logger;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-01 14:18
 * Mail：jihaifeng@raiyi.com
 */
public class TableJsonData extends BaseTable {
  public static final String TAG = TableJsonData.class.getSimpleName();
  public static final String TABLE_NAME = "json_data";

  @Override public void createTable(SQLiteDatabase db) {
    String sqlCrate = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,KEY,VAL);";
    Logger.t(TAG).i("db");
    try {
      db.execSQL(sqlCrate);
    } catch (SQLException e) {
      Logger.t(TAG).i(e.getMessage());
      e.printStackTrace();
    }
  }

  @Override public void dropTable(SQLiteDatabase db) {
    String sqlDrop = "DROP TABLE IF EXISTS" + TABLE_NAME;
    db.execSQL(sqlDrop);
  }
}
