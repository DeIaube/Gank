package com.example.administrator.fuckgank.ui.today;

import com.example.administrator.fuckgank.bean.BaseBean;
import com.example.administrator.fuckgank.bean.DateData;
import com.example.administrator.fuckgank.bean.GankDayItem;
import com.example.administrator.fuckgank.network.GankApi;
import com.example.administrator.fuckgank.network.GankRequest;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class TodayPresenter extends TodyContract.Presenter {

    public TodayPresenter(TodyContract.View view) {
        super(view);

    }

    @Override
    protected void refreshData() {
        final GankApi gankApi = GankRequest.getSingle().getGankApi();
        view.showProgress();
        gankApi.getDateHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(new Func1<DateData, Observable<GankDayItem>>() {
                    @Override
                    public Observable<GankDayItem> call(DateData dateData) {
                        DateData.GankData newDate = dateData.getNewDate();
                        return gankApi.getGankDayData(newDate.getYear(), newDate.getMonth(), newDate.getDay());
                    }
                })
                .observeOn(Schedulers.io())
                .map(new Func1<GankDayItem, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(GankDayItem gankDayItem) {
                        return gankDayItem.getGankList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<BaseBean>>() {
                    @Override
                    public void call(List<BaseBean> baseBeen) {
                        view.hideProgress();
                        view.refreshUi(baseBeen);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        view.hideProgress();
                    }
                });
    }

    @Override
    protected void start() {
        refreshData();
    }

}
