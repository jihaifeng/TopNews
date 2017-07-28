## Introduction
以最简洁的 **Api** 让 **Retrofit** 同时支持多个 **BaseUrl** 以及动态改变 **BaseUrl**.

> [**框架的分析和思路**](http://www.jianshu.com/p/2919bdb8d09a)   

> [**框架原始地址**](https://github.com/JessYanCoding/RetrofitUrlManager)

## Download
```
 compile 'me.jessyan:retrofit-url-manager:1.0.5'
```

## Usage
### Initialize
``` 
 // 构建 OkHttpClient 时,将 OkHttpClient.Builder() 传入 with() 方法,进行初始化配置
 OkHttpClient = RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder())
                .build();
```

### Step 1
``` 
 public interface ApiService {
     @Headers({"Domain-Name: douban}) // 加上 Domain-Name header
     @GET("/v2/book/{id}")
     Observable<ResponseBody> getBook(@Path("id") int id);
}

```

### Step 2
``` 
 // 可在 App 运行时,随时切换 BaseUrl (指定了 Domain-Name header 的接口)
 
 RetrofitUrlManager.getInstance().putDomain("douban", "https://api.douban.com");
```

### If you want to change the global BaseUrl
```
 // 全局 BaseUrl 的优先级低于 Domain-Name header 中单独配置的，其他未配置的接口将受全局 BaseUrl 的影响
 
 RetrofitUrlManager.getInstance().setGlobalDomain(“your BaseUrl”);

```

