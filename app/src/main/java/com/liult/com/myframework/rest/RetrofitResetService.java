package com.liult.com.myframework.rest;

import com.liult.com.myframework.moudle.AppConfigs;

import junit.framework.Test;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by zhilian-2 on 2016/1/12.
 */
public interface RetrofitResetService {

    @Headers({"Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"})
    @GET("/v3/app_config/android")
    Call<AppConfigs> getAppConfig(
            @Header("ceshi") String test,
            @Query("token") String token);

//    @GET("group/{id}/users")
//    Call<List<User>> groupList(@Path("id") int groupId);

}
