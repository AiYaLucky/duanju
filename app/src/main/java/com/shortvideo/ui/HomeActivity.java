package com.shortvideo.ui;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shortvideo.BR;
import com.shortvideo.R;
import com.shortvideo.databinding.ActivityHomeBinding;
import com.shortvideo.viewmodel.HomeViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelected);
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public HomeViewModel initViewModel() {
        return ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelected = item -> {
        switch (item.getItemId()) {
            case R.id.home:
                System.out.println(1);
                return true;
            case R.id.favorite:
                System.out.println(2);
                return true;
            case R.id.mine:
                System.out.println(3);
                return true;
        }
        return false;
    };
}