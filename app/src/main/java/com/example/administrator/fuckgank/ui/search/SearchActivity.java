package com.example.administrator.fuckgank.ui.search;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.adapter.GankTodayListAdapter;
import com.example.administrator.fuckgank.base.BaseActivity;
import com.example.administrator.fuckgank.bean.BaseBean;
import com.example.administrator.fuckgank.ui.WebViewActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class SearchActivity extends BaseActivity implements SearchContract.View, GankTodayListAdapter.OnItemClickListener {
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.empty_view)
    TextView emptyView;

    GankTodayListAdapter adapter;

    ProgressDialog progressDialog;

    private SearchContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initSearchView();
        initRecyclerView();

        presenter = new SearchPresenter(this);
    }

    private void initRecyclerView() {
        adapter = new GankTodayListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.setOnItemClickListener(this);
    }

    private void initSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                emptyView.setVisibility(View.GONE);
                presenter.search(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public static void start(Activity activity){
        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void showProgress() {
        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("查找中,请稍后...");
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if(progressDialog != null){
            progressDialog.hide();
        }
    }

    @Override
    public void refreshUi(List<BaseBean> data) {
        adapter.refresh(data);
        if(data.isEmpty()){
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClickNormalItem(View view, BaseBean item) {
        WebViewActivity.start(this, item.getUrl(), item.getDesc());
    }
}
