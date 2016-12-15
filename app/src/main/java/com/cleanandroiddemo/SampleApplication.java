package com.cleanandroiddemo;

import android.app.Application;

import com.cleanandroiddemo.di.components.DaggerMainComponent;
import com.cleanandroiddemo.di.components.MainComponent;
import com.cleanandroiddemo.di.modules.MainModule;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public class SampleApplication extends Application {

    private MainComponent mainComponent;

    @Override public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
