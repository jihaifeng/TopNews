package com.jihf.topnews.http;

import rx.functions.Func1;

/**
 * Func：类似数据预处理
 * Desc:
 * Author：jihf
 * Data：2017-02-08 11:49
 * Mail：jihaifeng@raiyi.com
 */
public class HttpResultFuc<T> implements Func1<com.jihf.topnews.http.BaseResponse<T>, T> {
  @Override public T call(com.jihf.topnews.http.BaseResponse<T> httpResult) {
    if (httpResult.error_code != 0) {
      //数据返回错误
      throw new HttpException(httpResult.error_code);
    }
    return httpResult.result;
  }
}
