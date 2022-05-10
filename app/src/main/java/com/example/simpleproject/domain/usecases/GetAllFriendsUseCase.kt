package com.example.simpleproject.domain.usecases

import com.example.simpleproject.data.db.FriendEntity
import com.example.simpleproject.domain.repository.FriendRepository

class GetAllFriendsUseCase(
    private val friendRepository: FriendRepository
) : BaseUseCase<BaseUseCase.None, List<FriendEntity>>() {
    override suspend fun execute(params: None): List<FriendEntity> {
        return friendRepository.getAllFriends()
    }
}