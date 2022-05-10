package com.example.simpleproject.domain.usecases

import com.example.simpleproject.domain.repository.PostsRepository
import com.example.simpleproject.model.Post
import retrofit2.Response

class GetPost2UseCase(
    private val postsRepository: PostsRepository
) : BaseUseCase<Int, Response<Post>>() {
    override suspend fun execute(params: Int): Response<Post> {
        return postsRepository.getPost2(params)
    }
}