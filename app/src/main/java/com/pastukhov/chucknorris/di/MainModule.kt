package com.pastukhov.chucknorris.di

import com.pastukhov.chucknorris.presentation.IMainPresenter
import com.pastukhov.chucknorris.presentation.MainPresenter
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun providePresenter(impl: MainPresenter): IMainPresenter
}