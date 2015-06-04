package org.yooranchen.photoframeutil;

import android.app.Application;

import org.yooranchen.photoframeutil.volleyuitl.VolleyUtil;

/**
 * Created by ${ChenShaoWu} on 2015/6/4.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtil.initCommVolley(getApplicationContext());
    }
}
