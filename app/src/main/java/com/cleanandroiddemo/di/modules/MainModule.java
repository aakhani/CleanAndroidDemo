package com.cleanandroiddemo.di.modules;

import android.content.Context;

import com.cleanandroiddemo.SampleApplication;
import com.cleanandroiddemo.data.repository.CategoriesRepository;
import com.cleanandroiddemo.data.repository.Repository;
import com.cleanandroiddemo.data.repository.datasource.CategoriesAPIDataSource;
import com.cleanandroiddemo.data.repository.datasource.DataSource;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module public class MainModule {

  private final SampleApplication sampleApplication;

  public MainModule(SampleApplication sampleApplication) {
    this.sampleApplication = sampleApplication;
  }

  @Provides @Singleton
  public Context provideApplicationContext() {
    return sampleApplication;
  }

  @Provides @Singleton public Repository provideRepository(CategoriesRepository categoriesRepository) {
    return categoriesRepository;
  }


  /*@Provides @Singleton
  public CategoriesPresenterImpl provideCategoriesPresenter(CategoriesPresenterImpl categoriesPresenter){
    return categoriesPresenter;
  }*/
  @Provides
  public DataSource provideDataSource(CategoriesAPIDataSource categoriesAPIDataSource){
    return categoriesAPIDataSource;
  }

}
