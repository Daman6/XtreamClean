package com.example.innobuzztask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innobuzztask.repo.DataRepo
import com.example.innobuzztask.utils.Resource
import com.example.xtreamclean.model.LoginResponse
import com.example.xtreamclean.model.LogoutResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class DataViewModel(val repo: DataRepo):ViewModel() {

    val getData : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

    val logoutUser : MutableLiveData<Resource<LogoutResponse>> = MutableLiveData()

//    init {
//    }

    fun getDataResponse(email:String,password:String) =viewModelScope.launch {
        getData.postValue(Resource.Loading())
        val response = repo.getAllData(email, password)
        getData.postValue(handleGetNetworkResponse(response))
    }

    private fun handleGetNetworkResponse(response: Response<LoginResponse>) : Resource<LoginResponse>{
        if (response.isSuccessful){
            response.body()?.let {networkResponse ->
                return Resource.Success(networkResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun logoutUserDataResponse(id:String) =viewModelScope.launch {
        logoutUser.postValue(Resource.Loading())
        val response = repo.logoutUser(id)
        logoutUser.postValue(handleLogoutUserResponse(response))
    }

    private fun handleLogoutUserResponse(response: Response<LogoutResponse>) : Resource<LogoutResponse>{
        if (response.isSuccessful){
            response.body()?.let {networkResponse ->
                return Resource.Success(networkResponse)
            }
        }
        return Resource.Error(response.message())
    }

}