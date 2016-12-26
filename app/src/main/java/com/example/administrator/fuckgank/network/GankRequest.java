package com.example.administrator.fuckgank.network;

import com.example.administrator.fuckgank.config.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class GankRequest {
    private GankApi gankApi;
    private OkHttpClient client;

    private GankRequest() {
        client = new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .connectTimeout(3, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        gankApi = retrofit.create(GankApi.class);
    }

    public GankApi getGankApi() {
        return gankApi;
    }

    public static GankRequest getSingle(){
        return GankRequestHolder.request;
    }

    private static class GankRequestHolder{
        public static GankRequest request = new GankRequest();
    }
}
