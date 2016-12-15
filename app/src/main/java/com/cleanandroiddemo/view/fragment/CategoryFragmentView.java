package com.cleanandroiddemo.view.fragment;

import com.cleanandroiddemo.view.model.CategoryViewModel;

import java.util.List;

/**
 * Created by Avdhesh AKhani on 12/14/2016.
 */

public interface CategoryFragmentView {

    void showCategories(List<CategoryViewModel> categoriesList);
    void showLoading();
    void hideLoading();

}
