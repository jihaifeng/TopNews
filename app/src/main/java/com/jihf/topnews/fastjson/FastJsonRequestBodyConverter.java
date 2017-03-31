package com.jihf.topnews.fastjson;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-29 17:52
 * Mail：jihaifeng@raiyi.com
 */
class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

  @Override public RequestBody convert(T value) throws IOException {
    return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value));
  }
}