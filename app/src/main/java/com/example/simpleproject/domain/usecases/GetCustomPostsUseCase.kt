package com.example.simpleproject.domain.usecases

import com.example.simpleproject.data.db.CustomPostsData
import com.example.simpleproject.domain.repository.PostsRepository
import com.example.simpleproject.model.Post
import retrofit2.Response

class GetCustomPostsUseCase(
    private val postsRepository: PostsRepository
) : BaseUseCase<CustomPostsData, Response<List<Post>>>() {
    override suspend fun execute(params: CustomPostsData): Response<List<Post>> {
        return postsRepository.getCustomPosts(params.userId, params.sort, params.order)
    }
}