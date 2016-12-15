package com.cleanandroiddemo.domain.usecase;

import android.util.Log;

import com.cleanandroiddemo.data.repository.CategoriesRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public class GetCategories extends  UseCase{

    private final CategoriesRepository categoriesRepository;

   @Inject
   public GetCategories(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    protected Observable buildObservableUseCase() {
        Log.e("GetCategories UseCase","In buildObservableUseCase Method");
        return categoriesRepository.categoriesList();
    }
}
