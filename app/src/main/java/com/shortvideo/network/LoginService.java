package com.shortvideo.network;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/12 20:59
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public interface LoginService {

    @POST("user/login")
    Observable<JsonObject> login(@Body JsonObject string);

    @POST("user/register")
    Observable<JsonObject> register(@Body JsonObject string);
}
