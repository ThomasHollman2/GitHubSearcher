package com.example.githubsearcher.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearcher.model.Network
import com.example.githubsearcher.model.SearchResponse

class Screen1ViewModel(val baseUrl: String): ViewModel() {
    private val TAG = Screen1ViewModel::class.java.simpleName
    private val searchDataSet: MutableLiveData<SearchResponse> = MutableLiveData()

    fun setSearchData(dataset: SearchResponse){
        Log.d(TAG, "setSearchData")
        this.searchDataSet.value = dataset

    }
    fun searchBar(query: String){
        Log.d(TAG, "searchBar: " + query)
        val network = Network()
        network.initRetrofitScreen1(this, query,baseUrl)


    }
    fun getSearchData(): LiveData<SearchResponse>{
        Log.d(TAG, "getSearchData")
        return searchDataSet
    }
}