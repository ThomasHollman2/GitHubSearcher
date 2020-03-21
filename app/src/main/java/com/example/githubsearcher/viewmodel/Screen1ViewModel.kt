package com.example.githubsearcher.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearcher.model.Network
import com.example.githubsearcher.model.SearchResponse
import com.example.githubsearcher.view.Screen1Adapter

class Screen1ViewModel(val baseUrl: String): ViewModel() {
    private val TAG = Screen1ViewModel::class.java.simpleName
    private val searchDataSet: MutableLiveData<SearchResponse> = MutableLiveData()

    fun setSearchData(dataset: SearchResponse){
        Log.d(TAG, "setSearchData")
        this.searchDataSet.value = dataset

    }
    fun searchBar(query: String){
        Log.d(TAG, "searchBar: " + query)
        val network = Network(this)
        network.initRetrofit(query,baseUrl)

    }
    fun getSearchData(): LiveData<SearchResponse>{
        Log.d(TAG, "getSearchData")
        return searchDataSet
    }
}