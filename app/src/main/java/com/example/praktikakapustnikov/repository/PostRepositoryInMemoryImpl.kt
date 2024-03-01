package com.example.praktikakapustnikov.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.praktikakapustnikov.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {
    private var nextId = 1L
    private var posts = listOf(
        Post(
        id = nextId++,
        author = "Бтпит. Учебное заведение",
        content = "Всех студентов поздравляем с 1 сентября!",
        published = "1 сентября в 8:00",
        likedByMe = false,
        sharedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Бтпит. Учебное заведение",
            content = "Всех студентов поздравляем с 2 сентября!",
            published = "2 сентября в 8:00",
            likedByMe = false,
            sharedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Бтпит. Учебное заведение",
            content = "Всех студентов поздравляем с 3 сентября!",
            published = "3 сентября в 8:00",
            likedByMe = false,
            sharedByMe = false
        ),
        Post(
            id = nextId++,
            author = "Бтпит. Учебное заведение",
            content = "Всех студентов поздравляем с 4 сентября!",
            published = "4 сентября в 8:00",
            likedByMe = false,
            sharedByMe = false
        ),
        ).reversed()
    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data

    override fun save(post: Post) {
        if (post.id == 0L) {
            posts = listOf(
                post.copy(
                    id = nextId++,
                    author = "Me",
                    likedByMe = false,
                    sharedByMe = false,
                    published = "now"
                )
            ) + posts
            data.value = posts
            return
        }

        posts = posts.map {
            if (it.id != post.id) it else it.copy(content = post.content)
        }
        data.value = posts
    }

    override fun likeById(id: Long) {
        posts = posts.map{
            if (it.id != id) it else it.copy(likedByMe = !it.likedByMe) }

        data.value = posts
    }
    override fun shareById(id:Long) {
        posts = posts.map{
            if (it.id != id) it else it.copy(sharedByMe = !it.sharedByMe) }
        data.value = posts
    }
    override fun removeById(id: Long) {
        posts = posts.filter { it.id != id }
        data.value = posts
    }
}