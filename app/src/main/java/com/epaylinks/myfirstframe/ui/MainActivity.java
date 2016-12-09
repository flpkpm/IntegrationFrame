package com.epaylinks.myfirstframe.ui;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Administrator on 2016/11/7.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_show_result;
    private Button btn_request;

    @Override
    protected void setUpView() {
        btn_request = (Button) findViewById(R.id.btn_request);
        btn_request.setOnClickListener(this);
        tv_show_result = (TextView) findViewById(R.id.tv_show_result);
    }

    @Override
    protected void setUpData() {
        Log.d("deken", "setUpData: ");
    }

    @Override
    protected void setUpContentView() {
       setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        //TODO : 请求数据
        privateStr();
    }

    private Observer<String> observer=new Observer<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String str) {
            Log.d("deken", "onNext: "+str);
        }
    };

    private Subscriber<String> subscriber=new Subscriber<String>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(String s) {
        }
    };
    private String[] strs=new String[]{"ios","android","小明","小王"};
    /**
     * 创建Observable的三种方法  from（T[]） just(T[]) create(new Observable.OnSubscrible<T>(){})
     * 如果监听对象一直可能不会执行相应的Observer 的回调  观察者的对象需要和被观察者一致
     */
    private Observable observable=Observable.from(strs);
    private Observable observable1=Observable.create(new Observable.OnSubscribe() {
        @Override
        public void call(Object o) {

        }
    });
    public void privateStr(){
        observable.map(new Func1<String ,Person>(){//map 一对一转换   也就是OnSubscrible的转换

            @Override
            public Person call(String s) {
                Person per=new Person(s,2);
                return per;
            }
        }).flatMap(new Func1<Person,Observable<String>>() {// 转换observable  进行二次处理

            @Override
            public Observable<String> call(Person person) {

                return Observable.from(person.getCoures());
            }
        }).subscribe(observer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
