package com.jihf.topnews.model.gank;

import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-27 17:41
 * Mail：jihaifeng@raiyi.com
 */
public class GankResultBean {
  /**
   * _id : 58c76458421aa95810795c60
   * createdAt : 2017-03-14T11:32:40.519Z
   * desc : 有趣的Autolayout示例5-Masonry实现
   * images : ["http://img.gank.io/2bf67095-30c7-4ba9-9c88-5415cc31d65d"]
   * publishedAt : 2017-03-14T13:17:14.21Z
   * source : web
   * type : iOS
   * url : http://tutuge.me/2017/03/12/autolayout-example-with-masonry5/
   * used : true
   * who : zekunyan
   */
  public String _id;
  public String createdAt;
  public String desc;
  public String publishedAt;
  public String source;
  public String type;
  public String url;
  public boolean used;
  public String who;
  public List<String> images;
  public int height;
}
