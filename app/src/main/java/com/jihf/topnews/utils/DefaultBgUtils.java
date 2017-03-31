package com.jihf.topnews.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.jihf.androidutils.tools.DrawableUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.app.App;
import java.util.Random;

/**
 * Func：默认背景
 * Desc:
 * Author：jihf
 * Data：2017-03-08 16:08
 * Mail：jihaifeng@raiyi.com
 */

public class DefaultBgUtils {

  static Drawable drawable = ContextCompat.getDrawable(App.getInstance(), R.drawable.default_bg);

  private DefaultBgUtils() {
    throw new RuntimeException("DefIconFactory cannot be initialized!");
  }

  private final static int[] DEF_ICON_ID = new int[] {
      R.mipmap.ic_default_1, R.mipmap.ic_default_2, R.mipmap.ic_default_3, R.mipmap.ic_default_4, R.mipmap.ic_default_5
  };
  private final static int[] defaultColors = new int[] {
      Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.GRAY
  };

  public static Drawable provideDrawable() {
    int index = new Random().nextInt(defaultColors.length);
    return DrawableUtils.tintDrawable(drawable, defaultColors[index]);
  }

  public static int provideIcon() {
    int index = new Random().nextInt(DEF_ICON_ID.length);
    return DEF_ICON_ID[index];
  }
}
