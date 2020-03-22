package com.example.githubsearcher.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearcher.model.NameResponse
import com.example.githubsearcher.model.Network
import com.example.githubsearcher.model.ReposResponse
import com.example.githubsearcher.model.SearchResponse

class Screen2ViewModel(val baseUrl: String): ViewModel() {

    private val TAG = Screen2ViewModel::class.java.simpleName
    private val nameDataSet: MutableLiveData<NameResponse> = MutableLiveData()
    private val repoData : MutableLiveData<List<ReposResponse>> = MutableLiveData()

    fun setNameData(dataset: NameResponse){
        Log.d(TAG, "setNameData")
        this.nameDataSet.value = dataset

    }
    fun initUserInfo(login: String){
        Log.d(TAG, "initUserInfo: " + login)
        val network = Network()
        network.initRetrofitScreen2(this,login,baseUrl)


    }
    fun setRepoData(data : List<ReposResponse>){
        this.repoData.value = data
    }
    fun getRepoData() = repoData
    fun getNameData() =
      nameDataSet


}