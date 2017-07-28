package com.jihf.topnews.retrofitUrlManager.exception;

/**
 * Func：
 * Desc:
 * Author：JHF
 * Data：2017-07-28 09:55
 * Mail：jihaifeng@raiyi.com
 */

public class InvalidListenerException extends RuntimeException {
  public InvalidListenerException(Object obj) {
    super(obj == null ? " your listener is empty."
        : "You should make your listener：" + obj + "   implement " + "onUrlHChangeListener");
  }
}
