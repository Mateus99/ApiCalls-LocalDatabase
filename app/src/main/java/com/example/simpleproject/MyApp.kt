package com.example.simpleproject

import android.app.Application
import com.example.simpleproject.di.appModule
import com.example.simpleproject.di.repositoryModule
import com.example.simpleproject.di.useCaseModule
import com.example.simpleproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule, useCaseModule))
        }
    }
}