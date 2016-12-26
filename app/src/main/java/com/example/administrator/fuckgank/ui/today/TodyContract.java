package com.example.administrator.fuckgank.ui.today;

import com.example.administrator.fuckgank.base.MvpPresenter;
import com.example.administrator.fuckgank.base.MvpView;
import com.example.administrator.fuckgank.bean.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public interface TodyContract {
    interface View extends MvpView{
        void showProgress();
        void hideProgress();
        void refreshUi(List<BaseBean> data);
    }

    abstract class Presenter extends MvpPresenter{
        protected View view;
        public Presenter(View view) {
            this.view = view;
            start();
        }

        protected abstract void refreshData();
    }
}
