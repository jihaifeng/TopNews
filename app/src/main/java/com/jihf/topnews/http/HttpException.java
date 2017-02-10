package com.jihf.topnews.http;

/**
 * Func：异常处理与抛出
 * Desc:
 * Author：jihf
 * Data：2017-02-08 11:50
 * Mail：jihaifeng@raiyi.com
 */
public class HttpException extends RuntimeException {
  public static final int ERROR_KEY = 10001;
  public static final int RESULT_OK = 0;

  public HttpException(String message) {
    super(message);
  }

  public HttpException(int errorCode) {
    this(getErrorMsg(errorCode));
  }

  private static String getErrorMsg(int errorCode) {
    String msg = "数据异常";
    switch (errorCode) {
      case ERROR_KEY:
        msg = "key值异常";
        break;
      case RESULT_OK:
        msg = "请求成功";
        break;
    }
    return msg;
  }
}
