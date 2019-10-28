package com.pastukhov.chucknorris.presenter

import com.pastukhov.chucknorris.data.ChackNorisService
import com.pastukhov.chucknorris.App
import javax.inject.Inject

class PresenterRandomJoke {

    @Inject
    lateinit var chackNorisService: ChackNorisService

    init {
        App.appComponent.inject(this)
    }

    fun getRandomJoke() {

        //  RxJava or coroutines

    }
}