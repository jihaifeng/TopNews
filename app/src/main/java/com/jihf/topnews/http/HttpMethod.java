package com.jihf.topnews.http;

import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.constants.UrlConstants;
import com.jihf.topnews.entity.ResultBean;
import com.jihf.topnews.rx.RxHelper;
import com.jihf.topnews.rx.RxSchedulersHelper;
import rx.Observable;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-09 12:28
 * Mail：jihaifeng@raiyi.com
 */
public class HttpMethod {
  // 头条新闻
  public static Observable<HttpResult<ResultBean>> getTopNewsObservable(String type) {
    JuheApiService service = new RxHelper().getApiService(UrlConstants.URL_TOP_NEWS, JuheApiService.class);
    Observable<HttpResult<ResultBean>> observable =
        service.getTopNews(JuHeConstants.KEY_NEWS, type).compose(RxSchedulersHelper.<HttpResult<ResultBean>>io_main());
    return observable;
  }
}
