package com.cleanandroiddemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cleanandroiddemo.R;
import com.cleanandroiddemo.SampleApplication;
import com.cleanandroiddemo.view.fragment.CategoryFragment;
import com.cleanandroiddemo.view.presenter.CategoriesPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity{


    @Inject CategoriesPresenter categoriesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  //      initializeDagger();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, CategoryFragment.newInstance()).commit();

    }

   /* public void initializeDagger() {
        SampleApplication application = (SampleApplication) getApplication();
        application.getMainComponent().inject(this);
    }
*/
}
