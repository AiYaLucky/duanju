package com.shortvideo.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import androidx.databinding.ObservableField;


import com.google.gson.JsonObject;

import com.shortvideo.ObserverData.DataUpdate;
import com.shortvideo.network.LoginService;
import com.shortvideo.utils.RetrofitClient;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.RegexUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/11 22:25
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class LoginViewModel extends BaseViewModel<BaseModel> {
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
    public BindingCommand<String> loginOnClickCommand = new BindingCommand<>(() -> {
        if (TextUtils.isEmpty(account.get())){
            ToastUtils.showLong("账号不能为空哦！~");
            return;
        }
        if (TextUtils.isEmpty(password.get())){
            ToastUtils.showLong("密码不能为空哦！~");
            return;
        }
        if (!RegexUtils.isMobileSimple(account.get())){
            com.blankj.utilcode.util.ToastUtils.showLong("账号格式不对，需要手机号！");
            return;
        }
        LoginService loginService = RetrofitClient.getInstance().create(LoginService.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("account", account.get());
        jsonObject.addProperty("password", password.get());
        JsonObject execute = RetrofitClient.execute(loginService.login(jsonObject), new DataUpdate());
        System.out.println(123);
    });
}
