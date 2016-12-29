package com.example.administrator.fuckgank.ui;

import android.widget.ImageView;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class ShowPictureActivity extends BaseActivity {

    @BindView(R.id.picture)
    ImageView picture;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_picture;
    }

    @Override
    protected void init() {

    }

}
