package com.pastukhov.chucknorris

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET


interface ChackNorisService {
    @GET("https://api.chucknorris.io/jokes/random")
    fun getRandomJoke(): Deferred<ChuckNorrisModel>
}