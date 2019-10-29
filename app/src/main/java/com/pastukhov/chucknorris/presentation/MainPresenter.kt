package com.pastukhov.chucknorris.presentation

import android.util.Log
import com.pastukhov.chucknorris.data.ChackNorrisServiceForCoroutine
import com.pastukhov.chucknorris.data.ChackNorrisService
import com.pastukhov.chucknorris.data.model.RandomJokeDataModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(
    var chackNorrisServiceForCoroutine: ChackNorrisServiceForCoroutine,
    var chackNorrisService: ChackNorrisService
) : IMainPresenter {

    private var view: IMainView? = null

    override fun attachView(view: IMainView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    var jokeDataModel: RandomJokeDataModel = RandomJokeDataModel("0", "0")

    private val compositeDisposable = CompositeDisposable()

    override fun getRandomJokeCoroutine(): RandomJokeDataModel {
        CoroutineScope(Job() + Dispatchers.Main).launch {
            try {
                val response = chackNorrisServiceForCoroutine.getRandomJoke()
                jokeDataModel = response.await()

            } catch (e: RuntimeException) {
                //Toast.makeText(this, "OOops!", Toast.LENGTH_SHORT).show()
            }
        }
        return jokeDataModel
    }

    override fun getRandomJokeRxJava() {
        compositeDisposable.add(
            chackNorrisService.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Log.d("zavanton", "zavanton - joke: $it")
                    },
                    {
                        Log.e("zavanton", "zavanton - error: $it")
                    }
                )
        )
    }
}