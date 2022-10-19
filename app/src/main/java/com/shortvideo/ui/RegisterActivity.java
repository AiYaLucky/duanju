package com.shortvideo.ui;

import android.os.Bundle;

import androidx.databinding.ObservableField;

import com.shortvideo.BR;
import com.shortvideo.R;
import com.shortvideo.databinding.ActivityRegisterBinding;
import com.shortvideo.viewmodel.RegisterViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> {
    //注册账号绑定数据
    public ObservableField<String> account = new ObservableField<>();
    //注册密码绑定数据
    public ObservableField<String> password = new ObservableField<>();
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_register;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}