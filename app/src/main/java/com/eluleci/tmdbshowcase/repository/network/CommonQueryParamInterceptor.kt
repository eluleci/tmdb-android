package com.eluleci.tmdbshowcase.repository.network

import java.io.IOException
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Intercepts the request and adds common query params for all requests.
 */
class CommonQueryParamInterceptor(private val apiKey: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", apiKey)
                .addQueryParameter("format", "json")
                .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}
