package com.example.simpleproject.di

import com.example.simpleproject.data.db.AppDatabase
import com.example.simpleproject.domain.repository.FriendRepository
import com.example.simpleproject.domain.repository.FriendRepositoryImpl
import com.example.simpleproject.domain.repository.PostsRepository
import com.example.simpleproject.domain.repository.PostsRepositoryImpl
import com.example.simpleproject.domain.usecases.*
import com.example.simpleproject.view.FriendsListViewModel
import com.example.simpleproject.view.RetrofitCallsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AppDatabase.getDatabase(get()) }
    single { get<AppDatabase>().friendDao() }
}

val viewModelModule = module {
    viewModel { FriendsListViewModel(get(), get()) }
    viewModel { RetrofitCallsViewModel(get(), get(), get(), get(), get(), get()) }
}

val repositoryModule = module {
    single<FriendRepository> { FriendRepositoryImpl(get()) }
    single<PostsRepository> { PostsRepositoryImpl() }
}

val useCaseModule = module {
    factory { CreateFriendUseCase(get()) }
    factory { GetAllFriendsUseCase(get()) }
    factory { GetPostUseCase(get()) }
    factory { GetPost2UseCase(get()) }
    factory { GetCustomPostsUseCase(get()) }
    factory { GetCustomPosts2UseCase(get()) }
    factory { PushPostUseCase(get()) }
    factory { PushPost2UseCase(get()) }
}