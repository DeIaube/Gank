package com.example.administrator.fuckgank.util;

import android.util.Log;

import com.example.administrator.fuckgank.config.Config;


/**
 * Created by Administrator on 2016/12/25 0025.
 */

public class LogUtil {
    public static void i(String tag, String data){
        if(Config.debug){
            Log.d(tag, data);
        }
    }
}
