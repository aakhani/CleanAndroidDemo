package com.cleanandroiddemo.data.rest;

import android.util.Log;

import com.cleanandroiddemo.data.entity.CategoryEntity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public class APIService implements CategoriesAPI {

    private static final String BASE_URL = "http://app-api.offers.net";
    private CategoriesAPI categoriesAPI;
    private static Retrofit retrofit = null;

   @Inject
   public APIService() {
       if (retrofit==null) {
           retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                   .build();
       }

        categoriesAPI = retrofit.create(CategoriesAPI.class);
    }

    @Override
    public Observable<List<CategoryEntity>> categoriesEntityList() {
        Log.e("APIService", "In categoriesEntityList Method");
        Observable<List<CategoryEntity>> categoryEntityList = categoriesAPI.categoriesEntityList();
      return categoryEntityList;

    }

}
