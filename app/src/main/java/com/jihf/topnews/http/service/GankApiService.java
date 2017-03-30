package com.jihf.topnews.http.service;

import com.jihf.topnews.model.gank.GankBaseBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-27 17:13
 * Mail：jihaifeng@raiyi.com
 */
public interface GankApiService {

  int NUM = 20;

  //  数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
  //  请求个数： 数字，大于0
  //  第几页：数字，大于0
  //  http://gank.io/api/data/Android/10/1
  // 当前接入 Android | iOS | 拓展资源 | 前端
  @GET ("data/{type}/{num}/{page}") Observable<GankBaseBean> getGankData(@Path ("type") String type,
      @Path ("num") int Num, @Path ("page") int page);
}
