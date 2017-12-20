package com.example.players.utils;


import com.example.players.Bean.CartBean;
import com.example.players.Bean.JiaRuGWC;
import com.example.players.Bean.MyBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by samsung on 2017/12/20.
 */

public interface ApiService {
    @GET("product/getProductDetail?source=android&pid=57")
    Observable<MyBean> getData();

    Retrofit RETROFIT = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.zhaoapi.cn/")
            .build();

    ApiService API_SERVICE = RETROFIT.create(ApiService.class);

    @GET("/product/addCart?source=android&pid=57&uid=2540")
Observable<JiaRuGWC> getDatajr();
    Retrofit RETROFIT_jr = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl("https://www.zhaoapi.cn")
            .build();
    ApiService API_SERVICE_jr = RETROFIT_jr.create(ApiService.class);


    @GET("/product/getCarts?source=android&pid=57&uid=2540")
    Observable<CartBean> getDatajr2();
    Retrofit RETROFIT_jr2 = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl("https://www.zhaoapi.cn")
            .build();
    ApiService API_SERVICE_jr2 = RETROFIT_jr2.create(ApiService.class);
}
