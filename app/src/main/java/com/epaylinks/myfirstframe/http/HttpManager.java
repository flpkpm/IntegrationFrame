package com.epaylinks.myfirstframe.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/9.
 */

public class HttpManager {
    private static HttpManager mHttpManager;
    public static HttpManager getInstance(){
        if(null==mHttpManager){
            mHttpManager=new HttpManager();
        }
        return mHttpManager;
    }
    private HttpManager() {

    }


}
