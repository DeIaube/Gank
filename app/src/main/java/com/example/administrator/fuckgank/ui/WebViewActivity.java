package com.example.administrator.fuckgank.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class WebViewActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private static final String EXTRA_URL = "url";
    private static final String EXTRA_TITLE = "title";

    private String title;
    private String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    public static void start(Activity activity, String url, String title){
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_URL, url);
        activity.startActivity(intent);
    }

    @Override
    protected void init() {
        if(getIntent() != null){
            title = getIntent().getStringExtra(EXTRA_TITLE);
            url = getIntent().getStringExtra(EXTRA_URL);
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        refreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark);
        refreshLayout.setOnRefreshListener(this);

        initWebView();
        setTitle(title);
        webview.loadUrl(url);
    }

    private void initWebView() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                refreshLayout.setRefreshing(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                refreshLayout.setRefreshing(false);
            }
        });

        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress >= 80){
                    refreshLayout.setRefreshing(false);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void onRefresh() {
        webview.reload();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
