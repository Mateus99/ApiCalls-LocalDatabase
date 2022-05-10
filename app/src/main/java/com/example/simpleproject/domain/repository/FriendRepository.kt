package com.example.simpleproject.domain.repository

import com.example.simpleproject.data.db.FriendEntity

interface FriendRepository {
    suspend fun createFriend(friendEntity: FriendEntity)

    suspend fun getFriend(id: Long): FriendEntity

    suspend fun getAllFriends(): List<FriendEntity>
}