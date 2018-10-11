package com.eluleci.tmdbshowcase

import com.eluleci.tmdbshowcase.di.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TMDbApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}
