package com.example.simpleproject.domain.usecases

import com.example.simpleproject.data.db.FriendEntity
import com.example.simpleproject.domain.repository.FriendRepository

class CreateFriendUseCase(
    private val friendRepository: FriendRepository
) : BaseUseCase<FriendEntity, Unit>() {
    override suspend fun execute(params: FriendEntity) {
        friendRepository.createFriend(params)
    }
}