package com.jihf.topnews.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-06 16:41
 * Mail：jihaifeng@raiyi.com
 */
public class JuHeConstants {
  /*聚合数据====新闻头条key*/
  public static final String KEY_NEWS = "24aa6855dfa28e439b0e1529ef9dbc9c";
  /*新闻类型*/
  public static final String TYPE_TOP = "top";//头条，默认
  private static final String TYPE_SHEHUI = "shehui";//社会
  private static final String TYPE_GUONEI = "guonei";//国内
  private static final String TYPE_GUOJI = "guoji";//国际
  private static final String TYPE_YULE = "yule";//娱乐
  private static final String TYPE_TIYU = "tiyu";//体育
  private static final String TYPE_JUNSHI = "junshi";//军事
  private static final String TYPE_KEJI = "keji";//科技
  private static final String TYPE_CAIJING = "caijing";//财经
  private static final String TYPE_SHISHANG = "shishang";//时尚

  private static List<String> newsTypeList = new ArrayList<>();
  private static HashMap<String, String> newsTypeMap = new HashMap<>();

  private static boolean hasShowLoading = false;

  public static List<String> getNewsTypeList() {
    if (newsTypeList.size() != 0) {
      newsTypeList.clear();
    }
    newsTypeList.add(TYPE_TOP);
    newsTypeList.add(TYPE_SHEHUI);
    newsTypeList.add(TYPE_GUONEI);
    newsTypeList.add(TYPE_GUOJI);
    newsTypeList.add(TYPE_YULE);
    newsTypeList.add(TYPE_TIYU);
    newsTypeList.add(TYPE_JUNSHI);
    newsTypeList.add(TYPE_KEJI);
    newsTypeList.add(TYPE_CAIJING);
    newsTypeList.add(TYPE_SHISHANG);
    return newsTypeList;
  }

  public static HashMap<String, String> getNewsTypeMap() {
    if (newsTypeMap.size() != 0) {
      newsTypeMap.clear();
    }
    newsTypeMap.put(TYPE_TOP, "头条");
    newsTypeMap.put(TYPE_SHEHUI, "社会");
    newsTypeMap.put(TYPE_GUONEI, "国内");
    newsTypeMap.put(TYPE_GUOJI, "国际");
    newsTypeMap.put(TYPE_YULE, "娱乐");
    newsTypeMap.put(TYPE_TIYU, "体育");
    newsTypeMap.put(TYPE_JUNSHI, "军事");
    newsTypeMap.put(TYPE_KEJI, "科技");
    newsTypeMap.put(TYPE_CAIJING, "财经");
    newsTypeMap.put(TYPE_SHISHANG, "时尚");
    return newsTypeMap;
  }

  public static void setHasShowLoading(boolean flag) {
    hasShowLoading = flag;
  }

  public static boolean isHasShowLoading() {
    return hasShowLoading;
  }
}
