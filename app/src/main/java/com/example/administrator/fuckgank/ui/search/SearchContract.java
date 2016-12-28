package com.example.administrator.fuckgank.ui.search;

import com.example.administrator.fuckgank.base.MvpPresenter;
import com.example.administrator.fuckgank.base.MvpView;
import com.example.administrator.fuckgank.bean.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public interface SearchContract {
    interface View extends MvpView {
        void showProgress();
        void hideProgress();
        void refreshUi(List<BaseBean> data);
    }

    abstract class Presenter extends MvpPresenter {
        protected SearchContract.View view;
        public Presenter(SearchContract.View view) {
            this.view = view;
            start();
        }

        protected abstract void search(String query);
    }
}
