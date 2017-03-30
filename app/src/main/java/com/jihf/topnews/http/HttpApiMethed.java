package com.jihf.topnews.http;

import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.constants.UrlConstants;
import com.jihf.topnews.http.service.GankApiService;
import com.jihf.topnews.http.service.JuheApiService;
import com.jihf.topnews.model.gank.GankBaseBean;
import com.jihf.topnews.model.news.JuheResultBean;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxHelper;
import com.jihf.topnews.rx.RxSchedulersHelper;
import rx.Observable;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-17 16:00
 * Mail：jihaifeng@raiyi.com
 */
public class HttpApiMethed {
  private static JuheApiService juheApiService;
  private static GankApiService gankApiService;
  private static RxHelper rxHelper;

  public static void init() {
    rxHelper = RxHelper.getInstance();
    juheApiService = rxHelper.getApiService(UrlConstants.URL_JUHE, JuheApiService.class);
    gankApiService = rxHelper.getApiService(UrlConstants.URL_GANK, GankApiService.class);
  }

  public static Observable<JuheResultBean> getTopNews(String key, RxBaseView rxBaseView) {
    return juheApiService
        //获取新闻头条数据
        .getTopNews(JuHeConstants.KEY_NEWS, key)
        // 线程指定
        .compose(RxSchedulersHelper.io_main())
        // 生命周期绑定
        .compose(rxBaseView.bindToLifecycle())
        // 数据预处理
        .map(response -> {
          if (response.error_code != 0) {
            //数据返回错误
            throw new HttpException(response.error_code);
          }
          return response.result;
        });
  }

  public static Observable<GankBaseBean> getGankData(String type, int page, RxBaseView rxBaseView) {
    return gankApiService.getGankData(type, GankApiService.NUM, page)
        .compose(RxSchedulersHelper.io_main())
        .compose(rxBaseView.bindToLifecycle())
        .map(gankBaseBean -> {
          if (null == gankBaseBean || gankBaseBean.error || null == gankBaseBean.results) {
            //数据返回错误
            throw new HttpException("数据返回错误");
          }
          return gankBaseBean;
        });
  }
}
