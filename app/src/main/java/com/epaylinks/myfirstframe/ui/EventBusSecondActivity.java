package com.epaylinks.myfirstframe.ui;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by Administrator on 2016/12/5.
 */

public class EventBusSecondActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_finish;
    private static final String TAG = "EventBusSecondActivity";

    @Override
    protected void setUpView() {
        btn_finish = (Button) findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_eventbus_second);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }




    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_finish:
                EventBusMessage message=new EventBusMessage();
                message.setWhat(1);
                message.setMessage("第二个Activity给你的消息！");
                EventBus.getDefault().post(message);
                break;
        }
    }
}
