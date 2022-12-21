package com.example.innobuzztask.api

import com.example.xtreamclean.model.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface dataApi {

//    @FormUrlEncoded

    @Headers("Content-Type: application/json")
    @GET("/corephp/xstream-services/api/verify_login/?email=admin@admin.com&password=admin@123")
    suspend fun getData():Response<LoginResponse>
}