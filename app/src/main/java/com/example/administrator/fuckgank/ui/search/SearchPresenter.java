package com.example.administrator.fuckgank.ui.search;

import com.example.administrator.fuckgank.bean.BaseBean;
import com.example.administrator.fuckgank.bean.SearchBean;
import com.example.administrator.fuckgank.network.GankApi;
import com.example.administrator.fuckgank.network.GankRequest;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class SearchPresenter extends SearchContract.Presenter {

    public SearchPresenter(SearchContract.View view) {
        super(view);
    }

    @Override
    protected void search(String query) {
        view.showProgress();
        GankApi gankApi = GankRequest.getSingle().getGankApi();
        gankApi.getSearchData(query)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Func1<SearchBean, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(SearchBean searchBean) {
                        return searchBean.getGankList();
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

    }
}
