package com.jihf.topnews.http;

import com.jihf.topnews.model.BaseResponse;
import com.jihf.topnews.model.news.ResultBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-07 16:41
 * Mail：jihaifeng@raiyi.com
 */
public interface JuheApiService {
  //http://v.juhe.cn/toutiao/index?type=top&key=APPKEY

  @GET ("/toutiao/index") Observable<BaseResponse<ResultBean>> getTopNews(@Query ("key") String key,
      @Query ("type") String type);
}
