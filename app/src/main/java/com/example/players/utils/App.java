package com.example.players.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by samsung on 2017/12/20.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();

        ImageLoader.getInstance().init(configuration);


    }
}
