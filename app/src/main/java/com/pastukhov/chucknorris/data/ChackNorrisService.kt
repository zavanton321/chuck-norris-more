package com.pastukhov.chucknorris.data

import com.pastukhov.chucknorris.data.model.RandomJokeDataModel
import io.reactivex.Observable
import retrofit2.http.GET


interface ChackNorrisService {

    @GET("https://api.chucknorris.io/jokes/random")
    fun getRandomJoke(): Observable<RandomJokeDataModel>
}