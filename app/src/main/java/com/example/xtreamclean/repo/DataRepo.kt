package com.example.innobuzztask.repo

import androidx.lifecycle.LiveData
import com.example.innobuzztask.api.RetrofitInstance
import retrofit2.Response
import retrofit2.Retrofit

class DataRepo() {

    suspend fun getAllData( )= RetrofitInstance.api.getData()

}
