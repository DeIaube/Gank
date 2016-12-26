package com.example.administrator.fuckgank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.fuckgank.util.LogUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/25 0025.
 */

public abstract class BaseFragment extends Fragment {

    protected View rootView;
    public static String TAG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        TAG = getClass().getSimpleName();
        init();
        return rootView;
    }

    protected void i(String data){
        LogUtil.i(TAG, data);
    }

    protected void toast(String data){
        Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
    }

    protected  abstract int getLayoutId();
    protected  abstract void init();
}
