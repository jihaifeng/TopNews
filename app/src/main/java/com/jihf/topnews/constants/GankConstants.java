package com.jihf.topnews.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-28 09:05
 * Mail：jihaifeng@raiyi.com
 */
public class GankConstants {
  //  福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
  private static List<String> typeList = new ArrayList<>();
  public static final String gank_all = "all";
  private static final String gank_html = "前端";
  private static final String gank_android = "Android";
  private static final String gank_ios = "iOS";
  public static final String gank_fuli = "福利";
  private static final String gank_shiping = "休息视频";
  private static final String gank_ziyuan = "拓展资源";

  public static List<String> getTypeList() {
    if (typeList.size() != 0) {
      typeList.clear();
    }
    //typeList.add(gank_all);
    typeList.add(gank_html);
    typeList.add(gank_android);
    typeList.add(gank_ios);
    //typeList.add(gank_fuli);
    //typeList.add(gank_shiping);
    typeList.add(gank_ziyuan);
    return typeList;
  }
}
