package com.example.simpleproject.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiModule {

}

fun client() =
    OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

fun gson(): Gson = GsonBuilder().create()

fun retrofit(): Retrofit =
    Retrofit.Builder()
        .baseUrl("url aqui")
        .client(client())
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .build()