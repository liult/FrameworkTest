package com.liult.com.myframework.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * retrofit初始化工具类
 */
public class RetrofitDataService {

    public static final String RELEASE_ENDPOINT = "http://api.1mxian.com/";

    private static RetrofitDataService sInstance;
    public RetrofitResetService mResetService;
    //http://www.th7.cn/Program/Android/201510/603107.shtml  http://square.github.io/retrofit/
    public RetrofitDataService() {
        Retrofit builder = new Retrofit.Builder()//在这里可以添加 Gson转换器等;
                .baseUrl(RELEASE_ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mResetService = builder.create(RetrofitResetService.class);
    }

    public static RetrofitDataService getInstance() {
        if (sInstance == null) {
            sInstance = new RetrofitDataService();
        }
        return sInstance;
    }

}
