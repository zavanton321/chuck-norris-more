package com.pastukhov.chucknorris.presentation

import android.widget.Toast
import com.pastukhov.chucknorris.data.ChackNorrisService
import com.pastukhov.chucknorris.data.model.RandomJokeModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
    var chackNorrisService: ChackNorrisService
) : IMainPresenter {

    var jokeModel: RandomJokeModel = RandomJokeModel("0", "0")

    override fun getRandomJoke(): RandomJokeModel {

        //  RxJava or coroutines

        // var jokeTest = RandomJokeModel("0", "0");

        CoroutineScope(Job() + Dispatchers.Main).launch {
            try {
                val response = ChackNorisApi.SERVICE.getRandomJoke()
                jokeModel = response.await()

            } catch (e: RuntimeException) {
                //Toast.makeText(this, "OOops!", Toast.LENGTH_SHORT).show()
            }
        }

        return jokeModel
    }
}