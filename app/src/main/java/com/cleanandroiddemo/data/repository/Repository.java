package com.cleanandroiddemo.data.repository;

import com.cleanandroiddemo.domain.model.Category;

import java.util.List;

import rx.Observable;

/**
 * Created by Avdhesh AKhani on 12/11/2016.
 */

public interface Repository {

    /**
     * Get an 'Observable<List<Team>>'  which will emit a List of {@link Category}.
     */
    Observable<List<Category>> categoriesList();


}
