package com.example.simpleproject.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleproject.data.db.CustomPosts2Data
import com.example.simpleproject.data.db.CustomPostsData
import com.example.simpleproject.data.db.PushPost2Data
import com.example.simpleproject.domain.usecases.*
import com.example.simpleproject.model.Post
import kotlinx.coroutines.launch
import retrofit2.Response

class RetrofitCallsViewModel(
    private val getPostUseCase: GetPostUseCase,
    private val getPost2UseCase: GetPost2UseCase,
    private val getCustomPostsUseCase: GetCustomPostsUseCase,
    private val GetCustomPosts2UseCase: GetCustomPosts2UseCase,
    private val pushPostUseCase: PushPostUseCase,
    private val pushPost2UseCase: PushPost2UseCase
) : ViewModel() {

    val myResponse = MutableLiveData<Response<Post>>()
    val myResponse2 = MutableLiveData<Response<Post>>()
    val myCustomPosts = MutableLiveData<Response<List<Post>>>()
    val myCustomPosts2 = MutableLiveData<Response<List<Post>>>()
    val myPost = MutableLiveData<Response<Post>>()
    val myPost2 = MutableLiveData<Response<Post>>()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = getPostUseCase(viewModelScope).await()
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = getPost2UseCase(viewModelScope, number).await()
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            myCustomPosts.value = getCustomPostsUseCase(viewModelScope, CustomPostsData(userId, sort, order)).await()
        }
    }

    fun getCustomPosts2(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            myCustomPosts2.value = GetCustomPosts2UseCase(viewModelScope, CustomPosts2Data(userId, options)).await()
        }
    }

    fun pushPost(post: Post) {
        viewModelScope.launch {
            myPost.value = pushPostUseCase(viewModelScope, post).await()
        }
    }

    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            myPost2.value = pushPost2UseCase(viewModelScope, PushPost2Data(userId, id, title, body)).await()
        }
    }
}