package com.pastukhov.chucknorris.presentation

import com.pastukhov.chucknorris.data.model.RandomJokeModel

interface IMainPresenter {
    fun getRandomJokeCoroutine(): RandomJokeModel
}