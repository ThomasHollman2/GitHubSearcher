package com.example.githubsearcher.model

data class SearchResponse(var items: List<searchItems>)

data class searchItems(
    var login: String,
    var avatar_url: String
)