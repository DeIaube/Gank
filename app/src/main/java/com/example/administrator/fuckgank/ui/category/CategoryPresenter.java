package com.example.administrator.fuckgank.ui.category;

import android.util.Log;

import com.example.administrator.fuckgank.bean.BaseBean;
import com.example.administrator.fuckgank.bean.CategoryBean;
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

public class CategoryPresenter extends CategoryContract.Presenter {


    public CategoryPresenter(CategoryContract.View view) {
        super(view);
    }

    private int currentIndex;

    @Override
    protected void loadMore(String category) {
        GankApi gankApi = GankRequest.getSingle().getGankApi();
        view.showProgress();
        gankApi.getCategoryData(category, ++currentIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Func1<CategoryBean, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(CategoryBean searchBean) {
                        return searchBean.getGankList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<BaseBean>>() {
                    @Override
                    public void call(List<BaseBean> baseBeen) {
                        view.hideProgress();
                        view.loadMoreUi(baseBeen);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        view.hideProgress();
                    }
                });
    }

    @Override
    protected void refresh(String category) {
        view.showProgress();
        currentIndex = 1;
        GankApi gankApi = GankRequest.getSingle().getGankApi();
        gankApi.getCategoryData(category, currentIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Func1<CategoryBean, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(CategoryBean searchBean) {
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
                        Log.i("fuck", throwable.toString());
                    }
                });
    }

    @Override
    protected void start() {
    }
}
