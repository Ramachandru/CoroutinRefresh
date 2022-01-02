package com.ram.kotlincoroutinerefresh.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ram.kotlincoroutinerefresh.model.OrgModel
import com.ram.kotlincoroutinerefresh.model.ServiceClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class OrgViewModel : ViewModel()
{
    private val orgsLiveData : MutableLiveData<MutableList<OrgModel>> by lazy {
        MutableLiveData<MutableList<OrgModel>>().also {
            proceedRequest()
        }
    }
    fun getOrgLiveData() : MutableLiveData<MutableList<OrgModel>> = orgsLiveData

    fun proceedRequest(){
        val apiCall = ServiceClass.getRetrofit()
        viewModelScope.launch(Dispatchers.IO) {
            val OrgsData=apiCall.getOrgsData()
            if(OrgsData.isSuccessful){
                orgsLiveData.postValue(OrgsData.body())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}