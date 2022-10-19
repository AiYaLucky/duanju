package com.shortvideo.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/12 20:59
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public interface LoginRequest {

    @POST("user/login")
//    Observable<JsonObject> login(@Body JsonObject string);
    Call<JsonObject> login(@Body JsonObject string);


}
