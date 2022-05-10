package com.example.simpleproject.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simpleproject.data.db.FriendEntity

@Dao
interface FriendDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFriend(friend: FriendEntity)

    @Query("SELECT * FROM friend WHERE id = :id")
    suspend fun getFriend(id: Long): FriendEntity

    @Query("SELECT * FROM friend")
    suspend fun getAllFriends(): List<FriendEntity>
}