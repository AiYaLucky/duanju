package com.aiyalucky.duanju.ui;


import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.aiyalucky.duanju.BR;
import com.aiyalucky.duanju.R;
import com.aiyalucky.duanju.databinding.ActivityLoginBinding;
import com.aiyalucky.duanju.viewmodel.LoginViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public LoginViewModel initViewModel() {
        //View持有ViewModel的引用，如果没有特殊业务处理，这个方法可以不重写
        return ViewModelProviders.of(this).get(LoginViewModel.class);
    }
}