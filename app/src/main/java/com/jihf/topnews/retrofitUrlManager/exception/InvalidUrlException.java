package com.jihf.topnews.retrofitUrlManager.exception;

import android.text.TextUtils;

/**
 * Func：
 * Desc:
 * Author：JHF
 * Data：2017-07-28 09:55
 * Mail：jihaifeng@raiyi.com
 */

public class InvalidUrlException extends RuntimeException {
  public InvalidUrlException(String url) {
    super("You've configured an invalid url : " + (TextUtils.isEmpty(url) ? "EMPTY_OR_NULL_URL" : url));
  }
}
