package com.shortvideo.ObserverData;

import com.google.gson.JsonObject;

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
        System.out.println(jsonObject);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
