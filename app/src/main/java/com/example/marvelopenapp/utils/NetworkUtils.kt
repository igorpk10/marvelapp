package com.example.marvelopenapp.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getRetrofitInstance(): Retrofit {
        return retrofit
    }

    companion object {
        val instance: NetworkUtils by lazy { NetworkUtils() }
    }
}