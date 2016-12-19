package com.cleanandroiddemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cleanandroiddemo.R;
import com.cleanandroiddemo.SampleApplication;
import com.cleanandroiddemo.view.adapter.CategoryAdapter;
import com.cleanandroiddemo.view.model.CategoryViewModel;
import com.cleanandroiddemo.view.presenter.CategoriesPresenterImpl;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Avdhesh AKhani on 12/14/2016.
 */

public class CategoryFragment extends Fragment implements CategoryFragmentView {

    @Inject
    CategoriesPresenterImpl categoriesPresenter;
    CategoryAdapter categoryAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_category)
    ProgressBar categoryProgressBar;

    public static CategoryFragment newInstance(){ return new CategoryFragment();}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category,container, false);
        setRetainInstance(true);
        ButterKnife.bind(this,view);
        initView();

        categoriesPresenter.getCategoriesList();

        return view;
    }

    private void initView() {
        initializeDagger();
        initializePresenter();
        initializeAdapter();
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(categoryAdapter);
    }

    private void initializeAdapter() { categoryAdapter = new CategoryAdapter();}

    public void initializeDagger() {
        SampleApplication application = (SampleApplication) getActivity().getApplication();
        application.getMainComponent().inject(this);
    }

    private void initializePresenter() {categoriesPresenter.initialize(this);}


    @Override
    public void showCategories(List<CategoryViewModel> categoriesList) {
        Log.e("CategoryFragment",categoriesList.size()+"");
        categoryAdapter.addAll(categoriesList);
        categoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        categoryProgressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        categoryProgressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        categoriesPresenter.destroy();
    }
}
