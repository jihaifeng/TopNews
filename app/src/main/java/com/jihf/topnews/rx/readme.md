> Rx系列封装需要依赖以下第三方库

```
  compile 'com.squareup.retrofit2:retrofit:2.1.0'
  compile 'com.squareup.retrofit2:converter-gson:2.1.0'
  compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
  compile 'com.squareup.okhttp3:logging-interceptor:3.1.2'
  compile 'com.squareup.okhttp3:okhttp-urlconnection:3.2.0'
```

> 使用方法

```
 service.login()
        .compose(RxSchedulersHelper.io_main())
        .subscribe(new RxSubscriber<User user>() {
                        @Override
                        public void onNext(User user) {
                            // 处理user
                        }

                        @Override
                        public void onError(String msg) {
                            // 处理Error
                      });

```

> RxBus 利用rxjava的特性实现事件总线功能，有效代替EventBus

  用来传递数据的事件类 （Event）：
   ````
  public class UserEvent {
    public long id;
    public String name;

    public UserEvent(long id, String name) {
      this.id = id;
      this.name = name;
    }
  }
  ````
  发送事件：
  ````
  RxBus.getInstance().post(new UserEvent(1, "jihf"));

  ````
  接收事件并处理：
  ````
   subscription = RxBus.getInstance().toObservable(UserEvent.class).subscribe(new Action1<UserEvent>() {
        @Override public void call(UserEvent userEvent) {
        // 接收到信息后处理
          ToastUtils.showShort(userEvent.name);
        }
      }, new Action1<Throwable>() {
        @Override public void call(Throwable throwable) {
        // 异常处理
          ToastUtils.showShort(throwable.getMessage());
        }
      });

  ````
  注意，subscriptiond定义成全局变量，一定要在onDestory方法中取消订阅，防止出现内存泄漏
  ````
    @Override protected void onDestroy() {
      super.onDestroy();
      if (null != subscription && !subscription.isUnsubscribed()) {
        subscription.unsubscribe();
      }
    }
  ``````
