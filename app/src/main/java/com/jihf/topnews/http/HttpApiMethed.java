package com.jihf.topnews.http;

import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.constants.UrlConstants;
import com.jihf.topnews.model.news.ResultBean;
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
  private static RxHelper rxHelper;

  public static void init() {
    rxHelper = RxHelper.getInstance();
    juheApiService = rxHelper.getApiService(UrlConstants.URL_TOP_NEWS, JuheApiService.class);
  }

  public static Observable<ResultBean> getTopNews(RxBaseView rxBaseView) {
    return juheApiService
        //获取新闻头条数据
        .getTopNews(JuHeConstants.KEY_NEWS, JuHeConstants.TYPE_TOP)
        // 线程指定
        .compose(RxSchedulersHelper.io_main())
        // 生命周期绑定
        .compose(rxBaseView.bindToLifecycle())
        // 数据预处理
        .map(new HttpResultFuc<>());
  }
}
