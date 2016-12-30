package com.example.administrator.fuckgank.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.adapter.PicturePagerAdapter;
import com.example.administrator.fuckgank.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShowExcitingActivity extends BaseActivity {

    private static final String EXTRA_URLS = "urls";
    private static final String EXTRA_INDEX = "index";

    @BindView(R.id.pager)
    ViewPager pager;

    private List<String> urls;
    private int index;
    private PagerAdapter adapter;


    public static void start(Activity activity, ArrayList<String> urls, int index) {
        Intent intent = new Intent(activity, ShowExcitingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_INDEX, index);
        bundle.putStringArrayList(EXTRA_URLS, urls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_exciting;
    }

    @Override
    protected void init() {
        Bundle bundle = getIntent().getExtras();
        index = bundle.getInt(EXTRA_INDEX);
        urls = bundle.getStringArrayList(EXTRA_URLS);

        adapter = new PicturePagerAdapter(index, this, urls);
        pager.setAdapter(adapter);
        pager.setCurrentItem(index);

        hideSystemUI();

        pager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                hideSystemUI();
            }
        });




    }


    private void hideSystemUI(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_IMMERSIVE);
    }


}
