package com.example.administrator.fuckgank.ui.exciting;

import com.example.administrator.fuckgank.bean.BaseBean;
import com.example.administrator.fuckgank.bean.CategoryBean;
import com.example.administrator.fuckgank.network.GankRequest;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class ExcitingPresenter extends ExcitingContract.Presenter {

    private int currentIndex;

    public ExcitingPresenter(ExcitingContract.View view) {
        super(view);
    }

    @Override
    protected void loadMore() {

    }

    @Override
    protected void refresh() {
        currentIndex = 1;
        view.showProgress();
        GankRequest.getSingle().getGankApi()
                .getCategoryData("福利", currentIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Func1<CategoryBean, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(CategoryBean categoryBean) {
                        return categoryBean.getGankList();
                    }
                })
                .observeOn(Schedulers.io())
                .map(new Func1<List<BaseBean>, List<String>>() {
                    @Override
                    public List<String> call(List<BaseBean> baseBeen) {
                        List<String> urls = new ArrayList<String>(baseBeen.size());
                        for (BaseBean baseBean : baseBeen) {
                            urls.add(baseBean.getUrl());
                        }
                        return urls;
                    }

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> urls) {
                        view.hideProgress();
                        view.refreshUi(urls);
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
        refresh();
    }
}
