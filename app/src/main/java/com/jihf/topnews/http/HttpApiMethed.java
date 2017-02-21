package com.jihf.topnews.http;

import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.constants.UrlConstants;
import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxHelper;
import com.jihf.topnews.rx.RxSchedulersHelper;
import rx.Subscriber;
import rx.Subscription;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-17 16:00
 * Mail：jihaifeng@raiyi.com
 */
public class HttpApiMethed {
  private static JuheApiService juheApiService;

  public static JuheApiService getJuheApiService() {
    juheApiService = RxHelper.getInstance().getApiService(UrlConstants.URL_TOP_NEWS, JuheApiService.class);
    return juheApiService;
  }

  public static Subscription getTopNews(RxBaseView rxBaseView, Subscriber<ResultBean> subscriber) {
    return HttpApiMethed.getJuheApiService()
        //获取新闻头条数据
        .getTopNews(JuHeConstants.KEY_NEWS, JuHeConstants.TYPE_TOP)
        // 线程指定
        .compose(RxSchedulersHelper.io_main())
        // 生命周期绑定
        .compose(rxBaseView.bindToLifecycle())
        // 数据预处理
        .map(new HttpResultFuc<>())
        //
        .subscribe(subscriber);
  }
}
