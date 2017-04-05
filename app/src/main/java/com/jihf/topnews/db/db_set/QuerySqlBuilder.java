package com.jihf.topnews.db.db_set;

import android.text.TextUtils;
import com.jihf.androidutils.tools.LogUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-05 11:35
 * Mail：jihaifeng@raiyi.com
 */
public class QuerySqlBuilder {

  public static final String TAG = QuerySqlBuilder.class.getSimpleName().trim();

  private final String select = "SELECT ";
  private final String from = " FROM ";
  private final String where = " WHERE ";
  private final String and = " AND ";
  private final String or = " OR ";
  private final String order = " ORDER BY";
  private final String desc = " DESC ";
  private final String limit = " LIMIT ";

  private String selectItem;
  private String table;
  private List<String> conditions = new ArrayList<>();
  private List<String> orConditions = new ArrayList<>();
  private String orderItems;
  private boolean isDesc = false;
  private String limitStr;

  public QuerySqlBuilder setTableName(String table) {
    this.table = table;
    return this;
  }

  public QuerySqlBuilder setSelect(String select) {
    this.selectItem = select;
    return this;
  }

  public QuerySqlBuilder appendCondition(String condition) {
    conditions.add(condition);
    return this;
  }

  public QuerySqlBuilder appendOrCondition(String condition) {
    orConditions.add(condition);
    return this;
  }

  public QuerySqlBuilder setOrder(String order) {
    this.orderItems = order;
    return this;
  }

  public QuerySqlBuilder setDesc() {
    this.isDesc = true;
    return this;
  }

  public void setLimit(String limit) {
    this.limitStr = limit;
  }

  public String build() {
    StringBuffer sqlBuffer = new StringBuffer();
    if (TextUtils.isEmpty(table)) {
      return "";
    }
    sqlBuffer.append(select);
    if (TextUtils.isEmpty(selectItem)) {
      sqlBuffer.append("*");
    } else {
      sqlBuffer.append(selectItem);
    }
    sqlBuffer.append(from).append("'").append(table).append("'");
    if (!conditions.isEmpty()) {
      sqlBuffer.append(where);
      for (int i = 0; i < conditions.size(); i++) {
        if (i == 0) {
          sqlBuffer.append(conditions.get(i));
        } else {
          sqlBuffer.append(and).append(conditions.get(i));
        }
      }

      for (String condition : orConditions) {
        sqlBuffer.append(or).append(condition);
      }
    }

    if (!TextUtils.isEmpty(limitStr)) {
      sqlBuffer.append(limit).append(limitStr);
    }

    if (isDesc) {
      sqlBuffer.append(order);
      if (!TextUtils.isEmpty(orderItems)) {
        sqlBuffer.append(orderItems);
      }
      sqlBuffer.append(desc);
    }
    LogUtils.i(TAG, "sql：" + sqlBuffer.toString());
    return sqlBuffer.toString();
  }
}
