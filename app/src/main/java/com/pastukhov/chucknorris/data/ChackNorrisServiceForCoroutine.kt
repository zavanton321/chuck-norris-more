package com.pastukhov.chucknorris.data

import com.pastukhov.chucknorris.data.model.RandomJokeDataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface ChackNorrisServiceForCoroutine {
    @GET("https://api.chucknorris.io/jokes/random")
    fun getRandomJoke(): Deferred<RandomJokeDataModel>
}