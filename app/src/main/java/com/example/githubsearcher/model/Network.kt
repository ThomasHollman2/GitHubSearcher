package com.example.githubsearcher.model

import android.util.Log
import com.example.githubsearcher.viewmodel.Screen1ViewModel
import com.example.githubsearcher.viewmodel.Screen2ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class Network( ) {
    private val TAG = Network::class.java.simpleName


    fun initRetrofitScreen1(viewModel1: Screen1ViewModel,query: String, baseUrl: String){
        Log.d(TAG, "initRetrofitScreen1")
        getApi(baseUrl).getUsers(query).enqueue(object : Callback<SearchResponse>{
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.d(TAG, "onFailure")
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                Log.d(TAG, "onResponse")
                response.body()?.let { viewModel1.setSearchData(it) }
            }
        })
    }

    fun initRetrofitScreen2(viewModel2: Screen2ViewModel, login: String, baseUrl: String){
        Log.d(TAG, "initRetrofitScreen2")
        getApi(baseUrl).getUser(login).enqueue(object : Callback<NameResponse>{
            override fun onFailure(call: Call<NameResponse>, t: Throwable) {
                Log.d(TAG, "onFailure2")
            }

            override fun onResponse(
                call: Call<NameResponse>,
                response: retrofit2.Response<NameResponse>) {
                Log.d(TAG, "onResponse2")
                response.body()?.let { viewModel2.setNameData(it) }
            }

        })
        getApi(baseUrl).getRepos(login, "repos").enqueue(
            object : Callback<List<ReposResponse>>{
                override fun onFailure(call: Call<List<ReposResponse>>, t: Throwable) {
                    Log.e("Network", "Error in connecting")
                }

                override fun onResponse(
                    call: Call<List<ReposResponse>>,
                    response: retrofit2.Response<List<ReposResponse>>
                ) {
                    response.body()?.let { viewModel2.setRepoData(it) }
                }
            }
        )

    }



    fun getApi(url: String): GitHubApi {

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build().create(GitHubApi::class.java)
    }
}