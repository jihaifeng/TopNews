package com.jihf.topnews.utils;

import com.jihf.topnews.R;
import java.util.Random;

/**
 * Func：默认背景
 * Desc:
 * Author：jihf
 * Data：2017-03-08 16:08
 * Mail：jihaifeng@raiyi.com
 */
public class DefaultBgUtils {
  private final static int[] DEF_ICON_ID = new int[] {
      R.mipmap.ic_default_1, R.mipmap.ic_default_2, R.mipmap.ic_default_3, R.mipmap.ic_default_4, R.mipmap.ic_default_5
  };

  private DefaultBgUtils() {
    throw new RuntimeException("DefIconFactory cannot be initialized!");
  }

  public static int provideIcon() {
    int index = new Random().nextInt(DEF_ICON_ID.length);
    return DEF_ICON_ID[index];
  }
}
