package com.example.a12_17.view;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements INetWorkInterface {
    private static RetrofitUtils retrofitUtils;
    private Apsrvice apsrvice;
    private RetrofitUtils(){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apsrvice = retrofit.create(Apsrvice.class);
    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils == null){
           synchronized (RetrofitUtils.class){
              if (retrofitUtils == null){
                 retrofitUtils = new RetrofitUtils();
              }
           }
        }
        return retrofitUtils;
    }
    @Override
    public <T> void get(String url, final INetCallBack<T> callBack) {
        apsrvice.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.toString();
                            //获取参数化形
                            Type[] genericinface = callBack.getClass().getGenericInterfaces();
                            //获取实际类型
                            Type[] actuaTypeArguments = ((ParameterizedType)genericinface[0]).getActualTypeArguments();
                            Type t = actuaTypeArguments[0];
                            Gson gson = new Gson();
                            T resultt = gson.fromJson(string, t);
                            callBack.onSuess(resultt);
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public <T> void post(String url, final INetCallBack<T> callBack) {
        apsrvice.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
//                            获取参数化类型
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

//                              获取参数化类型的实际类型
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            Gson gson =  new Gson();
                            T resultt =  gson.fromJson(string, t);
                            callBack.onSuess(resultt);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, final INetCallBack<T> callBack) {
        apsrvice
                .post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Response>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Response response) {
                            try {
                                String string = response.toString();
                                Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

//                              获取参数化类型的实际类型
                                Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                                Type t = actualTypeArguments[0];
                                Gson gson =  new Gson();
                                T resultt =  gson.fromJson(string, t);
                                callBack.onSuess(resultt);
                            } catch (JsonSyntaxException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });


    }
}
