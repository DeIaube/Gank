package com.example.administrator.fuckgank.network;

import com.example.administrator.fuckgank.bean.CategoryBean;
import com.example.administrator.fuckgank.bean.DateData;
import com.example.administrator.fuckgank.bean.GankDayItem;
import com.example.administrator.fuckgank.bean.SearchBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public interface GankApi {
    @GET("day/history")
    Observable<DateData> getDateHistory();
    @GET("day/{year}/{month}/{day}")
    Observable<GankDayItem> getGankDayData(@Path("year") int year, @Path("month") int month, @Path("day") int day);

    @GET("search/query/{query}/category/all/count/50/page/1")
    Observable<SearchBean> getSearchData(@Path("query") String query);

    @GET("data/{category}/50/{index}")
    Observable<CategoryBean> getCategoryData(@Path("category") String category, @Path("index") int index);
}
