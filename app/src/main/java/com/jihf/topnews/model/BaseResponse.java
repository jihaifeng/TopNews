package com.jihf.topnews.model;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-28 16:34
 * Mail：jihaifeng@raiyi.com
 */
public class BaseResponse<T> {
  /**
   * reason : 成功的返回
   * result : {...}
   * error_code : 0
   */

  public String reason;
  public T result;
  public int error_code;
}
