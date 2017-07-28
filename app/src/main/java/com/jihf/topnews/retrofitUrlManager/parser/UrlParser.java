package com.jihf.topnews.retrofitUrlManager.parser;

import com.jihf.topnews.retrofitUrlManager.RetrofitUrlManager;
import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * Func：Url解析器
 * Desc:
 * Author：JHF
 * Data：2017-07-28 09:51
 * Mail：jihaifeng@raiyi.com
 */

public interface UrlParser {
  /**
   * 将 {@link RetrofitUrlManager#mDomainNameHub} 中映射的 Url 解析成完整的{@link HttpUrl}
   * 用来替换 @{@link Request#url} 达到动态切换 Url
   *
   * @param domainUrl
   * @return
   */
  HttpUrl parseUrl(HttpUrl domainUrl, HttpUrl url);
}
