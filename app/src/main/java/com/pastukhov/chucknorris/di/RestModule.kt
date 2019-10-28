package com.pastukhov.chucknorris.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pastukhov.chucknorris.data.ChackNorisService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private val BASE_URL = "https://api.chucknorris.io/"

@Module
class RestModule {

    @Provides
    @Singleton
    fun provideChackNorris(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


    @Provides
    @Singleton
    fun provideChackNorrisApiService(retrofit: Retrofit): ChackNorisService =
        retrofit.create(ChackNorisService::class.java)
}