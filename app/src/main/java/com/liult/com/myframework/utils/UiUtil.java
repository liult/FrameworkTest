package com.liult.com.myframework.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhilian-2 on 2016/1/15.
 */
public class UiUtil {

    /**
     * 提示语 toast
     * @param msg
     */
    public static void showToast(Context context, String msg){
        if (DataUtil.isEmpty(msg) || context == null) return;
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }



}
