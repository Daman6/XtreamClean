package com.example.innobuzztask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innobuzztask.repo.DataRepo
import com.example.innobuzztask.utils.Resource
import com.example.xtreamclean.model.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class DataViewModel(val repo: DataRepo):ViewModel() {

    val getData : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

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

}