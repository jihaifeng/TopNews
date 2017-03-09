package com.jihf.topnews.webview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import butterknife.BindView;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.base.BaseSimpleActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-09 09:29
 * Mail：jihaifeng@raiyi.com
 */
public class WebSiteActivity extends BaseSimpleActivity {

  private Bundle bundle;
  private String title;
  private String url;
  public static final String WEB_TITLE = "webSiteTitle";
  public static final String WEB_URL = "webSiteURL";

  @BindView (R.id.webview) WebView webview;

  @Override protected int getLayoutId() {
    return R.layout.activity_website;
  }

  @Override protected void initViewAndEvent() {
    bundle = getDataFromExtra();
    LogUtils.i(TAG, "bundle：" + bundle);
    if (null != bundle) {
      title = bundle.getString(WEB_TITLE);
      url = bundle.getString(WEB_URL);
      if (!TextUtils.isEmpty(url)) {
        webview.loadUrl(url);
      }
    }
  }

  public static void launch(Context context, String title, String url) {
    if (context == null || title == null || TextUtils.isEmpty(url)) {
      return;
    }
    Intent intent = new Intent(context, WebSiteActivity.class);
    Bundle bd = new Bundle();
    bd.putString(WEB_TITLE, title);
    bd.putString(WEB_URL, url);
    intent.putExtras(bd);
    try {
      context.startActivity(intent);
    } catch (Exception e) {
      // android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity context
      // requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
      if (e.getMessage().contains("AndroidRuntimeException")) {
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
      }
      e.printStackTrace();
    }
  }

  public Bundle getDataFromExtra() {
    return null == getIntent().getExtras() ? null : getIntent().getExtras();
  }
}
