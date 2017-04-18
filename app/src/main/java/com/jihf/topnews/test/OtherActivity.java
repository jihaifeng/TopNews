package com.jihf.topnews.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.jakewharton.rxbinding.view.RxView;
import com.jihf.topnews.R;
import com.jihf.topnews.databinding.ActivityOtherBinding;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-21 10:56
 * Mail：jihaifeng@raiyi.com
 */
public class OtherActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityOtherBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_other);
    binding.tvDesc.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    RxView.clicks(binding.tvDesc)
        .subscribe(aVoid -> Toast.makeText(OtherActivity.this, "hello world", Toast.LENGTH_SHORT).show());
  }
}
