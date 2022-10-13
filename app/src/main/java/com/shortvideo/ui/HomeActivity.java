package com.shortvideo.ui;

import android.os.Bundle;

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
    public int initVariableId() {
        return BR.viewModel;
    }
}