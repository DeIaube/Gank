package com.example.administrator.fuckgank.ui.today;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.adapter.GankListAdapter;
import com.example.administrator.fuckgank.base.BaseFragment;
import com.example.administrator.fuckgank.bean.BaseBean;
import com.example.administrator.fuckgank.ui.WebViewActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class TodayFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, TodyContract.View, GankListAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    GankListAdapter adapter;

    TodyContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_refresh_recycler;
    }

    @Override
    protected void init() {
        refreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark);
        refreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        adapter = new GankListAdapter(getActivity());
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        presenter = new TodayPresenter(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }


    public static TodayFragment newInstance(){
        return new TodayFragment();
    }

    @Override
    public void onRefresh() {
        presenter.refreshData();
    }

    @Override
    public void showProgress() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void refreshUi(List<BaseBean> data) {
        adapter.refresh(data);
    }

    @Override
    public void onClickNormalItem(View view, BaseBean item) {
        WebViewActivity.start(getActivity(), item.getUrl(), item.getDesc());
    }
}
