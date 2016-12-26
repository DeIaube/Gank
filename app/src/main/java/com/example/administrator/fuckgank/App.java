package com.example.administrator.fuckgank;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/12/25 0025.
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

}
