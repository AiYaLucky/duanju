package com.shortvideo.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;

import androidx.databinding.ObservableField;


import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/11 22:25
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class LoginViewModel extends BaseViewModel {
    //用户账号绑定数据
    public ObservableField<String> account = new ObservableField<>();
    //用户密码绑定数据
    public ObservableField<String> password = new ObservableField<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 登录按钮
     * BindingCommand自定义点击事件绑定，有防抖动功能
     */
    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            System.out.println(account.get());
        }
    });

    public View.OnClickListener loginOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println(account.get());
        }
    };
}
