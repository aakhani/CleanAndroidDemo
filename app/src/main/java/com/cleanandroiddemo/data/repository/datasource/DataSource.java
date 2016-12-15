package com.cleanandroiddemo.data.repository.datasource;

import com.cleanandroiddemo.data.entity.CategoryEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public interface DataSource {

    /**
     * Get an 'Observable<List<CategoryEntity>>'  which will emit a List of {@link CategoryEntity}.
     */
    Observable<List<CategoryEntity>> categoryEntityList();

}
