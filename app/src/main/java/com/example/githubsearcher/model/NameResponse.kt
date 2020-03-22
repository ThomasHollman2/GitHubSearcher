package com.example.githubsearcher.model

data class NameResponse(
    val login : String,
    val avatar_url : String,
    val email : String = "email N/A",
    val location : String,
    val created_at : String,
    val followers : Int,
    val following : Int,
    val bio : String,
    val html_url : String,
    val repos_url : String
)