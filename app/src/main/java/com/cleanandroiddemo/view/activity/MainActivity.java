package com.cleanandroiddemo.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cleanandroiddemo.R;
import com.cleanandroiddemo.view.fragment.CategoryFragment;

public class MainActivity extends AppCompatActivity{



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
