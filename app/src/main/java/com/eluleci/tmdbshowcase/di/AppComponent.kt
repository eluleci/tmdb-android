package com.eluleci.tmdbshowcase.di

import android.app.Application

import com.eluleci.tmdbshowcase.TMDbApp
import com.eluleci.tmdbshowcase.service.repository.network.NetworkModule
import com.eluleci.tmdbshowcase.service.repository.RepositoryModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [
    NetworkModule::class,
    RepositoryModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<TMDbApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}