package com.jihf.topnews.retrofitUrlManager.parser;

import okhttp3.HttpUrl;

/**
 * Func：
 * Desc:
 * Author：JHF
 * Data：2017-07-28 09:52
 * Mail：jihaifeng@raiyi.com
 */

public class DefaultUrlParser implements UrlParser {
  @Override public HttpUrl parseUrl(HttpUrl domainUrl, HttpUrl url) {
    // 如果 HttpUrl.parse(url); 解析为 null 说明url 格式不正确,正确的格式为 "https://github.com:443"
    // http 默认端口 80,https 默认端口 443 ,如果端口号是默认端口号就可以将 ":443" 去掉
    // 只支持 http 和 https

    if (null == domainUrl) return url;

    return url.newBuilder()
        .scheme(domainUrl.scheme())
        .host(domainUrl.host())
        .port(domainUrl.port())
        .build();
  }
}
