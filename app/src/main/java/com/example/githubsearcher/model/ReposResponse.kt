package com.example.githubsearcher.model

data class ReposResponse(val name : String,
                         val forks : Int,
                         val stargazers_count : Int,
                         val html_url : String)
