package com.epaylinks.myfirstframe.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;
import com.epaylinks.myfirstframe.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * Created by Administrator on 2016/12/5.
 */

public class EventBusActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_send_message;
    private Button btn_goto_second_one;
    private static final String TAG = "EventBusActivity";

    @Override
    protected void setUpView() {
        btn_send_message = (Button) findViewById(R.id.btn_send_message);
        btn_send_message.setOnClickListener(this);

        btn_goto_second_one = (Button) findViewById(R.id.btn_goto_second_one);
        btn_goto_second_one.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_eventbus);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleMessage(EventBusMessage message){
        if(message.getWhat()==1){
            ToastUtil.showLong("收到来自eventBusMessage的消息:"+message.getMessage());
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //只能注册一个  源码中只有为空的时候才初始化否则重复注册会抛出异常
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Log.d(TAG, "onDestroy:");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_message:
                EventBusMessage message=new EventBusMessage();
                message.setMessage("hehda");
                message.setWhat(1);
            EventBus.getDefault().post(message);
            break;
            case R.id.btn_goto_second_one:
                starttargetActivity(EventBusSecondActivity.class,null);
                break;
        }
    }
}
