package com.pastukhov.chucknorris.data

import com.pastukhov.chucknorris.data.model.RandomJokeModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface ChackNorrisService {
    @GET("https://api.chucknorris.io/jokes/random")
    fun getRandomJoke(): Deferred<RandomJokeModel>
}