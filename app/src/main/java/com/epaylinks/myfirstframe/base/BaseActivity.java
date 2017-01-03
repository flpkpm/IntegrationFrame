package com.epaylinks.myfirstframe.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Administrator on 2016/11/7.
 */

public abstract class BaseActivity extends AppCompatActivity{
    protected static  int state=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //其实图片也应该相应改变,注意可以设置多个主题属性
//        switch (state){
//            case 0:
//                setTheme(R.style.big_textStyle);
//                break;
//            case 1:
//                setTheme(R.style.small_textStyle);
//                break;
//        }
        setUpContentView();
        setUpView();
        setUpData();

    }

    protected abstract void setUpView();
    protected  void setUpData(){};
    protected abstract void setUpContentView();

    public void setContentView(int id){
        super.setContentView(id);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * 跳转目标activity
     * @param targetActivity
     * @param bundle
     */
    protected void starttargetActivity(Class targetActivity, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, targetActivity);

        if (bundle != null) {
            intent.putExtras(bundle);
        }

        startActivity(intent);
    }

}
