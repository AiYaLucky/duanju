package com.aiyalucky.duanju.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author: xu xiao wei
 * @Date: 22/10/19 019 18:08:59
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public interface RegisterRequest {

    @POST("user/register")
//    Observable<JsonObject> register(@Body JsonObject string);
    Call<JsonObject> register(@Body JsonObject string);
}
