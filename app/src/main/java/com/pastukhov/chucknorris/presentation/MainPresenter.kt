package com.pastukhov.chucknorris.presentation

import com.pastukhov.chucknorris.data.ChackNorrisServiceForCoroutine
import com.pastukhov.chucknorris.data.model.RandomJokeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
    var chackNorrisServiceForCoroutine: ChackNorrisServiceForCoroutine
) : IMainPresenter {

    var jokeModel: RandomJokeModel = RandomJokeModel("0", "0")

    override fun getRandomJokeCoroutine(): RandomJokeModel {

        CoroutineScope(Job() + Dispatchers.Main).launch {
            try {
                val response = ChackNorisApi.SERVICE_FOR_COROUTINE.getRandomJoke()
                jokeModel = response.await()

            } catch (e: RuntimeException) {
                //Toast.makeText(this, "OOops!", Toast.LENGTH_SHORT).show()
            }
        }
        return jokeModel
    }
}