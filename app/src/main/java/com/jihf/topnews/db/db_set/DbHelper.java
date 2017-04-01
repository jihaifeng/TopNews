package com.jihf.topnews.db.db_set;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.jihf.topnews.db.db_manager.TableManager;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-01 11:17
 * Mail：jihaifeng@raiyi.com
 */
public class DbHelper extends SQLiteOpenHelper {
  public static final String TAG = DbHelper.class.getSimpleName().trim();

  public DbHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int dbVersion) {
    super(context, dbName, factory, dbVersion);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    TableManager.getInstance().createTables(db);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }
}
