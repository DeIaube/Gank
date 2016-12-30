package com.example.administrator.fuckgank.ui.exciting;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.adapter.ExcitingPictureAdapter;
import com.example.administrator.fuckgank.base.BaseFragment;
import com.example.administrator.fuckgank.ui.ShowExcitingActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class ExcitingFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, ExcitingContract.View, ExcitingPictureAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private LinearLayoutManager mLayoutManager;
    private ExcitingPictureAdapter adapter;

    private boolean mLoadingMore;

    private ExcitingContract.Presenter presenter;


    public static ExcitingFragment newInstance(){
        ExcitingFragment fragment = new ExcitingFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_refresh_recycler;
    }

    @Override
    protected void init() {
        refreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark);
        refreshLayout.setOnRefreshListener(this);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);
        mLayoutManager = ((LinearLayoutManager)recyclerView.getLayoutManager());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                boolean reachBottom = mLayoutManager.findLastCompletelyVisibleItemPosition()
                        >= mLayoutManager.getItemCount() - 2;

                if(newState == RecyclerView.SCROLL_STATE_IDLE && !mLoadingMore && reachBottom) {
                    mLoadingMore = true;
                    loadMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean reachBottom = mLayoutManager.findLastCompletelyVisibleItemPosition()
                        >= mLayoutManager.getItemCount() - 2;
                if(!mLoadingMore && reachBottom) {
                    mLoadingMore = true;
                    loadMore();
                }
            }
        });


        adapter = new ExcitingPictureAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        presenter = new ExcitingPresenter(this);
    }


    private void loadMore() {
        presenter.loadMore();
    }

    @Override
    public void onRefresh() {
        presenter.refresh();
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
    public void refreshUi(List<String> urls) {
        adapter.refresh(urls);
    }

    @Override
    public void loadMoreUi(List<String> urls) {
        adapter.loadMore(urls);
    }

    @Override
    public void onClickExcitingItem(View view, List<String> urls, int index) {
        ShowExcitingActivity.start(getActivity(), (ArrayList<String>) urls, index);
    }
}
