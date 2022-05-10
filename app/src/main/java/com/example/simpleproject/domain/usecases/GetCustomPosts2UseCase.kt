package com.example.simpleproject.domain.usecases

import com.example.simpleproject.data.db.CustomPosts2Data
import com.example.simpleproject.domain.repository.PostsRepository
import com.example.simpleproject.model.Post
import retrofit2.Response

class GetCustomPosts2UseCase(
    private val postsRepository: PostsRepository
) : BaseUseCase<CustomPosts2Data, Response<List<Post>>>() {
    override suspend fun execute(params: CustomPosts2Data): Response<List<Post>> {
        return postsRepository.getCustomPosts2(params.userId, params.options)
    }
}