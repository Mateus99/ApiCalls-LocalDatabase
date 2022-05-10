package com.example.simpleproject.domain.usecases

import com.example.simpleproject.data.db.PushPost2Data
import com.example.simpleproject.domain.repository.PostsRepository
import com.example.simpleproject.model.Post
import retrofit2.Response

class PushPost2UseCase(
    private val postsRepository: PostsRepository
) : BaseUseCase<PushPost2Data, Response<Post>>() {
    override suspend fun execute(params: PushPost2Data): Response<Post> {
        return postsRepository.pushPost2(params.userId, params.id, params.title, params.body)
    }
}