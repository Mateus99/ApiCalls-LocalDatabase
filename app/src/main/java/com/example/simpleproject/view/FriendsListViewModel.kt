package com.example.simpleproject.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleproject.data.db.FriendEntity
import com.example.simpleproject.domain.usecases.CreateFriendUseCase
import com.example.simpleproject.domain.usecases.GetAllFriendsUseCase
import kotlinx.coroutines.launch

class FriendsListViewModel(
    private val createFriendUseCase: CreateFriendUseCase,
    private val getAllFriendsUseCase: GetAllFriendsUseCase
) : ViewModel() {

    val friendsList = MutableLiveData<List<FriendEntity>>()

    fun createFriend(name: String, phone: String) {
        viewModelScope.launch {
            createFriendUseCase(viewModelScope, FriendEntity(name = name, phone = phone)).await()
            getAllFriends()
        }
    }

    fun getAllFriends() {
        viewModelScope.launch {
            friendsList.value = getAllFriendsUseCase(viewModelScope).await()
        }
    }
}