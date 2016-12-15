package com.cleanandroiddemo.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.cleanandroiddemo.databinding.RowLayoutCategoryBinding;
import com.cleanandroiddemo.view.model.CategoryViewModel;

/**
 * Created by Avdhesh AKhani on 12/13/2016.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private RowLayoutCategoryBinding binding;

    public CategoryViewHolder(RowLayoutCategoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindCategory(CategoryViewModel category){
        binding.setCategory(category);
        binding.executePendingBindings();
    }
}
