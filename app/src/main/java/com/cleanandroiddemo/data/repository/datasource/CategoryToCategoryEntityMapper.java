package com.cleanandroiddemo.data.repository.datasource;

import com.cleanandroiddemo.data.entity.CategoryEntity;
import com.cleanandroiddemo.data.repository.datasource.Mapper;
import com.cleanandroiddemo.domain.model.Category;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

@Singleton
public class CategoryToCategoryEntityMapper extends Mapper<Category,CategoryEntity> {

    @Inject
    public CategoryToCategoryEntityMapper() {
    }

    @Override
    public Category reverseMap(CategoryEntity value) {
        Category category = new Category();
        category.setId(value.getId());
        category.setName(value.getName());
        category.setImageUrl(value.getImageUrl());
        category.setParentId(value.getParentId());
        category.setHasChild(value.getHasChild());
        category.setAltName(value.getAltName());

        return category;

    }
}
