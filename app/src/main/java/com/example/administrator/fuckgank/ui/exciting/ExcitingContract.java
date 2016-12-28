package com.example.administrator.fuckgank.ui.exciting;

import com.example.administrator.fuckgank.base.MvpPresenter;
import com.example.administrator.fuckgank.base.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public interface ExcitingContract {
    interface View extends MvpView{
        void showProgress();
        void hideProgress();
        void refreshUi(List<String> urls);
        void loadMoreUi(List<String> urls);
    }

    abstract class Presenter extends MvpPresenter {
        protected ExcitingContract.View view;

        public Presenter(ExcitingContract.View view) {
            this.view = view;
            start();
        }

        protected abstract void loadMore();
        protected abstract void refresh();
    }
}
