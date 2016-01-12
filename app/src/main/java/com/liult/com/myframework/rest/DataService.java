package com.liult.com.myframework.rest;

import retrofit.GsonConverterFactory;
import retrofit.RxJavaCallAdapterFactory;
import retrofit2.Retrofit;

/**
 * Created by zhilian-2 on 2016/1/12.
 */
public class DataService {

    public static final String RELEASE_ENDPOINT = "http://api.1mxian.com/";

    private static DataService sInstance;
//http://www.th7.cn/Program/Android/201510/603107.shtml  http://square.github.io/retrofit/
    public DataService() {
        //经过测试: baseUrl必须设置,如果 声明接口时@GET使用了完整的url路径,那么baseUrl就会被忽略,否则就是拼接url
        Retrofit builder = new Retrofit.Builder()//在这里可以添加 Gson转换器等;
                .baseUrl(RELEASE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    }

    public static DataService getInstance() {
        if (sInstance == null) {
            sInstance = new DataService();
        }
        return sInstance;
    }


}
