package com.liult.com.myframework.rest;

import com.liult.com.myframework.moudle.AppConfig;
import com.liult.com.myframework.moudle.AppConfigs;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by zhilian-2 on 2016/1/12.
 */
public interface RetrofitResetService {

    @GET("/v3/app_config/android")
    Call<AppConfigs> getAppConfig(
            @Query("token") String token);

}
