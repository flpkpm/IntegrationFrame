package com.epaylinks.myokhttp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String url="https://www.epaylinks.cn/appMiddle/recharge/qryOrder.do?sign=ehkepDrpNPaiGaen1l2PrzOzfCIuKR0ClP/aU3sbRqECmeKzAMXs0MTlRW/n4xAImL61lpPiOqqU2XWiEAzCPJKZgJjhBzLGBja0j%2BUV7SPK%2Birj2qYdeMWz2pXl4sQngnnxyBpAkbgOOo/Xxflxfj0KilfPhj0dbPm9WA6qU%2B8%3D&deviceType=mobile&countPerPage=20&pageCount=1&timestamp=2016-11-24%2011:06:25&deviceInfo=357541051314195&startPageNum=1&cardNo=5387380000405678";
    private Button btn_request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_request = (Button) findViewById(R.id.btn_request);
        btn_request.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        httpRequest();

    }

    private void httpRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url(url).build();
//                //方法一
//                try {
//                    Response response=client.newCall(request).execute();
//                    Log.d("deken"," current thread:"+Thread.currentThread()+"   1: "+response.body().string());
//                    response.body().close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                //方法二： enqueue  需要转主线程

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("deken"," current thread:"+Thread.currentThread()+"   IOException: "+e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                        Log.d("deken"," current thread:"+Thread.currentThread()+"   response: "+response.body().string());

                    }
                });
            }
        }).start();
    }
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
