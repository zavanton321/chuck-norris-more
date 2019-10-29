package com.pastukhov.chucknorris.data

import com.pastukhov.chucknorris.data.model.RandomJokeModel
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import java.util.*


interface ChackNorrisServiceForRxJava {
    @GET("https://api.chucknorris.io/jokes/random")
    fun getRandomJoke(): Observable
}