package com.epaylinks.myfirstframe.http;

import com.epaylinks.myfirstframe.base.BaseApplication;
import com.epaylinks.myfirstframe.utils.Util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/10.
 */

public class HttpRequest {
    private String cacheDir;
    private  Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;
    private  RequestService requestService;

    //初始化OkHttpClient
    private void initOkHttp(){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();

        //缓存
        File cacheFile=new File(BaseApplication.cacheDir,"/NetCache");
        Cache cache=new Cache(cacheFile,1024*1024*50);
        Interceptor cacheInterceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request();
                if(!Util.isNetworkConnected(BaseApplication.getmAppContext())){
                    request=request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response=chain.proceed(request);
                if(Util.isNetworkConnected(BaseApplication.getmAppContext())){
                    int maxAge=0;
                    response.newBuilder().header("Cache-Control","public, max-age="+maxAge);
                }else{
                    //无网络设置超时时间
                    int maxStatle=60 * 60 * 24 * 28;
                    response.newBuilder().header("Cache-Control","public, only-if-cached,max-stale="+maxStatle)
                            .build();
                }
                return response;
            }
        };
        builder.cache(cache).addInterceptor(cacheInterceptor);
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20,TimeUnit.SECONDS);
        builder.writeTimeout(20,TimeUnit.SECONDS);
        //连接错误 设置重连
        builder.retryOnConnectionFailure(true);
        mOkHttpClient=builder.build();
    }

    public HttpRequest() {
        initOkHttp();
        mRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Urls.BASEURl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient)//只能添加okhttpClient 如果需要进行缓存可以在这里引入
                .build();
        requestService = mRetrofit.create(RequestService.class);
    }

    public RequestService getRequestService(){
        return requestService;
    }
    //观察者 当被观察者出现变化时，就会调用观察者的方法
    private Observer<HttpResposeBean<QuestionLists>> observer=new Observer<HttpResposeBean<QuestionLists>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(HttpResposeBean<QuestionLists> questionListsHttpResposeBean) {
        }
    };

    public void getResult(){
        Observable<HttpResposeBean<QuestionLists>> observable= requestService.getQuestionList();
        observable.flatMap(new Func1<HttpResposeBean<QuestionLists>, Observable<HttpResposeBean<QuestionLists>>>() {//将
            @Override
            public Observable<HttpResposeBean<QuestionLists>> call(HttpResposeBean<QuestionLists> questionListsHttpResposeBean) {
               Question q= questionListsHttpResposeBean.getResponse_detail().getQueryList().get(0);
                return null;
            }
        });
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();//
        observable.subscribe(observer);
    }

}
