package com.liult.com.myframework;

import android.app.Application;

import com.liult.com.myframework.utils.DataUtil;

/**
 * Created by zhilian-2 on 2016/1/16.
 */
public class AppApplacation extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        DataUtil.init(getApplicationContext());
    }
}
