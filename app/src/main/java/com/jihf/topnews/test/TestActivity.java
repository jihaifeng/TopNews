package com.jihf.topnews.test;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import butterknife.BindView;
import com.jihf.androidutils.tools.snackBar.SnackBarType;
import com.jihf.androidutils.tools.snackBar.SnackBarUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.app.App;
import com.jihf.topnews.base.BaseSimpleActivity;
import com.jihf.topnews.db.db_module.JsonModule;
import com.jihf.topnews.rx.RxSchedulersHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

import static com.jihf.topnews.db.db_manager.DbManager.key_json_news;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-20 10:41
 * Mail：jihaifeng@raiyi.com
 */
public class TestActivity extends BaseSimpleActivity implements View.OnClickListener {
  @BindView (R.id.animation_sp) Spinner animationSp;
  @BindView (R.id.other_button) Button otherButton;
  @BindView (R.id.ll_root) LinearLayout llRoot;
  @BindView (R.id.btn_save) Button btnSave;
  @BindView (R.id.btn_get) Button btnGet;
  int i = 0;
  @Override protected int getLayoutId() {
    return R.layout.activity_test;
  }

  @Override protected void initViewAndEvent() {
    getToolBar().setTitle("测试");

    // 通过资源文件获取Spinner填充内容
    String[] ls = getResources().getStringArray(R.array.anim_type);
    List<String> list = new ArrayList<>();
    // 把数组内容填充 到集合
    Collections.addAll(list, ls);
    ArrayAdapter<String> animType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
    animType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    animationSp.setAdapter(animType);
    animationSp.setSelection(0);

    otherButton.setOnClickListener(this);

    btnSave.setOnClickListener(v -> {
      i++;
      String val = "json_data_" + i;
      JsonModule jsonModule = new JsonModule();
      jsonModule.json_key = "data";
      jsonModule.json_str = val;
      jsonModule.save();
      App.getInstance().getDbManager().insertNewsJson("json_data_" + i);
    });
    btnGet.setOnClickListener(v -> {
      Observable<List<String>> observable = App.getInstance().getDbManager().getJsonStr(key_json_news);
      observable.compose(RxSchedulersHelper.io_main()).subscribe(new Subscriber<List<String>>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {
          //Exception thrown on Scheduler.Worker thread. Add
          SnackBarUtils.creatShort(llRoot, e.getMessage()).setType(SnackBarType.Confirm).show();
        }

        @Override public void onNext(List<String> list) {

          SnackBarUtils.creatShort(llRoot, list.get(0)).setType(SnackBarType.Confirm).show();
        }
      });
    });
  }

  @Override public void onClick(View v) {
    Intent intent = new Intent();
    intent.setClass(TestActivity.this, OtherActivity.class);
    startActivity(intent);

    switch (animationSp.getSelectedItemPosition()) {
      case 0:
                  /*注意：此方法只能在startActivity和finish方法之后调用。
                    第一个参数为第一个Activity离开时的动画，第二参数为所进入的Activity的动画效果*/
        overridePendingTransition(R.anim.fade, R.anim.hold);
        break;
      case 1:
        overridePendingTransition(R.anim.my_scale_action, R.anim.my_alpha_action);
        break;
      case 2:
        overridePendingTransition(R.anim.scale_rotate, R.anim.my_alpha_action);
        break;
      case 3:
        overridePendingTransition(R.anim.scale_translate_rotate, R.anim.my_alpha_action);
        break;
      case 4:
        overridePendingTransition(R.anim.scale_translate, R.anim.my_alpha_action);
        break;
      case 5:
        overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
        break;
      case 6:
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        break;
      case 7:
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
        break;
      case 8:
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
        break;
      case 9:
        overridePendingTransition(R.anim.wave_scale, R.anim.my_alpha_action);
        break;
      case 10:
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        break;
      case 11:
        overridePendingTransition(R.anim.slide_up_in, R.anim.slide_down_out);
        break;
    }
  }
}
