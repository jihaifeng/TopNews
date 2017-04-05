package com.jihf.topnews.db.db_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.jihf.topnews.db.db_module.JsonModule;
import com.jihf.topnews.db.db_set.DbHelper;
import com.jihf.topnews.db.db_set.QuerySqlBuilder;
import com.jihf.topnews.db.db_tables.TableJsonData;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-01 11:36
 * Mail：jihaifeng@raiyi.com
 */
public class DbManager {
  public static final String TAG = DbManager.class.getSimpleName().trim();
  private static DbManager instance;
  private static String DB_NAME = "app.db";
  private static int DB_VERSION = 1;

  private static BriteDatabase db;

  private static QuerySqlBuilder build;
  public static final String key_json_news = "json_news";

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

  private static void init(Context context) {
    build = new QuerySqlBuilder();
    SqlBrite sqlBrite = new SqlBrite.Builder().build();
    DbHelper dbHelper = new DbHelper(context, DB_NAME, null, DB_VERSION);
    db = sqlBrite.wrapDatabaseHelper(dbHelper, AndroidSchedulers.mainThread());
  }

  public Observable<List<String>> getJsonStr(String key) {
    String sql = build.setTableName(TableJsonData.TABLE_NAME).appendCondition("KEY = ?").build();
    Observable<List<String>> observable =
        db.createQuery(TableJsonData.TABLE_NAME, sql, key).mapToList(new Func1<Cursor, String>() {
          @Override public String call(Cursor cursor) {
            JsonModule jsonModule = new JsonModule();
            jsonModule.json_key = cursor.getString(cursor.getColumnIndexOrThrow("KEY"));
            jsonModule.json_str = cursor.getString(cursor.getColumnIndexOrThrow("VAL"));
            return cursor.getString(cursor.getColumnIndexOrThrow("VAL"));
          }
        });
    return observable;
  }

  public void insertJsonStr(String key, String json) {
    ContentValues values = new ContentValues();
    values.put("KEY", key);
    values.put("VAL", json);
    db.insert(TableJsonData.TABLE_NAME, values);
  }

  public void insertNewsJson(String json) {
    if (TextUtils.isEmpty(json)) {
      throw new NullPointerException("json data is null");
    }
    insertJsonStr(key_json_news, json);
  }
}
