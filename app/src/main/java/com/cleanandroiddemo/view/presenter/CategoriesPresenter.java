package com.cleanandroiddemo.view.presenter;

import android.util.Log;

import com.cleanandroiddemo.domain.model.Category;
import com.cleanandroiddemo.domain.usecase.DefaultSubscriber;
import com.cleanandroiddemo.domain.usecase.GetCategories;
import com.cleanandroiddemo.view.fragment.CategoryFragmentView;
import com.cleanandroiddemo.view.model.CategoryViewModel;
import com.cleanandroiddemo.view.model.CategoryViewModelToCategoryMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public class CategoriesPresenter implements Presenter {

    private GetCategories getCategories;
    private CategoryFragmentView categoryFragmentView;
    private CategoryViewModelToCategoryMapper mapper;

    @Inject public CategoriesPresenter(GetCategories getCategories, CategoryViewModelToCategoryMapper categoryViewModelToCategoryMapper) {
        this.getCategories = getCategories;
        mapper = categoryViewModelToCategoryMapper;
    }

    @Override
    public void initialize(CategoryFragmentView view) {
        Log.e("Categories Presenter", "In initialize Method");
        categoryFragmentView = view;
        getCategories.execute(new CategoriesListSubscriber());
    }

    public void destroy() {
        getCategories.unsubscribe();
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
            List<CategoryViewModel> categoryViewModelList = mapper.reverseMap(categories);
            Log.e("Categories Presenter", categoryViewModelList.size()+"");
            categoryFragmentView.showCategories(categoryViewModelList);

        }
    }
}
