package com.jihf.topnews.view.CustomTabhost;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/**
 * Func：
 * User：jihf
 * Data：2016-08-19
 * Time: 16:36
 * Mail：jihaifeng@raiyi.com
 */
public class DummyTabFactory implements TabHost.TabContentFactory {
  private final Context mContext;

  public DummyTabFactory(Context context) {
    mContext = context;
  }

  @Override public View createTabContent(String tag) {
    View v = new View(mContext);
    v.setMinimumWidth(0);
    v.setMinimumHeight(0);
    return v;
  }
}