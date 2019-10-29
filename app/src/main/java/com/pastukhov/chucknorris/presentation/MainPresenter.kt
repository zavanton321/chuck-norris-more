package com.pastukhov.chucknorris.presentation

import com.pastukhov.chucknorris.App
import com.pastukhov.chucknorris.data.ChackNorrisServiceForCoroutine
import com.pastukhov.chucknorris.data.ChackNorrisServiceForRxJava
import com.pastukhov.chucknorris.data.model.RandomJokeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
    var chackNorrisServiceForCoroutine: ChackNorrisServiceForCoroutine,
    var chackNorrisServiceForRxJava: ChackNorrisServiceForRxJava
) : IMainPresenter {

    var jokeModel: RandomJokeModel = RandomJokeModel("0", "0")



    override fun getRandomJokeCoroutine(): RandomJokeModel {
        CoroutineScope(Job() + Dispatchers.Main).launch {
            try {
                val response = chackNorrisServiceForCoroutine.getRandomJoke()
                jokeModel = response.await()

            } catch (e: RuntimeException) {
                //Toast.makeText(this, "OOops!", Toast.LENGTH_SHORT).show()
            }
        }
        return jokeModel
    }

    override fun getRandomJokeRxJava(): RandomJokeModel {

        val randomJoke: Observable = chackNorrisServiceForRxJava.getRandomJoke()


//        if (execute.isSuccessful){
//            return execute.body()?: RandomJokeModel("1","1")
//        }

        return RandomJokeModel("1","1")
    }
}