package com.epaylinks.myfirstframe.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.epaylinks.myfirstframe.base.BaseApplication;


/**
 * Created by HugoXie on 16/5/23.
 *
 * Email: Hugo3641@gamil.com
 * GitHub: https://github.com/xcc3641
 * Info:
 */
public class ToastUtil {

    private  static Toast toast;
    private static Toast toastLong;
    private static long oldTime;
    private static long newTime;
    private static CharSequence oldMsg;

    private ToastUtil() {
		/* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     *如果时间少于2s 就不会重新创建Toast 直接修改Toast的内容
     *
     * @param context
     * @param message
     */
    public static synchronized void  showShort(Activity ac, Context context, CharSequence message) {
        final Context mContext=context;
        final CharSequence mMessage=message+"";
        ac.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(mContext, mMessage, Toast.LENGTH_SHORT);
                    oldMsg = mMessage;
                    oldTime = System.currentTimeMillis();
                } else {
                    newTime = System.currentTimeMillis();
                    if (mMessage.equals(oldMsg)) {
                        if ((newTime - oldTime) > 2000) {
                            toast = Toast.makeText(mContext, mMessage, Toast.LENGTH_SHORT);
                        }
                    } else {
                        oldMsg = mMessage;
                        toast.setText(oldMsg);
                    }
                    Log.e("Toatutils", "toast"+mMessage+"  :  lodMsg"+oldMsg+"timer count:"+(newTime - oldTime));
                }
                toast.show();
                oldTime = newTime;
            }
        });

    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static synchronized void showLong(Activity ac, Context context, CharSequence message) {
        final Context mContext=context;
        final CharSequence mMessage=message+"";
        ac.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (toastLong == null) {
                    toastLong = Toast.makeText(mContext, mMessage, Toast.LENGTH_LONG);
                    oldMsg = mMessage;
                    oldTime = System.currentTimeMillis();
                } else {
                    newTime = System.currentTimeMillis();
                    if (mMessage.equals(oldMsg)) {
                        if ((newTime - oldTime) > 3500) {
                            toastLong = Toast.makeText(mContext, mMessage, Toast.LENGTH_LONG);
                        }
                    } else {
                        oldMsg = mMessage;
                        toastLong.setText(oldMsg);
                    }
                }
                toastLong.show();
                oldTime = newTime;
            }
        });
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    public static void showShort(String msg) {
        Toast.makeText(BaseApplication.getmAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(BaseApplication.getmAppContext(), msg, Toast.LENGTH_LONG).show();
    }
}
