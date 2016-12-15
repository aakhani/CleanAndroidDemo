package com.cleanandroiddemo.data.rest;

import com.cleanandroiddemo.data.entity.CategoryEntity;
import retrofit2.http.GET;
import java.util.List;

import rx.Observable;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public interface CategoriesAPI {

    @GET("/categories")
    Observable<List<CategoryEntity>> categoriesEntityList();

}
