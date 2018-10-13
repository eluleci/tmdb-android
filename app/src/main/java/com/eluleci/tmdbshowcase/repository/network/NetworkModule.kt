package com.eluleci.tmdbshowcase.repository.network

import com.eluleci.tmdbshowcase.BuildConfig

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Provides Retrofit services for injection.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideTMDbService(): TMDbService {

        // create OkHttpClient and add interceptor for
        // adding common query parameters to all requests
        val clientBuilder = OkHttpClient.Builder()
                .addInterceptor(CommonQueryParamInterceptor(BuildConfig.API_KEY))

        // add interceptor to log the request and response info if env is debug
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        return Retrofit.Builder()
                .client(clientBuilder.build())
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TMDbService::class.java)
    }
}
