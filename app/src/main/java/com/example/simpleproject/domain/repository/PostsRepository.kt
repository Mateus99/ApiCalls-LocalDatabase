package com.example.simpleproject.domain.repository

import com.example.simpleproject.model.Post
import retrofit2.Response

interface PostsRepository {
    suspend fun getPost(): Response<Post>

    suspend fun getPost2(number: Int): Response<Post>

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>>

    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<Post>>

    suspend fun pushPost(post: Post): Response<Post>

    suspend fun pushPost2(userId: Int, id: Int, title: String, body: String): Response<Post>
}