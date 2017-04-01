package com.jihf.topnews.db.db_manager;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.jihf.topnews.db.db_set.BaseTable;
import com.jihf.topnews.db.db_tables.TableJsonData;
import com.jihf.topnews.db.db_tables.TableUser;
import java.util.ArrayList;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-01 11:39
 * Mail：jihaifeng@raiyi.com
 */
public class TableManager {
  public static final String TAG = TableManager.class.getSimpleName().trim();
  private static TableManager instance;
  private List<Class<? extends BaseTable>> baseTables;

  public static TableManager getInstance() {
    if (null == instance) {
      synchronized (TableManager.class) {
        if (null == instance) {
          instance = new TableManager();
        }
      }
    }
    return instance;
  }

  /**
   * 新增数据表的时候，add进baseTables
   */
  public TableManager() {
    if (null == baseTables) {
      baseTables = new ArrayList<>();
    }
    if (!baseTables.contains(TableUser.class)) {
      baseTables.add(TableUser.class);
    }
    if (!baseTables.contains(TableJsonData.class)) {
      baseTables.add(TableJsonData.class);
    }
  }

  @TargetApi (Build.VERSION_CODES.KITKAT) public void createTables(SQLiteDatabase db) {
    for (Class<? extends BaseTable> table : baseTables) {
      try {
        BaseTable tb = table.newInstance();
        tb.createTable(db);
      } catch (InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }

  @TargetApi (Build.VERSION_CODES.KITKAT) void dropTables(SQLiteDatabase db) {
    for (Class<? extends BaseTable> table : baseTables) {
      try {
        BaseTable tb = table.newInstance();
        tb.dropTable(db);
      } catch (InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }
}
