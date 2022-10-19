package com.shortvideo.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.JsonObject;
import com.shortvideo.User;
import com.shortvideo.config.SPKEY;
import com.shortvideo.network.LoginRequest;
import com.shortvideo.requestData.ServerBack;
import com.shortvideo.ui.HomeActivity;
import com.shortvideo.ui.RegisterActivity;
import com.shortvideo.utils.RetrofitClient;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.RegexUtils;
import me.goldze.mvvmhabit.utils.SPUtils;
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
    //自动登录状态
    public ObservableField<Boolean> autoLogin = new ObservableField<>(false);

    public LoginViewModel(@NonNull Application application) {
        super(application);
        SPUtils.getInstance("user").put(SPKEY.USER_AUTO_LOGIN.getString(),true);
        if (SPUtils.getInstance("user").getBoolean(SPKEY.USER_AUTO_LOGIN.getString())) {
            autoLogin();
        }
    }

    //自动登录
    private void autoLogin() {
        SPUtils spUser = SPUtils.getInstance("user");
        account.set(spUser.getString(SPKEY.USER_ACCOUNT.getString()));
        password.set(spUser.getString(SPKEY.USER_PASSWORD.getString()));
        this.loginOnClickCommand.execute();
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

        //设置自动登录
        SPUtils.getInstance("user").put(SPKEY.USER_AUTO_LOGIN.getString(), autoLogin.get());
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
        if (serverBack.getCode() != 200) {
            ToastUtils.showLong(serverBack.getDesc());
            return;
        }
        User user = serverBack.dataToJsonObject();
        SPUtils userSp = SPUtils.getInstance("user");
        userSp.put(SPKEY.USER_LOGIN_TIME.getString(), System.currentTimeMillis());
        userSp.put(SPKEY.USER_ACCOUNT.getString(), user.getAccount());
        userSp.put(SPKEY.USER_PASSWORD.getString(), user.getPassword());
        //登陆成功，跳转到主页
        ActivityUtils.startActivity(HomeActivity.class);
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        System.out.println(t);
    }
}
