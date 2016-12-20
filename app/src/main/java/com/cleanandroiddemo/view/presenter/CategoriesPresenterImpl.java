package com.cleanandroiddemo.view.presenter;

import android.os.Handler;
import android.util.Log;

import com.cleanandroiddemo.domain.model.Category;
import com.cleanandroiddemo.domain.usecase.DefaultSubscriber;
import com.cleanandroiddemo.domain.usecase.GetCategories;
import com.cleanandroiddemo.view.base.Presenter;
import com.cleanandroiddemo.view.fragment.CategoryFragmentView;
import com.cleanandroiddemo.view.model.CategoryViewModel;
import com.cleanandroiddemo.view.model.CategoryViewModelToCategoryMapper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public class CategoriesPresenterImpl implements CategoryPresenter {

    private GetCategories getCategories;
    private CategoryFragmentView categoryFragmentView;
    private CategoryViewModelToCategoryMapper mapper;

    @Inject @Singleton public CategoriesPresenterImpl(GetCategories getCategories, CategoryViewModelToCategoryMapper categoryViewModelToCategoryMapper) {
        this.getCategories = getCategories;
        mapper = categoryViewModelToCategoryMapper;
    }

    @Override
    public void initialize(CategoryFragmentView view) {
        Log.e("Categories Presenter", "In initialize Method");
        categoryFragmentView = view;
    }

    @Override
    public void getCategoriesList() {
        categoryFragmentView.showLoading();
        getCategories.execute(new CategoriesListSubscriber());
    }

    @Override
    public void onDestroy() {
        getCategories.unsubscribe();
        categoryFragmentView =null;
    }


    private class CategoriesListSubscriber extends DefaultSubscriber<List<Category>> {
        @Override
        public void onCompleted() {
        categoryFragmentView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            categoryFragmentView.hideLoading();
        }

        @Override
        public void onNext(List<Category> categories) {
            super.onNext(categories);

            if(categoryFragmentView!=null) {
                List<CategoryViewModel> categoryViewModelList = mapper.reverseMap(categories);
                Log.e("Categories Presenter", categoryViewModelList.size() + "");
                categoryFragmentView.showCategories(categoryViewModelList);
            }
        }
    }
}