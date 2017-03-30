package com.jihf.topnews.fastjson;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-29 17:51
 * Mail：jihaifeng@raiyi.com
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
  private final Type type;

  public FastJsonResponseBodyConverter(Type type) {
    this.type = type;
  }

  @Override public T convert(ResponseBody value) throws IOException {
    BufferedSource bufferedSource = Okio.buffer(value.source());
    String tempStr = bufferedSource.readUtf8();
    bufferedSource.close();
    return JSON.parseObject(tempStr, type);
  }
}