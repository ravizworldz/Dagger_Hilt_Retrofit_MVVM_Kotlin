package com.demo.daggerroomdbdemo.di

import com.demo.daggerroomdbdemo.network.RetroServieInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val baseURL = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun getRetroServieInstance(retrofit: Retrofit): RetroServieInstance {
        return retrofit.create(RetroServieInstance::class.java)
    }


    @Singleton
    @Provides
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}