package com.example.administrator.fuckgank.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.fuckgank.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/25 0025.
 */

public abstract class BaseListFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_refresh_recycler;
    }



}
