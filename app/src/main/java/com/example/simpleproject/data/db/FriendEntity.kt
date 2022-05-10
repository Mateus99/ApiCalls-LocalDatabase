package com.example.simpleproject.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friend")
data class FriendEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val phone: String
)