package com.epaylinks.myfirstframe.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016/11/7.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpContentView();
        setUpView();
        setUpData();

    }

    protected abstract void setUpView();
    protected abstract void setUpData();
    protected abstract void setUpContentView();

    public void setContentView(int id){
        super.setContentView(id);
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
