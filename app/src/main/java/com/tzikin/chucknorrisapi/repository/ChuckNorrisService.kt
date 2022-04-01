package com.tzikin.chucknorrisapi.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ChuckNorrisService {

    var base_url = "https://api.chucknorris.io/jokes/"

    fun create(): ChuckNorrisAPI{
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ChuckNorrisAPI::class.java)
    }
}