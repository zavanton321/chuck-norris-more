package com.pastukhov.chucknorris.data

import com.pastukhov.chucknorris.data.model.ChuckNorrisModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface ChackNorisService {
    @GET("https://api.chucknorris.io/jokes/random")
    fun getRandomJoke(): Deferred<ChuckNorrisModel>
}