package com.jihf.topnews.retrofitUrlManager;

import com.jihf.topnews.retrofitUrlManager.exception.InvalidUrlException;
import okhttp3.HttpUrl;

/**
 * Func：
 * Desc:
 * Author：JHF
 * Data：2017-07-28 09:55
 * Mail：jihaifeng@raiyi.com
 */

public class UrlUtils {
  private UrlUtils() {
    throw new IllegalStateException("do not instantiation me");
  }

  static HttpUrl checkUrl(String url) {
    HttpUrl parseUrl = HttpUrl.parse(url);
    if (null == parseUrl) {
      throw new InvalidUrlException(url);
    } else {
      return parseUrl;
    }
  }
}
