package com.jihf.topnews.http;

import com.jihf.topnews.constants.UrlConstants;
import com.jihf.topnews.rx.RxHelper;

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
}
