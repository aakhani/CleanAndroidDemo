package com.cleanandroiddemo.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cleanandroiddemo.R;
import com.cleanandroiddemo.databinding.RowLayoutCategoryBinding;
import com.cleanandroiddemo.view.model.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avdhesh AKhani on 12/13/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<CategoryViewModel> categoryList;

    public CategoryAdapter() { categoryList = new ArrayList<>(); }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowLayoutCategoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_layout_category, parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        CategoryViewModel category = categoryList.get(position);
        holder.bindCategory(category);
    }


    @Override
    public int getItemCount() {
        return this.categoryList.size();
    }

    public void addAll(List<CategoryViewModel> list) {
        categoryList.addAll(list);
    }


}
