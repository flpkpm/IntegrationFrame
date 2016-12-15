package com.epaylinks.myfirstframe.ui;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;
import com.epaylinks.myfirstframe.utils.ToastUtil;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Administrator on 2016/12/12.
 */

public class TextSizeWholeSet extends BaseActivity {
    private  int index=0;
    @Override
    protected void setUpView() {
        Button btn_set_system= (Button) findViewById(R.id.btn_set_system);
        btn_set_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_set_system:
                        index++;
                        if(index%2==0){
                            state=0;
                            onStart();
                        }else {
                            state=1;
                            onStart();
                        }
                        ToastUtil.showLong("state:"+state);
                        break;
                }
            }
        });
    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_textsize_wholeset);
    }
    ////创建Application、Service、Activity，会调用该方法给mBase属性赋值
    @Override
    protected void attachBaseContext(Context newBase) {
        //需要在创建的时候包裹，也就是需要在baseActivity中添加
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));


    }
}
