package com.example.simpleproject.domain.usecases

import com.example.simpleproject.domain.repository.PostsRepository
import com.example.simpleproject.model.Post
import retrofit2.Response

class GetPostUseCase(
    private val postsRepository: PostsRepository
) : BaseUseCase<BaseUseCase.None, Response<Post>>() {
    override suspend fun execute(params: None): Response<Post> {
        return postsRepository.getPost()
    }
}