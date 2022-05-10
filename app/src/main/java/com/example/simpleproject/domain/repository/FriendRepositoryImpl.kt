package com.example.simpleproject.domain.repository

import com.example.simpleproject.data.db.FriendEntity
import com.example.simpleproject.data.db.dao.FriendDao

class FriendRepositoryImpl(
    private val friendDao: FriendDao
) : FriendRepository {
    override suspend fun createFriend(friendEntity: FriendEntity) {
        friendDao.saveFriend(friendEntity)
    }

    override suspend fun getFriend(id: Long): FriendEntity {
        return friendDao.getFriend(id)
    }

    override suspend fun getAllFriends(): List<FriendEntity> {
        return friendDao.getAllFriends()
    }
}