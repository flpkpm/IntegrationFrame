package com.epaylinks.myfirstframe.base;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by xcc on 2015/12/16.
 */
public class BaseApplication extends Application {

    public static String cacheDir;
    public static Context mAppContext = null;
    private static  Context mBaseApplication;

    // TODO: 16/8/1 这里的夜间模式 UI 有些没有适配好 暂时放弃夜间模式
    static {
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();


        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static Context getmAppContext() {
        return mAppContext;
    }

    public static String getCachedir(){
        return cacheDir;
    }
}
