package com.pastukhov.chucknorris.di

import com.pastukhov.chucknorris.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        RestModule::class,
        MainModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}