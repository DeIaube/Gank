package com.example.administrator.fuckgank.ui.category;

import com.example.administrator.fuckgank.base.MvpPresenter;
import com.example.administrator.fuckgank.base.MvpView;
import com.example.administrator.fuckgank.bean.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public interface CategoryContract {
    interface View extends MvpView{
        void showProgress();
        void hideProgress();
        void refreshUi(List<BaseBean> data);
        void loadMoreUi(List<BaseBean> data);
    }

    abstract class Presenter extends MvpPresenter{
        protected CategoryContract.View view;

        public Presenter(View view) {
            this.view = view;
            start();
        }

        protected abstract void loadMore(String category);
        protected abstract void refresh(String category);
    }

}
