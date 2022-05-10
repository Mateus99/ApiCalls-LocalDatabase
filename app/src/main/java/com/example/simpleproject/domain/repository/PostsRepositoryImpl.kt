package com.example.simpleproject.domain.repository

import com.example.simpleproject.model.Post
import com.example.simpleproject.network.RetrofitInstance
import retrofit2.Response

class PostsRepositoryImpl : PostsRepository {
    override suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    override suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    override suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId, sort, order)
    }

    override suspend fun getCustomPosts2(
        userId: Int,
        options: Map<String, String>
    ): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts2(userId, options)
    }

    override suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    override suspend fun pushPost2(
        userId: Int,
        id: Int,
        title: String,
        body: String
    ): Response<Post> {
        return RetrofitInstance.api.pushPost2(userId, id, title, body)
    }
}