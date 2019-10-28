package com.pastukhov.chucknorris.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pastukhov.chucknorris.App
import com.pastukhov.chucknorris.R
import com.pastukhov.chucknorris.data.ChackNorrisService
import com.pastukhov.chucknorris.data.model.RandomJokeModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

private val BASE_URL = "https://api.chucknorris.io/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

object ChackNorisApi {
    val SERVICE: ChackNorrisService by lazy {
        retrofit.create(
            ChackNorrisService::class.java
        )
    }
}

class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        App.appComponent.inject(this)

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
        textView.text = presenter.getRandomJoke().value
    }
}
