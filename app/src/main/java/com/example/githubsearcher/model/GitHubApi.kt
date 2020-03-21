package com.example.githubsearcher.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {
    @GET("search/users")
    fun getUsers(@Query("q")q: String): Call<SearchResponse>

    @GET("users/{userName}")
    fun getUser(@Path("userName")userName: String): Call<NameResponse>

    @GET("users/{userName}/repos")
    fun getRepos(@Path("userName")userName: String): Call<ReposResponse>
}