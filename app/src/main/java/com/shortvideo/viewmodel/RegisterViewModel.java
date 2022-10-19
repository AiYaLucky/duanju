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
import com.shortvideo.network.RegisterRequest;
import com.shortvideo.requestData.ServerBack;
import com.shortvideo.ui.HomeActivity;
import com.shortvideo.ui.LoginActivity;
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
 * @Date: 22/10/19 019 17:27:41
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class RegisterViewModel extends BaseViewModel<BaseModel> implements Callback<JsonObject> {

    //用户注册手机
    public ObservableField<String> account = new ObservableField<>();
    //用户注册密码
    public ObservableField<String> password = new ObservableField<>();
    //用户注册手机
    public ObservableField<String> rePassword = new ObservableField<>();
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
        if (!TextUtils.equals(password.get(), rePassword.get())){
            ToastUtils.showLong("两次密码输入不一致");
        }
        if (!RegexUtils.isMobileSimple(account.get())){
            com.blankj.utilcode.util.ToastUtils.showLong("账号格式不对，请填写正确手机号");
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("account", account.get());
        jsonObject.addProperty("password", password.get());
        jsonObject.addProperty("rePassword", rePassword.get());
        jsonObject.addProperty("phone", account.get());
        RegisterRequest registerRequest = RetrofitClient.getInstance().create(RegisterRequest.class);
        registerRequest.register(jsonObject).enqueue(this);
    });

    /**
     * 前往登陆界面
     */
    public BindingCommand<String> toLoginCommand = new BindingCommand<>(() ->{
        ActivityUtils.startActivity(LoginActivity.class);
    });

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        ServerBack serverBack = GsonUtils.fromJson(String.valueOf(response.body()), ServerBack.class);
        if (serverBack.getCode() != 200){
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

    }
}
