package com.cleanandroiddemo.data.repository;

import android.util.Log;

import com.cleanandroiddemo.data.repository.datasource.CategoryToCategoryEntityMapper;
import com.cleanandroiddemo.data.repository.datasource.DataSource;
import com.cleanandroiddemo.data.entity.CategoryEntity;
import com.cleanandroiddemo.data.rest.APIService;
import com.cleanandroiddemo.domain.model.Category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

@Singleton
public class CategoriesRepository implements Repository {

    //private final DataSource dataSource;
    private final CategoryToCategoryEntityMapper categoryToCategoryEntityMapper;
    private final APIService apiService;

    @Inject
    public CategoriesRepository(CategoryToCategoryEntityMapper categoryToCategoryEntityMapper, APIService apiService) {
    //    this.dataSource = dataSource;

        this.categoryToCategoryEntityMapper = categoryToCategoryEntityMapper;
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Category>> categoriesList() {
        Log.e("CategoriesRepository","In categoriesList Method");
        return apiService.categoriesEntityList().map(new Func1<List<CategoryEntity>, List<Category>>() {
            @Override
            public List<Category> call(List<CategoryEntity> categoryEntities) {
                return categoryToCategoryEntityMapper.reverseMap(categoryEntities);
            }
        });
    }

}
