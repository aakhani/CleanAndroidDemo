/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

  @Provides
  public DataSource provideDataSource(CategoriesAPIDataSource categoriesAPIDataSource){
    return categoriesAPIDataSource;
  }

}
