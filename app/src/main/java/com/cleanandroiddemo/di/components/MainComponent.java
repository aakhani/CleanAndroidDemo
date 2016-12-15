package com.cleanandroiddemo.di.components;

import com.cleanandroiddemo.di.modules.MainModule;
import com.cleanandroiddemo.view.activity.MainActivity;
import com.cleanandroiddemo.view.fragment.CategoryFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = MainModule.class) public interface MainComponent {

  void inject(MainActivity activity);
  void inject(CategoryFragment fragment);

}
