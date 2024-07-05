package com.mint.newsapp.data.model

data class Article(
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: Int,
    val author: String,
    val publishedAt: String
)