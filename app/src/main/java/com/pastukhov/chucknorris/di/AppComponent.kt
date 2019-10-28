package com.pastukhov.chucknorris.di

import com.pastukhov.chucknorris.activities.MainActivity
import com.pastukhov.chucknorris.presenter.PresenterRandomJoke
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RestModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(presenter: PresenterRandomJoke)
}