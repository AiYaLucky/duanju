package com.shortvideo.ui;


import android.os.Bundle;

import com.shortvideo.BR;
import com.shortvideo.R;
import com.shortvideo.databinding.ActivityLoginBinding;
import com.shortvideo.viewmodel.LoginViewModel;

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
}