package com.cleanandroiddemo.view.model;

import com.cleanandroiddemo.data.repository.datasource.Mapper;
import com.cleanandroiddemo.domain.model.Category;

import javax.inject.Inject;

/**
 * Created by Avdhesh AKhani on 12/14/2016.
 */

public class CategoryViewModelToCategoryMapper extends Mapper<CategoryViewModel,Category>{


    @Inject public CategoryViewModelToCategoryMapper() {}

    @Override
    public CategoryViewModel reverseMap(Category value) {
        CategoryViewModel categoryViewModel = new CategoryViewModel();
        categoryViewModel.setId(value.getId());
        categoryViewModel.setName(value.getName());
        categoryViewModel.setImageUrl(value.getImageUrl());
        categoryViewModel.setParentId(value.getParentId());
        categoryViewModel.setHasChild(value.getHasChild());
        categoryViewModel.setAltName(value.getAltName());


        return categoryViewModel;
    }
}
