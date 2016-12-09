package com.epaylinks.myfirstframe.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;

/**
 * Created by Administrator on 2016/11/24.
 */

public class PermissionActiviry extends BaseActivity implements View.OnClickListener {

    private Button btn_read_or_write;
    private Button btn_call;

    @Override
    protected void setUpView() {
        btn_call = (Button) findViewById(R.id.btn_call);
        btn_call.setOnClickListener(this);
        btn_read_or_write = (Button) findViewById(R.id.btn_read_or_write);
        btn_read_or_write.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_perimission);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_call:
                Log.d("deken", "btn_call"+false);
                //检查是否授权，如若没有变申请 AppCompatActivity  ContextCompat   AppCompatActivity
                //只是在用户应用管理界面被全局拒绝之后才会有的true
                if(ContextCompat.checkSelfPermission(PermissionActiviry.this , Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},0);
                }else{
                    doCall();
                }
                // 申请监听回调 如果用户拒绝则告知重要性 再次选择 ，如果还不愿意 就退出当前
                break;
            case R.id.btn_read_or_write:
                break;
        }
    }
    public void doCall(){
        Intent intent=new Intent();
        intent.setData(Uri.parse("tel:10086"));
        intent.setAction(Intent.ACTION_CALL);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 0:
                //打电话权限回调
                //再次检查
                if(ContextCompat.checkSelfPermission(PermissionActiviry.this , Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    //展示说明  不能获取无法进行操作
                    Log.d("deken", "onRequestPermissionsResult: 不能获取无法进行操作"+false);
                    //需要进行开启
                }else{
                    Log.d("deken", "onRequestPermissionsResult: 不能获取无法进行操作"+true);
                    doCall();
                }
            break;
        }
    }
}
