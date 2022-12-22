package com.example.innobuzztask.api

import com.example.xtreamclean.model.LoginResponse
import com.example.xtreamclean.model.LogoutResponse
import retrofit2.Response
import retrofit2.http.*


interface dataApi {

//    @FormUrlEncoded

    @FormUrlEncoded
    @POST("/corephp/xstream-services/api/verify_login/")
    suspend fun getData(
        @Field("email") email:String,
        @Field("password") password:String,
    ): Response<LoginResponse>


    @FormUrlEncoded
    @POST("/corephp/xstream-services/api/logout/")
    suspend fun logoutUser(
        @Field("id") id:String,
    ): Response<LogoutResponse>
}

