package com.shortvideo.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.blankj.utilcode.util.ActivityUtils;
import com.shortvideo.ui.LoginActivity;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.RegexUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @Author: xu xiao wei
 * @Date: 22/10/19 019 17:27:41
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class RegisterViewModel extends BaseViewModel<BaseModel> {

    //用户账号绑定数据
    public ObservableField<String> account = new ObservableField<>();
    //用户密码绑定数据
    public ObservableField<String> password = new ObservableField<>();

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 注册点击时间
     */
    public BindingCommand<String> registerClickCommand = new BindingCommand<>(() -> {
        if (TextUtils.isEmpty(account.get())){
            ToastUtils.showLong("账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password.get())){
            ToastUtils.showLong("密码不能为空");
            return;
        }
        if (!RegexUtils.isMobileSimple(account.get())){
            com.blankj.utilcode.util.ToastUtils.showLong("账号格式不对，请填写正确手机号");
            return;
        }
    });

    /**
     * 前往登陆界面
     */
    public BindingCommand<String> toLoginCommand = new BindingCommand<>(() ->{
        ActivityUtils.startActivity(LoginActivity.class);
    });
}
