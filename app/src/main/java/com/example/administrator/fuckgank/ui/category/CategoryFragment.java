package com.example.administrator.fuckgank.ui.category;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.adapter.GankCategoryAdapter;
import com.example.administrator.fuckgank.base.BaseFragment;
import com.example.administrator.fuckgank.bean.BaseBean;
import com.example.administrator.fuckgank.ui.WebViewActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class CategoryFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,CategoryContract.View, GankCategoryAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private GankCategoryAdapter adapter;
    private String category;
    private boolean mLoadingMore;
    private CategoryContract.Presenter presenter;
    private LinearLayoutManager mLayoutManager;

    private static final String EXTRA_CATEGORY = "category";

    public static final String Android = "Android";
    public static final String iOS = "iOS";
    public static final String video = "休息视频";
    public static final String front = "前端";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_refresh_recycler;
    }

    public static CategoryFragment newInstance(String category){
        CategoryFragment fragment = new CategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_CATEGORY, category);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void init() {
        refreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark);
        refreshLayout.setOnRefreshListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        mLayoutManager = ((LinearLayoutManager)recyclerView.getLayoutManager());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                boolean reachBottom = mLayoutManager.findLastCompletelyVisibleItemPosition()
                        >= mLayoutManager.getItemCount() - 1;

                if(newState == RecyclerView.SCROLL_STATE_IDLE && !mLoadingMore && reachBottom) {
                    mLoadingMore = true;
                    loadMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean reachBottom = mLayoutManager.findLastCompletelyVisibleItemPosition()
                        >= mLayoutManager.getItemCount() - 1;
                if(!mLoadingMore && reachBottom) {
                    mLoadingMore = true;
                    loadMore();
                }
            }
        });

        adapter = new GankCategoryAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        category = getArguments().getString(EXTRA_CATEGORY);
        presenter = new CategoryPresenter(this);
        onRefresh();
    }



    @Override
    public void onRefresh() {
        presenter.refresh(category);
    }

    private void loadMore() {
        presenter.loadMore(category);
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
    public void loadMoreUi(List<BaseBean> data) {
        mLoadingMore = false;
        adapter.loadMore(data);
    }

    @Override
    public void onClickNormalItem(View view, BaseBean item) {
        WebViewActivity.start(getActivity(), item.getUrl(), item.getDesc());
    }
}
