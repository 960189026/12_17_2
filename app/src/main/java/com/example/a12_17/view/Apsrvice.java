package com.example.a12_17.view;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Apsrvice {
    @GET
    Observable<ResponseBody> get(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> post(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<Response> post(@Url String url, @FieldMap HashMap<String, String> map);

}
