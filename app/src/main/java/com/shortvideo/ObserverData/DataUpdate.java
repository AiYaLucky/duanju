package com.shortvideo.ObserverData;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.JsonObject;
import com.shortvideo.requestData.ServerBack;
import com.shortvideo.ui.HomeActivity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/12 22:15
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class DataUpdate implements Observer<JsonObject> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(JsonObject jsonObject) {
        ServerBack serverBack = GsonUtils.fromJson(String.valueOf(jsonObject), ServerBack.class);
        if (serverBack.getCode() == 1){
            return;
        }
        ActivityUtils.startActivity(HomeActivity.class);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        System.out.println(123);
    }
}
