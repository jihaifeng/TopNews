package com.jihf.topnews.rx;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;
import javax.annotation.Nonnull;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Func：RxLifecycleHelper 工具类
 * Desc: 解决MVP架构下model层获取数据时没有bind方法，避免内存泄漏，compose操作符
 * Author：jihf
 * Data：2017-02-16 18:04
 * Mail：jihaifeng@raiyi.com
 */
public class RxLifecycleHelper {
  private static BehaviorSubject<ActivityEvent> activityLifecycleSubject = BehaviorSubject.create();
  private static BehaviorSubject<FragmentEvent> fragmentLifecycleSubject = BehaviorSubject.create();

  public Observable<ActivityEvent> lifecycle() {
    return activityLifecycleSubject.asObservable();
  }

  public static <T> LifecycleTransformer<T> bindActivityUntilEvent(@Nonnull ActivityEvent event) {
    activityLifecycleSubject.asObservable();
    activityLifecycleSubject.onNext(event);
    return RxLifecycle.bindUntilEvent(activityLifecycleSubject, event);
  }

  public static <T> LifecycleTransformer<T> bindToActivityLife() {
    activityLifecycleSubject.asObservable();
    activityLifecycleSubject.onNext(ActivityEvent.DESTROY);
    return RxLifecycleAndroid.bindActivity(activityLifecycleSubject);
  }

  public static <T> LifecycleTransformer<T> bindFragmentUntilEvent(@Nonnull FragmentEvent event) {
    fragmentLifecycleSubject.asObservable();
    fragmentLifecycleSubject.onNext(event);
    return RxLifecycle.bindUntilEvent(fragmentLifecycleSubject, event);
  }

  public static <T> LifecycleTransformer<T> bindToFragmentLife() {
    fragmentLifecycleSubject.asObservable();
    fragmentLifecycleSubject.onNext(FragmentEvent.DESTROY);
    return RxLifecycleAndroid.bindFragment(fragmentLifecycleSubject);
  }
}

