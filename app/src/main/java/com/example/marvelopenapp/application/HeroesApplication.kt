package com.example.marvelopenapp.application

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroesApplication: Application() {

    companion object{
        fun getRetrofitInstance(context: AppCompatActivity): Retrofit{
            return (context.application as HeroesApplication).getRetrofitInstance()
        }
    }


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    override fun onCreate() {
        super.onCreate()

    }

    fun getRetrofitInstance(): Retrofit {
        return retrofit
    }
}