package com.cleanandroiddemo.view.presenter;

import com.cleanandroiddemo.view.base.Presenter;
import com.cleanandroiddemo.view.fragment.CategoryFragmentView;

/**
 * Created by Avdhesh AKhani on 12/19/2016.
 */

public interface CategoryPresenter extends Presenter<CategoryFragmentView> {

    void getCategoriesList();
    void onDestroy();
}
