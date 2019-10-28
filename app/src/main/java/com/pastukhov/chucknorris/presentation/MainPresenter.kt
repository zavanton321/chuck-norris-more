package com.pastukhov.chucknorris.presentation

import com.pastukhov.chucknorris.data.ChackNorisService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
    var chackNorisService: ChackNorisService
) : IMainPresenter {

    fun getRandomJoke() {

        //  RxJava or coroutines
    }
}