package com.jihf.topnews.http;

/**
 * Func：类似数据结构的 数据请求结果包装类
 * Desc:
 * Author：jihf
 * Data：2017-02-08 11:43
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
