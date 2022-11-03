package com.aiyalucky.duanju.ui;

import android.os.Bundle;

import com.aiyalucky.duanju.BR;
import com.aiyalucky.duanju.R;
import com.aiyalucky.duanju.databinding.ActivityHomeBinding;
import com.aiyalucky.duanju.viewmodel.HomeViewModel;

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