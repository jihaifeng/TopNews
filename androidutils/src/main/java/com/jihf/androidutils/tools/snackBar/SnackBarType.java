package com.jihf.androidutils.tools.snackBar;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.jihf.androidutils.tools.snackBar.SnackBarType.Alert;
import static com.jihf.androidutils.tools.snackBar.SnackBarType.Confirm;
import static com.jihf.androidutils.tools.snackBar.SnackBarType.Info;
import static com.jihf.androidutils.tools.snackBar.SnackBarType.Warning;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-27 14:18
 * Mail：jihaifeng@raiyi.com
 */
@IntDef ({ Info, Confirm, Warning, Alert }) // 枚举数据
@Retention (RetentionPolicy.SOURCE) //告诉编译器在生成.class文件时不保留枚举注解数据
public @interface SnackBarType {
  int Info = 1;
  int Confirm = 2;
  int Warning = 3;
  int Alert = 4;
}
