package com.example.simpleproject.data.db

data class CustomPostsData(
    val userId: Int,
    val sort: String,
    val order: String
)

data class CustomPosts2Data(
    val userId: Int,
    val options: Map<String, String>
)

data class PushPost2Data(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)