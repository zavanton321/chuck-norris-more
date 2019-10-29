package com.pastukhov.chucknorris.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pastukhov.chucknorris.App
import com.pastukhov.chucknorris.R
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        App.appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        presenter.getRandomJokeRxJava()


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
}
