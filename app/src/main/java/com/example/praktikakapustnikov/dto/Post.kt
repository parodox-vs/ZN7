package com.example.praktikakapustnikov.dto

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 1,
    val likedByMe: Boolean = false,
    var shares: Int = 0,
    val sharedByMe: Boolean = false
)
