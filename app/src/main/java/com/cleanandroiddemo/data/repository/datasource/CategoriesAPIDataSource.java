package com.cleanandroiddemo.data.repository.datasource;

import android.util.Log;

import com.cleanandroiddemo.data.entity.CategoryEntity;
import com.cleanandroiddemo.data.rest.APIService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public class CategoriesAPIDataSource implements DataSource {


    private final APIService apiService;

    @Inject  public CategoriesAPIDataSource(APIService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<CategoryEntity>> categoryEntityList() {
        Log.e("CategoriesAPIDataSource", "In categoryEntityList Method");
        return this.apiService.categoriesEntityList();
    }

}
