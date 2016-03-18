package com.extras.com.utils;

/**
 * Created by zhilian-2 on 2016/1/18.
 */
public class DataUtil {

    /**
     * 判断字符是否为空
     * @param text
     */
    public static boolean isEmpty(String text){
        if (text == null || text.equals(""))
            return true;
        else return false;
    }
}
