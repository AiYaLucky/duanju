package com.shortvideo.ui;

import android.os.Bundle;

import com.shortvideo.BR;
import com.shortvideo.R;
import com.shortvideo.databinding.ActivityRegisterBinding;
import com.shortvideo.viewmodel.RegisterViewModel;

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