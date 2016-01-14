package com.liult.com.myframework.utils;

/**
 * 各种数据验证
 * Created by zhilian-2 on 2016/1/14.
 */
public class DataUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if (str == null || str.equals(""))
            return true;
        else return false;
    }
}
