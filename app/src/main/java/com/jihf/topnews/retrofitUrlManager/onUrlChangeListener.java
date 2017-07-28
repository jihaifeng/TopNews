package com.jihf.topnews.retrofitUrlManager;

import okhttp3.HttpUrl;

/**
 * Func：
 * Desc:
 * Author：JHF
 * Data：2017-07-28 09:49
 * Mail：jihaifeng@raiyi.com
 */

public interface onUrlChangeListener {
  /**
   * 当 Url 的 BaseUrl 被改变时回调
   * 调用时间是在接口请求服务器之前
   *
   * @param newUrl
   * @param oldUrl
   */
  void onUrlChange(HttpUrl newUrl, HttpUrl oldUrl);
}
