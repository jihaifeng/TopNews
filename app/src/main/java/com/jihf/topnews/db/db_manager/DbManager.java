package com.jihf.topnews.db.db_manager;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.jihf.topnews.db.db_set.DbHelper;
import com.jihf.topnews.db.db_tables.TableJsonData;
import com.jihf.topnews.db.db_tables.TableUser;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-01 11:36
 * Mail：jihaifeng@raiyi.com
 */
public class DbManager {
  private static DbManager instance;
  private static String DB_NAME = "app.db";
  private static int DB_VERSION = 1;

  private static BriteDatabase db;

  public static DbManager getInstance(Context context) {
    if (null == instance) {
      synchronized (DbManager.class) {
        if (null == instance) {
          instance = new DbManager();
        }
      }
    }
    init(context);
    return instance;
  }

  public static DbManager getInstance(Context context, String dbName, int dbVersion) {
    if (null == instance) {
      synchronized (DbManager.class) {
        if (null == instance) {
          instance = new DbManager();
        }
      }
    }
    setDbName(dbName);
    setVersion(dbVersion);
    init(context);
    return instance;
  }

  private static void setDbName(String dbName) {
    if (!TextUtils.isEmpty(dbName)) {
      String DB_NAME_END = ".db";
      DB_NAME = dbName.endsWith(DB_NAME_END) ? dbName : dbName + DB_NAME_END;
    }
  }

  private static void setVersion(int version) {
    DB_VERSION = version;
  }

  public static void init(Context context) {
    SqlBrite sqlBrite = new SqlBrite.Builder().build();
    DbHelper dbHelper = new DbHelper(context, DB_NAME, null, DB_VERSION);
    db = sqlBrite.wrapDatabaseHelper(dbHelper, AndroidSchedulers.mainThread());
  }

  public void insertUser(ContentValues values) {
    db.insert(TableUser.TABLE_NAME, values);
  }

  public void insertJson(String key, String json) {
    ContentValues values = new ContentValues();
    values.put("KEY", key);
    values.put("VAL", json);
    db.insert(TableJsonData.TABLE_NAME, values);
  }
}
