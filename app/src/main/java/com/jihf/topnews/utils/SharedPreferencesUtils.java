package com.jihf.topnews.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.jihf.topnews.app.App;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-28 10:03
 * Mail：jihaifeng@raiyi.com
 */
public class SharedPreferencesUtils {
  private static SharedPreferences preferences;
  private static SharedPreferences.Editor editor;
  private static final String sp_key = "spKey";
  private static SharedPreferencesUtils instance;

  public static SharedPreferencesUtils getInstance() {
    if (null == instance) {
      synchronized (SharedPreferencesUtils.class) {
        if (null == instance) {
          instance = new SharedPreferencesUtils();
        }
      }
    }
    init();
    return instance;
  }

  private static void init() {
    if (null == preferences || null == editor) {
      preferences = App.getInstance().getSharedPreferences(sp_key, Context.MODE_PRIVATE);
      editor = preferences.edit();
    }
  }

  //public void save(String key, String val) {
  //  checkNull();
  //  if (TextUtils.isEmpty(key)) {
  //    throw new NullPointerException("key is empty");
  //  }
  //  editor.putString(key, val);
  //}
  //
  //public void save(String key, int val) {
  //  checkNull();
  //  if (TextUtils.isEmpty(key)) {
  //    throw new NullPointerException("key is empty");
  //  }
  //  editor.putInt(key, val);
  //}
  //
  //public void save(String key, boolean val) {
  //  checkNull();
  //  if (TextUtils.isEmpty(key)) {
  //    throw new NullPointerException("key is empty");
  //  }
  //  editor.putBoolean(key, val);
  //}
  //
  //public void save(String key, float val) {
  //  checkNull();
  //  if (TextUtils.isEmpty(key)) {
  //    throw new NullPointerException("key is empty");
  //  }
  //  editor.putFloat(key, val);
  //}
  //
  //public void save(String key, Long val) {
  //  checkNull();
  //  if (TextUtils.isEmpty(key)) {
  //    throw new NullPointerException("key is empty");
  //  }
  //  editor.putLong(key, val);
  //}

  public void save(String key, Object val) {
    checkNull();
    if (TextUtils.isEmpty(key)) {
      throw new NullPointerException("key is empty");
    }
    if (val instanceof String) {
      editor.putString(key, (String) val);
    } else if (val instanceof Integer) {
      editor.putInt(key, (Integer) val);
    } else if (val instanceof Boolean) {
      editor.putBoolean(key, (Boolean) val);
    } else if (val instanceof Float) {
      editor.putFloat(key, (Float) val);
    } else if (val instanceof Long) {
      editor.putLong(key, (Long) val);
    }
  }

  public String getString(String key) {
    checkNull();
    return preferences.getString(key, "");
  }

  public int getInt(String key) {
    checkNull();
    return preferences.getInt(key, 0);
  }

  public boolean getBoolean(String key) {
    checkNull();
    return preferences.getBoolean(key, false);
  }

  public float getFloat(String key) {
    checkNull();
    return preferences.getFloat(key, 0);
  }

  public long getLong(String key) {
    checkNull();
    return preferences.getLong(key, 0);
  }

  private void checkNull() {
    if (null == preferences || null == editor) {
      init();
    }
  }
}
