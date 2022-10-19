package com.shortvideo.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.JsonObject;
import com.shortvideo.network.LoginRequest;
import com.shortvideo.requestData.ServerBack;
import com.shortvideo.ui.HomeActivity;
import com.shortvideo.ui.RegisterActivity;
import com.shortvideo.utils.RetrofitClient;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.RegexUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/11 22:25
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class LoginViewModel extends BaseViewModel<BaseModel> implements Callback<JsonObject> {
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
        if (TextUtils.isEmpty(account.get())) {
            ToastUtils.showLong("账号不能为空哦！~");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.showLong("密码不能为空哦！~");
            return;
        }
        if (!RegexUtils.isMobileSimple(account.get())) {
            com.blankj.utilcode.util.ToastUtils.showLong("账号格式不对，请填写正确手机号！");
            return;
        }
        LoginRequest loginRequest = RetrofitClient.getInstance().create(LoginRequest.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("account", account.get());
        jsonObject.addProperty("password", password.get());
        loginRequest.login(jsonObject).enqueue(this);
    });

    /**
     * 前往注册界面
     */
    public BindingCommand<String> toRegisterCommand = new BindingCommand<>(() -> {
        ActivityUtils.startActivity(RegisterActivity.class);
    });

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        ServerBack serverBack = GsonUtils.fromJson(String.valueOf(response.body()), ServerBack.class);

        System.out.println(response.body());
        //登陆成功，跳转到主页
        ActivityUtils.startActivity(HomeActivity.class);
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        System.out.println(t);
    }
}
