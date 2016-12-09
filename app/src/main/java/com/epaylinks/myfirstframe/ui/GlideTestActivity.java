package com.epaylinks.myfirstframe.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.epaylinks.myfirstframe.ErrCodeUtilsMap;
import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;


/**
 * Created by Administrator on 2016/11/29.
 */

public class GlideTestActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_gift;
    private ImageView iv_show_nomal;
    private ImageView iv_video;
    private RequestManager requestManager;
    private String imageUrl="http://a.hiphotos.baidu.com/image/pic/item/9213b07eca806538ac3355cc93dda144ac348210.jpg";
    private String imageGifUrl="http://attimg.dospy.com/img/day_111013/20111013_4d563de4bee78ec2f1a96tcg7meZMi4K.gif";
    private Button btn_getcode_map;
    private Button btn_getcode_switch;

    @Override
    protected void setUpView() {
        iv_gift = (ImageView) findViewById(R.id.iv_gift);
        iv_show_nomal= (ImageView) findViewById(R.id.iv_show_nomal);
        iv_video= (ImageView) findViewById(R.id.iv_video);

        btn_getcode_map = (Button) findViewById(R.id.btn_getcode_map);
        btn_getcode_switch = (Button) findViewById(R.id.btn_getcode_switch);


        iv_gift.setOnClickListener(this);
        iv_show_nomal.setOnClickListener(this);
        iv_video.setOnClickListener(this);
        btn_getcode_map.setOnClickListener(this);
        btn_getcode_switch.setOnClickListener(this);

        requestManager = Glide.with(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_glide);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_show_nomal:

                //from net 直接从网上写入  这样就会很方便
                requestManager.load(imageUrl)
                        .into(iv_show_nomal);
                break;
            case R.id.iv_video:
                //from  local
                requestManager.load(R.mipmap.a).thumbnail(0.1f)
                        .into(iv_video);
                break;
            case R.id.iv_gift:
                requestManager.load(imageGifUrl).thumbnail(0.1f)
                        .into(iv_gift);
                break;
            case R.id.btn_getcode_map:
               String msg= ErrCodeUtilsMap.showMsg("00000");
//                ToastUtil.showLong(msg);
                break;
            case R.id.btn_getcode_switch:
//                String msg1=  ErrCodeUtils.showMsg("00000");
//                ToastUtil.showLong(msg1);
                break;

        }
    }
}
