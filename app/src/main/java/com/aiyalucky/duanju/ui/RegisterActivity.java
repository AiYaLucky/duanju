package com.aiyalucky.duanju.ui;

import android.os.Bundle;

import com.aiyalucky.duanju.BR;
import com.aiyalucky.duanju.R;
import com.aiyalucky.duanju.databinding.ActivityRegisterBinding;
import com.aiyalucky.duanju.viewmodel.RegisterViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;


public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_register;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}