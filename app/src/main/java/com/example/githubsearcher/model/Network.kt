package com.example.githubsearcher.model

import android.util.Log
import com.example.githubsearcher.view.Screen1Adapter
import com.example.githubsearcher.viewmodel.Screen1ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network(val viewModel: Screen1ViewModel) {
    private val TAG = Network::class.java.simpleName
    fun initRetrofit(query: String, baseUrl: String){
        Log.d(TAG, "initRetrofit")
        getApi(baseUrl).getUsers(query).enqueue(object : Callback<SearchResponse>{
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.d(TAG, "onFailure")
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                Log.d(TAG, "onRespone")
                response.body()?.let { viewModel.setSearchData(it) }
            }

        })

    }
    fun getApi(url: String): GitHubApi {

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build().create(GitHubApi::class.java)
    }
}