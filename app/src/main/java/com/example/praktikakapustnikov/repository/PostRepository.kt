package com.example.praktikakapustnikov.repository

import androidx.lifecycle.LiveData
import com.example.praktikakapustnikov.dto.Post

interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun shareById(id: Long)
    fun save(post: Post)
    fun removeById(id: Long)
}