package com.pastukhov.chucknorris

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL = "https://api.chucknorris.io/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

object ChackNorisApi {
    val service: ChackNorisService by lazy { retrofit.create(ChackNorisService::class.java) }
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        interactor.getData()
//            .subscribeOn()
//            .observeOn()
//            .subscribe(
//                onNext = {
//                    view.showResul()
//                },
//                onComplete{ },
//                onErrro{}
//            )
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing) {

        }
    }

    fun getRandomJoke(view: View) {



        CoroutineScope(Job() + Dispatchers.Main).launch {
            try {
                val response = ChackNorisApi.service.getRandomJoke()
                val joke: ChuckNorrisModel = response.await()
                textView.text = joke.value
            } catch (e: RuntimeException) {
                Toast.makeText(applicationContext, "OOops!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
