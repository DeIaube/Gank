package com.example.administrator.fuckgank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.fuckgank.util.LogUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/25 0025.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected String tag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        tag = getClass().getSimpleName();
        init();
    }

    protected void i(String data){
        LogUtil.i(tag, data);
    }

    protected void toast(String data){
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    protected void replaceFragment(int containerViewId, Fragment fragment, String tag){
        if(getSupportFragmentManager().findFragmentByTag(tag) == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(containerViewId, fragment, tag)
                    .commit();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void init();

}
