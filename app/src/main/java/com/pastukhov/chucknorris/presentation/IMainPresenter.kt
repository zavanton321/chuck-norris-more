package com.pastukhov.chucknorris.presentation

import com.pastukhov.chucknorris.data.model.RandomJokeDataModel

interface IMainPresenter {
    fun getRandomJokeCoroutine(): RandomJokeDataModel

    fun getRandomJokeRxJava()

    fun attachView(view: IMainView)
    fun detachView()
}