package com.example.simpleproject.domain.usecases

import com.example.simpleproject.domain.repository.PostsRepository
import com.example.simpleproject.model.Post
import retrofit2.Response

class PushPostUseCase(
    private val postsRepository: PostsRepository
) : BaseUseCase<Post, Response<Post>>() {
    override suspend fun execute(params: Post): Response<Post> {
        return postsRepository.pushPost(params)
    }
}